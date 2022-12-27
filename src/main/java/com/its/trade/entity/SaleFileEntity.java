package com.its.trade.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "sale_file_table")
public class SaleFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_file")
    private SaleEntity saleEntity;

    public static SaleFileEntity toSaveSaleFileEntity(SaleEntity entity, String originalFileName, String storedFileName) {
        SaleFileEntity saleFileEntity = new SaleFileEntity();

        saleFileEntity.setOriginalFileName(originalFileName);
        saleFileEntity.setStoredFileName(storedFileName);
        saleFileEntity.setSaleEntity(entity);

        return saleFileEntity;
    }
}
