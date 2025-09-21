package com.giuseppefrattura.spring6webapp.services.i18n;

import com.giuseppefrattura.spring6webapp.services.GreetingsService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("IT")
@Service("i18nService")
public class ItalianGreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayGreetings() {
        return "Ciao";
    }
}
