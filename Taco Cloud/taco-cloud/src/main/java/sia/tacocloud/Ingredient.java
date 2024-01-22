package sia.tacocloud;


public class Ingredient {
    private final String id;
    private final String name;
    private final TYPE type;

    public enum TYPE {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    public Ingredient(String id, String name, TYPE type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    //Getter methods
    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public TYPE getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format(
            "Ingredient[id=%s, name='%s', type='%s']",
            id, name, type);
    }
}
