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
    private String subCategory;
    private String itemName;
    private String itemPrice;
    private int itemCount;
    private String fileAttached;
    private String sellerName;
    private int itemHits;
    private LocalDateTime itemCreatedTime;
    private LocalDateTime itemUpdatedTime;

    private List<MultipartFile> saleFile;
    private List<String> originalFileName;
    private List<String> storedFileName;
    private String thumbnail;

    public SaleDTO() {

    }

    public SaleDTO(Long id, String itemCategory, String subCategory, String itemName, String itemPrice, int itemCount, String sellerName, int itemHits, LocalDateTime itemCreatedTime, List<SaleFileEntity> storedFileName) {
        this.id = id;
        this.itemCategory = itemCategory;
        this.subCategory = subCategory;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.sellerName = sellerName;
        this.itemHits = itemHits;
        this.itemCreatedTime = itemCreatedTime;
//        this.storedFileName = storedFileName;

        for (int i=0; i < storedFileName.size(); i++) {
            String th = storedFileName.get(i).getStoredFileName();
            this.thumbnail = th;
        }
    }

    public static SaleDTO toSaleDTO(SaleEntity saleEntity) {
        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setId(saleEntity.getId());
        saleDTO.setItemCategory(saleEntity.getItemCategory());
        saleDTO.setSubCategory(saleEntity.getSubCategory());
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

//            saleDTO.setOriginalFileName(originalFileNameList.toString());
//            saleDTO.setStoredFileName(storedFileNameList.toString());

            saleDTO.setOriginalFileName(originalFileNameList);
            saleDTO.setStoredFileName(storedFileNameList);

        } else {
            saleDTO.setFileAttached(saleEntity.getFileAttached());
        }

        return saleDTO;
    }
}
