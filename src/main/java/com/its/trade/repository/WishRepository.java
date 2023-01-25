package com.its.trade.repository;

import com.its.trade.entity.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishRepository extends JpaRepository<WishEntity, Long> {
    Optional<WishEntity> findBySaleEntityIdAndUserEntityId(Long saleId, Long userId);
//
//    List<WishEntity> findByUserEntityId(Long userId);


}
