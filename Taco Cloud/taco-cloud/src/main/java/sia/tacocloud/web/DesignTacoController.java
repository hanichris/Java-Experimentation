package sia.tacocloud.web;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import sia.tacocloud.Ingredient;
import sia.tacocloud.Taco;
import sia.tacocloud.TacoOrder;
import sia.tacocloud.Ingredient.TYPE;
import sia.tacocloud.data.IngredientRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private static Logger log = LoggerFactory.getLogger(DesignTacoController.class);
    private final IngredientRepository ingredientRepo;

    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addingIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();

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

    @PostMapping
    public String processTaco(
        @Valid Taco taco,
        Errors errors,
        @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        log.info("Taco order placed: {}", tacoOrder);
        
        return "redirect:/orders/current";
    }
    
    
    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, TYPE type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                    .filter(x -> x.getType().equals(type))
                    .collect(Collectors.toList());
    }

}
