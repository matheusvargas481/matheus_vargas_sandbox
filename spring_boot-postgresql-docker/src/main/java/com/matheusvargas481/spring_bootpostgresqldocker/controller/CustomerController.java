package com.matheusvargas481.spring_bootpostgresqldocker.controller;

import com.matheusvargas481.spring_bootpostgresqldocker.domain.Customer;
import com.matheusvargas481.spring_bootpostgresqldocker.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer add(@Valid @RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> listAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Customer>> findById(@PathVariable String name) {
        List<Customer> costumers = customerService.findByName(name);
        if (costumers == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(costumers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerService.deleteCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        Customer newCustomer = customerService.findById(id);
        if (newCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(customer, newCustomer, "id");
        newCustomer = customerService.updateCustomer(newCustomer);
        return ResponseEntity.ok(newCustomer);
    }
}
