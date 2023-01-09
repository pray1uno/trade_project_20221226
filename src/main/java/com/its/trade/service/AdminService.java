package com.its.trade.service;

import com.its.trade.DTO.UserDTO;
import com.its.trade.entity.UserEntity;
import com.its.trade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    @Transactional
    public List<UserDTO> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();

        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            UserDTO result = UserDTO.toUserDTO(userEntity);
            userDTOList.add(result);
        }
        return userDTOList;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void withdraw(Long id) {
        userRepository.withdraw(id);
    }

    @Transactional
    public void give(Long id) {
        userRepository.give(id);
    }
}
