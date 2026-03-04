package ru.aston.homework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String name;

    @Setter
    private String email;

    @Setter
    private int age;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
        createdAt = LocalDateTime.now();
        System.out.println("User: " + this.toString() + " created");
    }
}
