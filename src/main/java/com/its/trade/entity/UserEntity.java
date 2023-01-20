package com.its.trade.entity;

import com.its.trade.DTO.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String userName;

    @Column(nullable = false, length = 30)
    private String userPassword;

    @Column(length = 15)
    private String userMobile;

    @Column(length = 1)
    private int userRole;

    @Column
    private String fileAttached;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PurchaseEntity> purchaseEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WishEntity> wishEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserProfileEntity> userProfileEntityList = new ArrayList<>();

    public static UserEntity toUserSaveEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserPassword(userDTO.getUserPassword());
        userEntity.setUserMobile(userDTO.getUserMobile());
        userEntity.setUserRole(1);
        userEntity.setFileAttached("N");

        return userEntity;
    }

    public static UserEntity toUserProfileSaveEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserPassword(userDTO.getUserPassword());
        userEntity.setUserMobile(userDTO.getUserMobile());
        userEntity.setUserRole(1);
        userEntity.setFileAttached("Y");


        return userEntity;
    }

    public static UserEntity toUserUpdateEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(userDTO.getId());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserPassword(userDTO.getUserPassword());
        userEntity.setUserMobile(userDTO.getUserMobile());
        userEntity.setUserRole(userDTO.getUserRole());
        userEntity.setFileAttached(userDTO.getFileAttached());

        return userEntity;
    }

}
