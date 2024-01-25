package sia.tacocloud.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sia.tacocloud.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
            "select id, name, type from Ingredient",
            this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        Ingredient result = jdbcTemplate.queryForObject(
            "select id, name, type from Ingredient where id=?", 
            this::mapRowToIngredient,
            id);
        
        return result == null ? Optional.empty() : Optional.of(result);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
            "insert into Ingredient (id, name, type) values (?, ?, ?)",
            ingredient.getID(),
            ingredient.getName(),
            ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum)
    throws SQLException {
        return new Ingredient(
            row.getString("id"),
            row.getString("name"),
            Ingredient.TYPE.valueOf(row.getString("type")));
    }
    
}
