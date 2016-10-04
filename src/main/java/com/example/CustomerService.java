package com.example;

import com.example.tables.records.CustomerRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.Tables.*;

@Component
public class CustomerService {

    @Autowired
    private DSLContext dslContext;

    public List<CustomerRecord> searchByName(String name) {
        String filter = "%" + name + "%";
        return dslContext
            .selectFrom(CUSTOMER)
            .where(CUSTOMER.FIRST_NAME.likeIgnoreCase(filter)
            .or(CUSTOMER.LAST_NAME.likeIgnoreCase(filter)))
            .fetchInto(CustomerRecord.class);
    }

}
