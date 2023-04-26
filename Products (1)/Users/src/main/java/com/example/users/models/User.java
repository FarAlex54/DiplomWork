package com.example.users.models;

public class User {
    private int id;
    private String first_name; //Имя
    private String last_name; //Фамилия
    private String second_name; //Отчество
    private int age;    //возраст
    private String phone;   //телефон
    private String email;   //электронная почта

    public User(int id, String first_name, String last_name, String second_name, int age, String phone, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
