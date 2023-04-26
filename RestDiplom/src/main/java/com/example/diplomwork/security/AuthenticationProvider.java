//package com.example.diplomwork.security;
//
//import com.example.diplomwork.services.PersonDetailsService;
//import org.hibernate.mapping.Collection;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//@Component
//public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
//    private final PersonDetailsService personDetailsService;
//
//    public AuthenticationProvider(PersonDetailsService personDetailsService) {
//        this.personDetailsService = personDetailsService;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String login = authentication.getName();// получает логин с формы аутентификации
//        UserDetails person = personDetailsService.loadUserByUsername(login); // метод возвращает объект интерфейса
//        String password = authentication.getCredentials().toString();
//        if(!password.equals(person.getPassword())){
//            throw new BadCredentialsException("Не корректный пароль");
//        }
//        return new UsernamePasswordAuthenticationToken(person, password, Collections.emptyList());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//}
