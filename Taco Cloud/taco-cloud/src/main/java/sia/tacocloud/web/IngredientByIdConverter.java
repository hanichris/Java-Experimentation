package sia.tacocloud.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sia.tacocloud.Ingredient;
import sia.tacocloud.Ingredient.TYPE;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", TYPE.WRAP));
        ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", TYPE.WRAP));
        ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", TYPE.PROTEIN));
        ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", TYPE.PROTEIN));
        ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", TYPE.VEGGIES));
        ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", TYPE.VEGGIES));
        ingredientMap.put("CHERD",new Ingredient("CHERD", "Cheddar", TYPE.CHEESE));
        ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", TYPE.CHEESE));
        ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", TYPE.SAUCE));
        ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", TYPE.SAUCE));
    }
    
    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
