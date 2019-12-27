package com.matheusvargas481.spring_bootpostgresqldocker.service;

import com.matheusvargas481.spring_bootpostgresqldocker.domain.Costumer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CostumerServiceTest {
    private CostumerService costumerService;
    private Costumer costumer;

    @Before
    public void setUp() throws Exception {
        costumerService = new CostumerService();
    }

    @Test
    public void testAddCostumer() {
        costumer = new Costumer();
        costumer.setName("Eduarda");
        costumer.setCpf("6666666666");
        costumerService.addCostumer(costumer);
    }

    @Test
    public void findById() {
        System.out.println(costumerService.findById(1L));
    }

    @Test
    public void findByName() {
        System.out.println(costumerService.findByName("Matheus"));
    }

    @Test
    public void updateCostumer() {
        Costumer costumer = new Costumer();
        costumer.setId(2L);
        costumer.setName("Vargas");
        costumer.setCpf("777777777777777");
        costumerService.updateCostumer(costumer);
    }

    @Test
    public void testFindAll() {
        System.out.println(costumerService.findAll());
    }

    @Test
    public void deleteCostumer() {
        Costumer byId = costumerService.findById(9L);
        costumerService.deleteCostumer(byId);
    }
}