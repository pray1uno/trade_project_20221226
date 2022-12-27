package com.its.trade.DTO;

import com.its.trade.entity.SaleEntity;
import com.its.trade.entity.SaleFileEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class SaleDTO {
    private Long id;
    private String itemCategory;
    private String itemName;
    private int itemPrice;
    private int itemCount;
    private String fileAttached;
    private String sellerName;
    private int itemHits;
    private LocalDateTime itemCreatedTime;
    private LocalDateTime itemUpdatedTime;

    private MultipartFile saleFile;
    private String originalFileName;
    private String storedFileName;

    public static SaleDTO toSaleDTO(SaleEntity saleEntity) {
        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setId(saleEntity.getId());
        saleDTO.setItemCategory(saleEntity.getItemCategory());
        saleDTO.setItemName(saleEntity.getItemName());
        saleDTO.setItemPrice(saleEntity.getItemPrice());
        saleDTO.setItemCount(saleEntity.getItemCount());
        saleDTO.setSellerName(saleEntity.getSellerName());
        saleDTO.setItemHits(saleEntity.getItemHits());
        saleDTO.setItemCreatedTime(saleEntity.getCreatedTime());
        saleDTO.setItemUpdatedTime(saleEntity.getUpdatedTime());

        if (saleEntity.getFileAttached().equals("Y")) {
            saleDTO.setFileAttached(saleEntity.getFileAttached());

            List<String> originalFileNameList = new ArrayList<>();
            List<String> storedFileNameList = new ArrayList<>();

            for (SaleFileEntity saleFileEntity : saleEntity.getSaleFileEntityList()) {
                originalFileNameList.add(saleFileEntity.getOriginalFileName());
                storedFileNameList.add(saleFileEntity.getStoredFileName());
            }

            saleDTO.setOriginalFileName(originalFileNameList.toString());
            saleDTO.setStoredFileName(storedFileNameList.toString());

        } else {
            saleDTO.setFileAttached(saleEntity.getFileAttached());
        }

        return saleDTO;
    }
}
