package com.example.diplomwork.services;

import com.example.diplomwork.models.Category;
import com.example.diplomwork.models.Person;
import com.example.diplomwork.models.Product;
import com.example.diplomwork.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Person findByLogin(Person person){
        Optional<Person> person_db = personRepository.findByLogin(person.getLogin());
        return person_db.orElse(null);
    }
    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        personRepository.save(person);
    }

    ///я добавил
    public Person getPersonId(int id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

}
