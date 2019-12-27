package com.matheusvargas481.spring_bootpostgresqldocker.service;

import com.matheusvargas481.spring_bootpostgresqldocker.domain.Customer;
import org.junit.Before;
import org.junit.Test;

public class CustomerServiceTest {
    private CustomerService costumerService;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        costumerService = new CustomerService();
    }

    @Test
    public void testAddCostumer() {
        customer = new Customer();
        customer.setName("eduarda");
        customer.setCpf("5555555");
        costumerService.addCustomer(customer);
    }

    @Test
    public void findById() {
        System.out.println(costumerService.findById(15L));
    }

    @Test
    public void findByName() {
        System.out.println(costumerService.findByName("Vargas"));
    }

    @Test
    public void updateCostumer() {
        Customer customer = new Customer();
        customer.setId(14L);
        customer.setName("Vargas");
        customer.setCpf("777777777777777");
        costumerService.updateCustomer(customer);
    }

    @Test
    public void testFindAll() {
        System.out.println(costumerService.findAll());
    }

    @Test
    public void deleteCostumer() {
        costumerService.deleteCustomer(costumerService.findById(15L));
    }
}