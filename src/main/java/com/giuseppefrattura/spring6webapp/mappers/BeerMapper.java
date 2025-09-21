package com.giuseppefrattura.spring6webapp.mappers;

import com.giuseppefrattura.spring6webapp.domain.BeerDTO;
import com.giuseppefrattura.spring6webapp.entities.Beer;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

}