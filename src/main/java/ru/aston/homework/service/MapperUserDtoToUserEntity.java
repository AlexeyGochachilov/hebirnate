package ru.aston.homework.service;

import ru.aston.homework.entity.UserDTO;
import ru.aston.homework.entity.UserEntity;

public class MapperUserDtoToUserEntity implements Mapper<UserEntity, UserDTO> {

    @Override
    public UserEntity convertToEntity(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setAge(userDTO.getAge());
        userEntity.setEmail(userDTO.getEmail());
        return userEntity;
    }

    @Override
    public UserDTO convertToDTO(UserEntity userEntity) {
        if(userEntity == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setAge(userEntity.getAge());
        return userDTO;
    }
}
