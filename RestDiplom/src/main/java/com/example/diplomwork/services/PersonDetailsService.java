package com.example.diplomwork.services;

import com.example.diplomwork.models.Person;
import com.example.diplomwork.repositories.PersonRepository;
import com.example.diplomwork.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByLogin(username); // Получает пользователя из таблицы
        if (person.isEmpty()){
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return new PersonDetails(person.get());
    }
}
