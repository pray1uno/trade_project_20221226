package com.its.trade.DTO;

import com.its.trade.entity.PurchaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PurchaseDTO {
    private Long id;
    private String purchaserName;
    private int purchasePrice;
    private int purchaseCount;
    private Long userId;
    private Long saleId;

    public static PurchaseDTO toPurchaseDTO (PurchaseEntity purchaseEntity) {
        PurchaseDTO purchaseDTO = new PurchaseDTO();

        purchaseDTO.setId(purchaseEntity.getId());
        purchaseDTO.setPurchaserName(purchaseEntity.getPurchaserName());
        purchaseDTO.setPurchasePrice(purchaseEntity.getPurchasePrice());
        purchaseDTO.setPurchaseCount(purchaseEntity.getPurchaseCount());
        purchaseDTO.setUserId(purchaseEntity.getUserEntity().getId());
        purchaseDTO.setSaleId(purchaseEntity.getSaleEntity().getId());

        return purchaseDTO;
    }
}
