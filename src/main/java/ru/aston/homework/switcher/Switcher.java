package ru.aston.homework.switcher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.aston.homework.dao.UserDAO;
import ru.aston.homework.entity.UserDTO;
import ru.aston.homework.service.MapperUserDtoToUserEntity;
import ru.aston.homework.service.Service;
import ru.aston.homework.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@NoArgsConstructor
public class Switcher {

    @Getter
    private boolean running = true;

    private final Service<UserDTO> service = new UserService(
            new UserDAO(), new MapperUserDtoToUserEntity());

    public void stopRunning() {
        running = false;
        System.out.println("exit from program");
    }

    public UserDTO findUser(BufferedReader reader) throws IOException {
        System.out.println("input id from user: ");
        Long id = Long.parseLong(reader.readLine());
        UserDTO user = service.findByID(id);
        System.out.println("Found: " + user);
        return user;
    }

    public void deleteUser(BufferedReader reader) throws IOException {
        System.out.print("For DELETE ");
        UserDTO user = findUser(reader);
        if (user != null) {
            service.deleteUser(user);
            System.out.println("User is terminated");
        } else {
            System.out.println("User not found");
        }
    }

    public void updateUser(BufferedReader reader) throws IOException {
        System.out.print("For UPDATE ");
        UserDTO user = findUser(reader);
        if (user == null) {
            System.out.println("User not found");
        } else {
            user.setName(setName(reader));
            user.setEmail(setEmail(reader));
            user.setAge(setAge(reader));
            service.updateUser(user);
        }
    }

    public void showAllUsers() {
        List<UserDTO> users = service.findAll();
        users.forEach(System.out::println);
    }

    public void saveUser(BufferedReader reader) throws IOException {
        UserDTO user = new UserDTO(setName(reader), setEmail(reader), setAge(reader));
        service.saveUser(user);
        System.out.println("Saved: " + user);
    }

    private String setName(BufferedReader reader) throws IOException {
        System.out.println("Enter name:");
        return reader.readLine();
    }

    private String setEmail(BufferedReader reader) throws IOException {
        System.out.println("Enter email:");
        return reader.readLine();
    }

    private int setAge(BufferedReader reader) throws IOException {
        System.out.println("Enter age:");
        return Integer.parseInt(reader.readLine());
    }
}
