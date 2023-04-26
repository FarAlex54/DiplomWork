package com.example.sessionandcookies.controllers;

import com.example.sessionandcookies.models.Avtorization;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonalAccountController {
    @GetMapping("/personalaccount")
    public String getPersonalAccount(HttpServletRequest request){
        HttpSession session = request.getSession();
        Avtorization authorizationSession = (Avtorization) session.getAttribute("user");
        if(authorizationSession == null){
            return "redirect:/authorization";
        }else {
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie:cookies){
                System.out.print("Название cookie" + cookie.getName());
                System.out.println(" Знечение:"+ cookie.getValue());
            }
            return "/personalAccount";
        }
    }
    @GetMapping("/authorization")
    public String authorization(Model model){
        model.addAttribute("authorization", new Avtorization());
        return "authorization";
    }
    @PostMapping("/authorization")
    public String saveObjectAuthorization(@ModelAttribute("authorization") Avtorization authorization, HttpServletRequest request, HttpServletResponse response){
        //Создаем новые куки в паре ключ:значение. Все эти данные должны быть в тиипе String
        Cookie cookie = new Cookie("user_id","1");
        //Указываем сколько секунд данные куки будут хранится на браузере клиента
        //48 часов умножаем на 60 минут и 60 секунд
        cookie.setMaxAge(48*60*60);
        response.addCookie(cookie);


        HttpSession session=request.getSession();
        Avtorization authorizationSession = (Avtorization) session.getAttribute("user");
        authorizationSession = new Avtorization();
        authorizationSession.setLogin(authorization.getLogin());
        authorizationSession.setPassword(authorization.getPassword());
        session.setAttribute("user",authorizationSession);
        return "redirect:/personalaccount";
    }
}
