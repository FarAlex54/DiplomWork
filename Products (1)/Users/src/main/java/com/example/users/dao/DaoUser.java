package com.example.users.dao;

import com.example.users.models.User;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class DaoUser {
    private int id;
    private List<User> users = new ArrayList<>();
    public void addUser(User user){
        users.add(user);
        user.setId(++id);
    }
    public List<User> getUsers(){
        return users;
    }
    public User getUserId(int id){
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public void updateUser(int id, User user){
        User userUpdate = getUserId(id);
        userUpdate.setLast_name(user.getLast_name());
        userUpdate.setFirst_name(user.getFirst_name());
        userUpdate.setSecond_name(user.getSecond_name());
        userUpdate.setAge(user.getAge());
        userUpdate.setPhone(user.getPhone());
        userUpdate.setEmail(user.getEmail());
    }
    public void deleteUser(int i){
        users.removeIf(user -> user.getId() == id);
    }
}
