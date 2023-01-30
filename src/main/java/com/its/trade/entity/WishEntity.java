package com.its.trade.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "wishList_table")
public class WishEntity {
    @Id
    @Column(name = "wish_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private SaleEntity saleEntity;


    public static WishEntity createWishList(SaleEntity saleEntity, UserEntity userEntity) {
        WishEntity wishEntity = new WishEntity();

        wishEntity.setSaleEntity(saleEntity);
        wishEntity.setUserEntity(userEntity);

        return wishEntity;
    }

}
