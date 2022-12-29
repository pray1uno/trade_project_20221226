package com.its.trade.entity;

import com.its.trade.DTO.UserDTO;
import com.its.trade.repository.UserProfileRepository;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_profile_table")
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile")
    private UserEntity userEntity;

    public static UserProfileEntity toSaveProfileEntity(UserEntity entity, String originalFileName, String storedFileName) {
        UserProfileEntity userProfileEntity = new UserProfileEntity();

        userProfileEntity.setOriginalFileName(originalFileName);
        userProfileEntity.setStoredFileName(storedFileName);
        userProfileEntity.setUserEntity(entity);

        return userProfileEntity;
    }
}
