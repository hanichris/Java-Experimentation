package sia.tacocloud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Taco {
    private Long id;

    private Date createdAt = new Date();


    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long.")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient.")
    private List<Ingredient> ingredients;

    public Taco() {
        name = "";
        ingredients = new ArrayList<>();
    }

    public Taco(Long id, String name, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    // Getter methods
    public Long getId() {
        return this.id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getName() {
        return this.name;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        if (this.ingredients.size() == 0) {
            return "Taco[name='', Ingredients=None]";
        }
        StringBuilder ingredients = new StringBuilder();
        for (Ingredient ingredient : this.ingredients) {
            ingredients.append(ingredient.toString());
            ingredients.append("\n");
        }
        return String.format("Taco[name=%s] [Ingredients:]\n%s", name, ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            createdAt,
            name,
            ingredients
        );
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Taco taco = (Taco)that;
        return Objects.equals(id, taco.id);
    }
}
