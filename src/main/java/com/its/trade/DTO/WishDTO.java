package com.its.trade.DTO;

import com.its.trade.entity.WishEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WishDTO {
    private Long id;
//    private String wishName;
//    private int wishPrice;
//    private int wishCount;
    private Long saleId;
    private Long userId;

    private String totalPrice;
    private int totalCount;
//    private String wishFileName;

    public static WishDTO toWishDTO(WishEntity wishEntity) {
        WishDTO wishDTO = new WishDTO();

        wishDTO.setId(wishEntity.getId());
//        wishDTO.setWishName(wishEntity.getWishName());
//        wishDTO.setWishPrice(wishEntity.getWishPrice());
//        wishDTO.setWishCount(wishEntity.getWishCount());
        wishDTO.setSaleId(wishEntity.getSaleEntity().getId());
        wishDTO.setUserId(wishEntity.getUserEntity().getId());

//        wishDTO.setTotalPrice(wishEntity.getSaleEntity().getItemPrice());
//        wishDTO.setTotalCount(wishEntity.getSaleEntity().getItemCount());

        wishDTO.setTotalPrice(wishEntity.getTotalPrice());
        wishDTO.setTotalCount(wishEntity.getTotalCount());

        return wishDTO;
    }
}
