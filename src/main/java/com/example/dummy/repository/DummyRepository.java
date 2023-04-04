package com.example.dummy.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.dummy.schema.Dummy;
import java.util.List;
import java.util.Optional;

@Repository
public class DummyRepository {

    private final JdbcTemplate jdbcTemplate;

    public DummyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addDummy(Dummy dummy) {
        var sql = """
                INSERT INTO dummy_table(name) VALUES(?);
                """;
        return jdbcTemplate.update(sql, dummy.name());
    }

    public List<Dummy> getAllDummy() {
        var sql = """
                SELECT id, name FROM dummy_table;
                """;
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Dummy(
                resultSet.getInt("id"),
                resultSet.getString("name")
            );
        });
    }

    public Optional<Dummy> getOneDummy(int id) {
        var sql = """
                SELECT id, name FROM dummy_table WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Dummy(
                resultSet.getInt("id"),
                resultSet.getString("name")
            );
        }, id)
        .stream()
        .findFirst();
    }

    public int deleteDummy(int id) {
        var sql = """
                DELETE FROM dummy_table WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }
    
}
