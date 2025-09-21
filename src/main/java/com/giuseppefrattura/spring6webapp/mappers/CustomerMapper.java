package com.giuseppefrattura.spring6webapp.mappers;

import com.giuseppefrattura.spring6webapp.domain.CustomerDTO;
import com.giuseppefrattura.spring6webapp.entities.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer beer);

}