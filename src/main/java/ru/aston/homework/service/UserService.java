package ru.aston.homework.service;

import ru.aston.homework.dao.DAO;
import ru.aston.homework.dto.UserDTO;
import ru.aston.homework.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Service<UserDTO> {

    private final DAO<UserEntity> userDAO;
    private final Mapper<UserEntity, UserDTO> mapper;

    public UserService(DAO<UserEntity> userDAO, Mapper<UserEntity, UserDTO> mapper) {
        this.userDAO = userDAO;
        this.mapper = mapper;
    }

    @Override
    public UserDTO findByID(Long id) {
        System.out.println("Try find user with id: " + id);
        return mapper.convertToDTO(userDAO.findById(id));
    }

    @Override
    public void saveUser(UserDTO user) {
        System.out.println("Tru save user: " + user.toString());
        userDAO.save(mapper.convertToEntity(user));
    }

    @Override
    public void deleteUser(UserDTO user) {
        System.out.println("Try delete user: " + user.toString());
        userDAO.delete(mapper.convertToEntity(user));
    }

    @Override
    public void updateUser(UserDTO user) {
        System.out.println("Try update user: " + user.toString());
        userDAO.update(mapper.convertToEntity(user));
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> entityList = userDAO.findAll();
        if (entityList == null) {
            return null;
        }
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity userEntity : entityList) {
            userDTOList.add(mapper.convertToDTO(userEntity));
        }
        return userDTOList;
    }
}
