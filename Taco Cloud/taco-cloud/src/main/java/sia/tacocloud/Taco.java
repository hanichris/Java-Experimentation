package sia.tacocloud;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Taco {

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

    public Taco(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    // Setter methods
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
}
