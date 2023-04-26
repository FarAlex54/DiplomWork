package com.example.users.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity(name = "user_site")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 30, message = "Фамилия должна быть в диапазоне от 2 до 30 символов")
    @Column(name = "last_name", length = 30, nullable = false, columnDefinition = "text")
    private String lastName;

    @NotEmpty(message = "Имя не может быть пустой")
    @Size(min = 2, max = 20, message = "Имя должна быть в диапазоне от 2 до 30 символов")
    @Column(name = "first_name", length = 20, nullable = false, columnDefinition = "text")
    private String firstName;

    @Column(name = "patronymic", length = 20, nullable = true, columnDefinition = "text")
    private String patronymic;


    @Min(value = 18, message = "Возраст не может быть меньше 18")
    @Column(name = "age", length = 20, nullable = false, columnDefinition = "int")
    private int age;

    @NotEmpty(message = "Email пользователя не может быть пустым")
    @Email(message = "Вы ввели не email")
    @Column(name = "email", length = 40, nullable = false, columnDefinition = "text", unique = true)
    private String email;

    @NotEmpty(message = "Номер телефона не может быть пустым")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Номер телефона должен быть в формате +7/7/80000000")
    @Column(name = "phoneNumber", length = 12, nullable = false, columnDefinition = "text", unique = true)
    private String phoneNumber;

//    @Transient
//    private int sum;

    public User(int id, String lastName, String firstName, String patronymic, int age, String email, String phoneNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
