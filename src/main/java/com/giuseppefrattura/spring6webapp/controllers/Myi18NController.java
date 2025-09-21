package com.giuseppefrattura.spring6webapp.controllers;

import com.giuseppefrattura.spring6webapp.services.GreetingsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Myi18NController {

    private final GreetingsService greetingsService;

    public Myi18NController(@Qualifier("i18nService") GreetingsService greetingsService) {
        this.greetingsService=greetingsService;
    }

    public String sayHello(){
        return greetingsService.sayGreetings();
    }

}
