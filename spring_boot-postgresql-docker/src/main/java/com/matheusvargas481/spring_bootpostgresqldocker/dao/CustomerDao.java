package com.matheusvargas481.spring_bootpostgresqldocker.dao;

import com.matheusvargas481.spring_bootpostgresqldocker.config.DataSourceConfig;
import com.matheusvargas481.spring_bootpostgresqldocker.domain.Customer;
import com.matheusvargas481.spring_bootpostgresqldocker.exception.CustomerNotFoundException;
import com.matheusvargas481.spring_bootpostgresqldocker.exception.ErrorActionCustomerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private DataSourceConfig dataSourceConfig;

    public CustomerDao() {
        this.dataSourceConfig = new DataSourceConfig();
    }

    public Customer findById(Long id) {
        try (Connection connection = dataSourceConfig.datasource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE id = ?;");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setCpf(resultSet.getString("cpf"));
            }
            statement.close();
            return customer;
        } catch (SQLException e) {
            throw new CustomerNotFoundException();
        }
    }

    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = dataSourceConfig.datasource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE name LIKE ?;");
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setCpf(resultSet.getString("cpf"));
                customers.add(customer);
            }
            statement.close();
            return customers;
        } catch (SQLException e) {
            throw new CustomerNotFoundException();
        }
    }

    public Customer insertCostumer(Customer customer) {
        try (Connection connection = dataSourceConfig.datasource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer(name, cpf)VALUES(?,?)");
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getCpf());
            statement.executeUpdate();
            statement.close();
            return customer;
        } catch (SQLException e) {
            throw new ErrorActionCustomerException("Error saving customer !");
        }
    }

    public Customer updateCostumer(Customer customer) {
        try (Connection connection = dataSourceConfig.datasource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE customer SET name = ?, cpf = ? WHERE id = ?; ");
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getCpf());
            statement.setLong(3, customer.getId());
            statement.executeUpdate();
            statement.close();
            return customer;
        } catch (SQLException e) {
            throw new ErrorActionCustomerException("Error update customer !");
        }
    }

    public boolean deleteCostumer(Customer customer) {
        try (Connection connection = dataSourceConfig.datasource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM customer WHERE id = ?;");
            statement.setLong(1, customer.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            throw new ErrorActionCustomerException("Error deleting customer !");
        }
    }

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = dataSourceConfig.datasource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer;");
            ResultSet resultSet = statement.executeQuery();
            findCostumer(resultSet, customers);
            statement.close();
        } catch (SQLException e) {
            throw new CustomerNotFoundException();
        }
        return customers;
    }

    private void findCostumer(ResultSet resultSet, List<Customer> customers) {
        while (true) {
            try {
                if (!resultSet.next()) break;
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setCpf(resultSet.getString("cpf"));
                customers.add(customer);
            } catch (SQLException e) {
                throw new CustomerNotFoundException();
            }
        }
    }

}