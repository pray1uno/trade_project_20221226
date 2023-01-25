package com.its.trade.entity;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.DTO.UserDTO;
import com.its.trade.DTO.WishDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "wishList_table")
public class WishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(length = 20)
//    private String wishName;
//
//    @Column(length = 14)
//    private int wishPrice;
//
//    @Column(length = 4)
//    private int wishCount;

    @Column(length = 15)
    private String totalPrice;

    @Column(length = 4)
    private int totalCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private SaleEntity saleEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;


    public static WishEntity toWishSaveEntity(UserEntity userEntity, SaleEntity saleEntity) {
        WishEntity wishEntity = new WishEntity();

//        wishEntity.setWishName(wishDTO.getWishName());
//        wishEntity.setWishPrice(wishDTO.getWishPrice());
//        wishEntity.setWishCount(wishDTO.getWishCount());
        wishEntity.setUserEntity(userEntity);
        wishEntity.setSaleEntity(saleEntity);

        return wishEntity;
    }
}
