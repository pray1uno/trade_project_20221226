package com.its.trade.service;

import com.its.trade.DTO.UserDTO;
import com.its.trade.entity.UserEntity;
import com.its.trade.entity.UserProfileEntity;
import com.its.trade.repository.UserProfileRepository;
import com.its.trade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public void save(UserDTO userDTO) throws IOException {
        if (userDTO.getUserProfile().isEmpty()) {
            UserEntity userEntity = UserEntity.toUserSaveEntity(userDTO);
            userRepository.save(userEntity);
        } else {
            MultipartFile userProfile = userDTO.getUserProfile();
            String originalFileName = userProfile.getOriginalFilename();
            String storedFileName = System.currentTimeMillis() + "_" + originalFileName;
            String savePath = "D:\\spring_boot_project_img\\" + storedFileName;
            userProfile.transferTo(new File(savePath));

            UserEntity userEntity = UserEntity.toUserProfileSaveEntity(userDTO);
            UserProfileEntity userProfileEntity = UserProfileEntity.toSaveProfileEntity(userEntity, originalFileName, storedFileName);

            userRepository.save(userEntity);
            userProfileRepository.save(userProfileEntity);
        }
    }

    @Transactional
    public UserDTO login(UserDTO userDTO) {
        String userName = userDTO.getUserName();

        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userName);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            if (userEntity.getUserPassword().equals(userDTO.getUserPassword())) {
                return UserDTO.toUserDTO(userEntity);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public String duplicateCheck(String userName) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userName);

        if (optionalUserEntity.isPresent()) {
            return null;
        } else {
            return "Y";
        }
    }

    @Transactional
    public UserDTO findByUserName(String userName) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userName);

        if (optionalUserEntity.isPresent()) {
            return UserDTO.toUserDTO(optionalUserEntity.get());
        } else {
            return null;
        }
    }


    public void update(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toUserUpdateEntity(userDTO);
        userRepository.save(userEntity);

    }

}
