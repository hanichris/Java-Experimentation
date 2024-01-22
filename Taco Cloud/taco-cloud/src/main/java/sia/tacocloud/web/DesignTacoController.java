package sia.tacocloud.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sia.tacocloud.Ingredient;
import sia.tacocloud.Taco;
import sia.tacocloud.TacoOrder;
import sia.tacocloud.Ingredient.TYPE;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addingIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", TYPE.WRAP),
            new Ingredient("COTO", "Corn Tortilla", TYPE.WRAP),
            new Ingredient("GRBF", "Ground Beef", TYPE.PROTEIN),
            new Ingredient("CARN", "Carnitas", TYPE.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", TYPE.VEGGIES),
            new Ingredient("LETC", "Lettuce", TYPE.VEGGIES),
            new Ingredient("CHERD", "Cheddar", TYPE.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", TYPE.CHEESE),
            new Ingredient("SLSA", "Salsa", TYPE.SAUCE),
            new Ingredient("SRCR", "Sour Cream", TYPE.SAUCE)
        );

        TYPE[] types = Ingredient.TYPE.values();
        for (TYPE type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    /**
     * Creates a new TacoOrder object that holds the state
     * of the order being built as the user creates tacos
     * across multiple requests.
     * @return TacoOrder object
     */
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }
    
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, TYPE type) {
        return ingredients
                    .stream()
                    .filter(x -> x.getType().equals(type))
                    .collect(Collectors.toList());
    }

}
