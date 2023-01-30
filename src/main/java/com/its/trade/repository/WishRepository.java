package com.its.trade.repository;

import com.its.trade.entity.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface WishRepository extends JpaRepository<WishEntity, Long> {
    @Query(value = "select w from WishEntity w where w.saleEntity.id = :saleId and w.userEntity.id = :userId")
    WishEntity findByWishList(@Param("saleId") Long saleId,
                              @Param("userId") Long userId);

}
