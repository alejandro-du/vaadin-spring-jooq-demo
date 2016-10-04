package com.example;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.Tables.*;

@Component
public class CustomerService {

    @Autowired
    private DSLContext dslContext;

    public List<Customer> searchByName(String name) {
        String filter = "%" + name + "%";
        return dslContext
            .selectFrom(CUSTOMERS)
            .where(CUSTOMERS.FIRST_NAME.likeIgnoreCase(filter)
            .or(CUSTOMERS.LAST_NAME.likeIgnoreCase(filter)))
            .fetchInto(Customer.class);
    }


}
