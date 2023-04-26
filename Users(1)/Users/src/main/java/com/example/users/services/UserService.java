package com.example.users.services;

import com.example.users.models.User;
import com.example.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Данный метод позволяет вернуть всех пользователей
    public List<User> getAllUser(){
        // SELECT * FROM USER_SITE;
        return userRepository.findAll();
    }

    // Данный метод позволяет вернуть пользователя по id
    public User getUserId(int id){
        // select * from user_site where id = {id};
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    // Данный метод позволяет добавить пользователя в таблицу user_site
    @Transactional
    public void userAdd(User user){
        // insert into user_site(last_name, first_name, patronymic, age, email, phone number) values('Иванов', 'Иван', 'Иванович', 31, 'ivanov@mail.ru', '89168047631')
        userRepository.save(user);
    }

    // Данный метод позволяет обновить данные пользователя
    @Transactional
    public void userEdit(int id, User user){
        user.setId(id);
        userRepository.save(user);
    }

    // Данный метод позволяет удалить пользователя по id
    @Transactional
    public void delete(int id){
        // DELETE FROM USER_SITE WHERE ID = {id}
        userRepository.deleteById(id);
    }

}
