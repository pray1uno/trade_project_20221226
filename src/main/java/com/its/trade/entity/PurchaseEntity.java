package com.its.trade.entity;

import com.its.trade.DTO.PurchaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "purchase_table")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String purchaserName;

    @Column(length = 14)
    private int purchasePrice;

    @Column(length = 4)
    private int purchaseCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private SaleEntity saleEntity;

    public static PurchaseEntity toSavePurchaseEntity(UserEntity userEntity, SaleEntity saleEntity, PurchaseDTO purchaseDTO) {
        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setPurchaserName(purchaseDTO.getPurchaserName());
        purchaseEntity.setPurchaseCount(purchaseDTO.getPurchaseCount());
        purchaseEntity.setUserEntity(userEntity);
        purchaseEntity.setSaleEntity(saleEntity);

        return purchaseEntity;
    }
}
