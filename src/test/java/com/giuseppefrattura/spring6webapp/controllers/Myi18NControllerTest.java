package com.giuseppefrattura.spring6webapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"IT", "default"})
@SpringBootTest
class Myi18NControllerTest {

    @Autowired
    Myi18NController myi18NController;

    @Test
    void sayHello(){
        System.err.println(myi18NController.sayHello());
    }
}