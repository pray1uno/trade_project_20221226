package com.its.trade.repository;

import com.its.trade.entity.SaleEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
    @Modifying
    @Query(value = "update SaleEntity s set s.itemHits = s.itemHits+1 where s.id = :id")
    void updateHits(@Param("id") Long id);


    List<SaleEntity> findByItemCategory(String weapon, Sort id);

}
