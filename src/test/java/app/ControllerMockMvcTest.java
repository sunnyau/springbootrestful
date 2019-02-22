package app;

import app.controller.Controller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class ControllerMockMvcTest {

    private MockMvc mockMvc;

    @InjectMocks
    private Controller controller;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetMethod() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Web Service is ready."));
    }

    @Test
    public void testPostMethod() throws Exception {
        mockMvc.perform(post("/valuecar").contentType(MediaType.APPLICATION_JSON).content("{\"miles\":10000}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"amount\":8500}"));
    }
}
