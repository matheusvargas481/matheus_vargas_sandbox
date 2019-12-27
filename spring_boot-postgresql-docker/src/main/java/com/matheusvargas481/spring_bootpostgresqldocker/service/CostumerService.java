package com.matheusvargas481.spring_bootpostgresqldocker.service;

import com.matheusvargas481.spring_bootpostgresqldocker.dao.CostumerDao;
import com.matheusvargas481.spring_bootpostgresqldocker.domain.Costumer;

import java.util.List;

public class CostumerService {
    private CostumerDao costumerDao;

    public CostumerService() { this.costumerDao = new CostumerDao(); }

    public Costumer addCostumer(Costumer costumer) { return costumerDao.insertCostumer(costumer); }

    public List<Costumer> findAll() { return costumerDao.findAll(); }

    public Costumer findById(Long id) { return costumerDao.findById(id); }

    public List<Costumer> findByName(String name) { return costumerDao.findByName(name); }

    public boolean updateCostumer(Costumer costumer) { return costumerDao.updateCostumer(costumer); }

    public boolean deleteCostumer(Costumer costumer) { return costumerDao.deleteCostumer(costumer); }
}
