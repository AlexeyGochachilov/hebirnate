package ru.aston.homework;

import ru.aston.homework.factory.HibernateSessionFactory;
import ru.aston.homework.switcher.Switcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            selectCommand(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Exception input numeric: " + e.getMessage());
        } finally {
            HibernateSessionFactory.close();
        }

    }

    public static void selectCommand(BufferedReader reader) throws IOException {
        Switcher switcher = new Switcher();
        while (switcher.isRunning()) {
            System.out.println(
                    """
                       Input command: find, create, delete, update for work with user
                                      show for show all entities
                                      ore exit for exit):""");
            String command = reader.readLine();
            if (command == null) {
                break;
            }
            switch (command.trim().toLowerCase()) {
                case "exit" -> switcher.stopRunning();
                case "find" -> switcher.findUser(reader);
                case "create" -> switcher.saveUser(reader);
                case "delete" -> switcher.deleteUser(reader);
                case "update" -> switcher.updateUser(reader);
                case "show" -> switcher.showAllUsers();
                default -> System.out.println("it's " + command + " can't to used");
            }
        }
    }
}
