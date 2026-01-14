package com.swg.service.impl;

import com.swg.model.Customer;
import com.swg.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public Customer getCustomer(Long id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public List<Customer> searchCustomers(String keyword) {
        return List.of();
    }
}
