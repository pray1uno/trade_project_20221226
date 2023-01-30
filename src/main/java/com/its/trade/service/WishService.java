package com.its.trade.service;

import com.its.trade.DTO.WishDTO;
import com.its.trade.entity.SaleEntity;
import com.its.trade.entity.UserEntity;
import com.its.trade.entity.WishEntity;
import com.its.trade.repository.SaleRepository;
import com.its.trade.repository.UserRepository;
import com.its.trade.repository.WishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class WishService {
    private final WishRepository wishRepository;
    private final UserRepository userRepository;
    private final SaleRepository saleRepository;

    @Transactional
    public int addWish(WishDTO wishDTO) {
        Long saleId = wishDTO.getSaleId();
        Long userId = wishDTO.getUserId();

        WishEntity wishEntity = wishRepository.findByWishList(saleId, userId);

        if (wishEntity != null) {
            return 2;
        } else {
            UserEntity userEntity = userRepository.findById(userId).get();
            SaleEntity saleEntity = saleRepository.findById(saleId).get();

            WishEntity result = WishEntity.createWishList(saleEntity, userEntity);
            wishRepository.save(result);
            return 1;
        }
    }

}
