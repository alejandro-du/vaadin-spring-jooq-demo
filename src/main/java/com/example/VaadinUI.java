package com.example;

import com.example.tables.records.CustomerRecord;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("")
public class VaadinUI extends VerticalLayout {

    private final CustomerService service;

    private Grid<CustomerRecord> grid = new Grid<>(CustomerRecord.class);

    public VaadinUI(CustomerService service) {
        this.service = service;
        TextField filter = new TextField("Filter by name:");
        filter.addValueChangeListener(e -> updateGrid(filter.getValue()));

        add(filter, grid);
        updateGrid("");
        grid.setColumns("firstName", "lastName");
    }

    private void updateGrid(String filter) {
        List<CustomerRecord> customers = service.searchByName(filter);
        grid.setItems(customers);
    }

}
