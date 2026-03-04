package ru.aston.homework.switcher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.aston.homework.dao.UserDAOIMPL;
import ru.aston.homework.entity.User;
import ru.aston.homework.service.Service;
import ru.aston.homework.service.UserServiceIMPL;

import java.io.BufferedReader;
import java.io.IOException;

@NoArgsConstructor
public class Switcher {

    @Getter
    private boolean running = true;

    private final Service<User> service = new UserServiceIMPL(new UserDAOIMPL());

    public void stopRunning() {
        running = false;
        System.out.println("exit from program");
    }

    public User findUser(BufferedReader reader) throws IOException {
        System.out.println("input id from user: ");
        int id = Integer.parseInt(reader.readLine());
        User user = service.findUser(id);
        System.out.println("Found: " + user);
        return user;
    }

    public void deleteUser(BufferedReader reader) throws IOException {
        System.out.print("For DELETE ");
        User user = findUser(reader);
        if (user != null) {
            service.deleteUser(user);
            System.out.println("User is terminated");
        } else {
            System.out.println("User not found");
        }
    }

    public void updateUser(BufferedReader reader) throws IOException {
        System.out.print("For UPDATE ");
        User user = findUser(reader);
        if (user == null) {
            System.out.println("User not found");
        } else {
            user.setName(setName(reader));
            user.setEmail(setEmail(reader));
            user.setAge(setAge(reader));
            service.updateUser(user);
        }
    }

    public void saveUser(BufferedReader reader) throws IOException {
        User user = new User(setName(reader), setEmail(reader), setAge(reader));
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
