package com.its.trade.repository;

import com.its.trade.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserName(String userName);

    @Modifying
    @Query(value = "update UserEntity u set u.userRole = 2 where u.id = :id")
    void withdraw(@Param("id") Long id);

    @Modifying
    @Query(value = "update UserEntity u set u.userRole = 1 where u.id = :id")
    void give(@Param("id") Long id);
}
