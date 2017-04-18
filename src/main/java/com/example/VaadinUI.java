package com.example;

import com.example.tables.records.CustomerRecord;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI
public class VaadinUI extends UI {

    @Autowired
    private CustomerService service;

    private Grid<CustomerRecord> grid = new Grid(CustomerRecord.class);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField filter = new TextField("Filter by name:");
        filter.addValueChangeListener(e -> updateGrid(filter.getValue()));

        VerticalLayout layout = new VerticalLayout(filter, grid);
        setContent(layout);
        updateGrid("");
        grid.setColumns("firstName", "lastName");
    }

    private void updateGrid(String filter) {
        List<CustomerRecord> customers = service.searchByName(filter);
        grid.setItems(customers);
    }

}
