package com.its.trade.DTO;

import com.its.trade.entity.UserEntity;
import com.its.trade.entity.UserProfileEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String userName;
    private String userPassword;
    private String userMobile;
    private int userRole;
    private String fileAttached;

    private MultipartFile userProfile;
    private String originalFileName;
    private String storedFileName;

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userEntity.getId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserPassword(userEntity.getUserPassword());
        userDTO.setUserMobile(userEntity.getUserMobile());
        userDTO.setUserRole(userEntity.getUserRole());

        if (userEntity.getFileAttached().equals("Y")) {
            userDTO.setFileAttached(userEntity.getFileAttached());

            List<String> originalFileNameList = new ArrayList<>();
            List<String> storedFileNameList = new ArrayList<>();

            for (UserProfileEntity userProfileEntity : userEntity.getUserProfileEntityList()) {
                originalFileNameList.add(userProfileEntity.getOriginalFileName());
                storedFileNameList.add(userProfileEntity.getStoredFileName());
            }

            userDTO.setOriginalFileName(originalFileNameList.toString());
            userDTO.setStoredFileName(storedFileNameList.toString());

        } else {
            userDTO.setFileAttached(userEntity.getFileAttached());
        }

        return userDTO;
    }

}
