package com.matheusvargas481.spring_bootpostgresqldocker.service;

import com.matheusvargas481.spring_bootpostgresqldocker.dao.CustomerDao;
import com.matheusvargas481.spring_bootpostgresqldocker.domain.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService() { this.customerDao = new CustomerDao(); }

    public Customer addCustomer(Customer customer) { return customerDao.insertCostumer(customer); }

    public List<Customer> findAll() { return customerDao.findAll(); }

    public Customer findById(Long id) { return customerDao.findById(id); }

    public List<Customer> findByName(String name) { return customerDao.findByName(name); }

    public boolean updateCustomer(Customer customer) { return customerDao.updateCostumer(customer); }

    public boolean deleteCustomer(Customer customer) { return customerDao.deleteCostumer(customer); }
}
