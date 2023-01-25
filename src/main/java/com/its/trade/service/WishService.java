package com.its.trade.service;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.DTO.WishDTO;
import com.its.trade.entity.SaleEntity;
import com.its.trade.entity.UserEntity;
import com.its.trade.entity.WishEntity;
import com.its.trade.repository.SaleRepository;
import com.its.trade.repository.UserRepository;
import com.its.trade.repository.WishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishService {
    private final WishRepository wishRepository;
    private final UserRepository userRepository;
    private final SaleRepository saleRepository;

    public List<WishDTO> findAll() {
        List<WishEntity> wishEntityList = wishRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        List<WishDTO> wishDTOList = new ArrayList<>();

        for (WishEntity wishEntity : wishEntityList) {
            wishDTOList.add(WishDTO.toWishDTO(wishEntity));
        }

        return wishDTOList;
    }

    @Transactional
    public boolean check(WishDTO wishDTO) {
        Optional<WishEntity> wishEntity = wishRepository.findBySaleEntityIdAndUserEntityId(wishDTO.getSaleId(), wishDTO.getUserId());

        if (wishEntity.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    @Transactional
    public Long save(WishDTO wishDTO) {
        UserEntity userEntity = userRepository.findById(wishDTO.getUserId()).get();
        SaleEntity saleEntity = saleRepository.findById(wishDTO.getSaleId()).get();

        return wishRepository.save(WishEntity.toWishSaveEntity(userEntity, saleEntity)).getId();
    }

}
