package com.its.trade.entity;

import com.its.trade.DTO.SaleDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sale_table")
public class SaleEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String itemCategory;

    @Column(nullable = false)
    private String itemName;

    @Column(length = 14)
    private int itemPrice;

    @Column(length = 4)
    private int itemCount;

    @Column
    private String fileAttached;

    @Column(length = 20)
    private String sellerName;

    @Column
    private int itemHits;

    @OneToMany(mappedBy = "saleEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WishEntity> wishEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "saleEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PurchaseEntity> purchaseEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "saleEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SaleFileEntity> saleFileEntityList = new ArrayList<>();

    public static SaleEntity toSaleSaveEntity(SaleDTO saleDTO) {
        SaleEntity saleEntity = new SaleEntity();

        saleEntity.setItemCategory(saleDTO.getItemCategory());
        saleEntity.setItemName(saleDTO.getItemName());
        saleEntity.setItemPrice(saleDTO.getItemPrice());
        saleEntity.setItemCount(saleDTO.getItemCount());
        saleEntity.setFileAttached("N");
        saleEntity.setItemHits(0);

        return saleEntity;
    }

    public static SaleEntity toSaleSaveFileEntity(SaleDTO saleDTO) {
        SaleEntity saleEntity = new SaleEntity();

        saleEntity.setItemCategory(saleDTO.getItemCategory());
        saleEntity.setItemName(saleDTO.getItemName());
        saleEntity.setItemPrice(saleDTO.getItemPrice());
        saleEntity.setItemCount(saleDTO.getItemCount());
        saleEntity.setFileAttached("Y");
        saleEntity.setItemHits(0);

        return saleEntity;
    }
}
