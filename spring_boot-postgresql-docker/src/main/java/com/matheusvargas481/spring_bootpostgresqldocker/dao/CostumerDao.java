package com.matheusvargas481.spring_bootpostgresqldocker.dao;

import com.matheusvargas481.spring_bootpostgresqldocker.connection.ConnectionPostgresSql;
import com.matheusvargas481.spring_bootpostgresqldocker.domain.Costumer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CostumerDao {

    public List<Costumer> findAll() {
        List<Costumer> costumers = new ArrayList<>();
        try (Connection connection = ConnectionPostgresSql.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM costumer;");
            ResultSet resultSet = statement.executeQuery();
            findCostumer(resultSet, costumers);
        } catch (SQLException e) {
            System.out.println("Contato não encontrado: " + e);
        }
        return costumers;
    }

    public Costumer findById(Long id) {
        Costumer costumer = null;
        try (Connection connection = ConnectionPostgresSql.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM costumer WHERE id = ?;");
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                costumer = new Costumer();
                costumer.setId(resultSet.getLong("id"));
                costumer.setName(resultSet.getString("name"));
                costumer.setCpf(resultSet.getString("cpf"));
                return costumer;
            }
        } catch (SQLException e) {
            System.out.println("Contato não encontrado: " + e);
        }
        return costumer;
    }

    public List<Costumer> findByName(String name) {
        Costumer costumer = null;
        List<Costumer> costumers = new ArrayList<>();
        try (Connection connection = ConnectionPostgresSql.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contato WHERE name LIKE ?;");
            stmt.setString(1, "%" + name + "%");
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                costumer = new Costumer();
                costumer.setId(resultSet.getLong("id"));
                costumer.setName(resultSet.getString("name"));
                costumer.setCpf(resultSet.getString("cpf"));
                costumers.add(costumer);
            }
        } catch (SQLException e) {
            System.out.println("Contato não encontrado: " + e);
        }
        return costumers;
    }

    public Costumer insertCostumer(Costumer costumer) {
        try (Connection connection = ConnectionPostgresSql.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO costumer(name, cpf)VALUES(?,?)");
            statement.setString(1, costumer.getName());
            statement.setString(2, costumer.getCpf());
            statement.executeUpdate();
            System.out.println("Contato salvo com Sucesso !");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar contato: " + e);
        }
        return costumer;
    }

    public boolean updateCostumer(Costumer costumer) {
        try (Connection connection = ConnectionPostgresSql.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE costumer SET name = ?, cpf = ? WHERE id = ?; ");
            statement.setString(1, costumer.getName());
            statement.setString(2, costumer.getCpf());
            statement.setLong(3, costumer.getId());
            statement.executeUpdate();
            System.out.println("Contato atualizado com Sucesso !");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar contato: " + e);
        }
        return false;
    }

    public boolean deleteCostumer(Costumer costumer) {
        try (Connection connection = ConnectionPostgresSql.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM costumer WHERE id = ?;");
            statement.setLong(1, costumer.getId());
            statement.executeUpdate();
            System.out.println("Contato excluido com Sucesso !");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir contato: " + e);
        }
        return false;
    }

    private boolean findCostumer(ResultSet resultSet, List<Costumer> costumers) {
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Costumer costumer = new Costumer();
                costumer.setId(resultSet.getLong("id"));
                costumer.setName(resultSet.getString("name"));
                costumer.setCpf(resultSet.getString("cpf"));
                costumers.add(costumer);
                System.out.println("Costumer encontrado !");
                return true;
            } catch (SQLException e) {
                System.out.println("Erro ao encontrar Costumer" + e);
            }
        }
        return false;
    }

}