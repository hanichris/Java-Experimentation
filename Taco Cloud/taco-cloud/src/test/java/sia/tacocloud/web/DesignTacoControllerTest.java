package sia.tacocloud.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DesignTacoController.class)
public class DesignTacoControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    // @Test
    // public void testDesignPage() throws Exception {
    //     mockMvc.perform(get("/design"))
    //         .andExpect(status().isOk())
    //         .andExpect(view().name("design"));
    // }
}
