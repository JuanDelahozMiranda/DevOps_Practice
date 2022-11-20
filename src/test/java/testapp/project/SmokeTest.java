package testapp.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import config.servingwebcontent.ServingWebContentApplication;
import config.servingwebcontent.controller.GreetingController;
import config.servingwebcontent.controller.LogController;
import config.servingwebcontent.controller.WeatherController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes={ServingWebContentApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmokeTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GreetingController controller;
    @Autowired
    private LogController controller2;
    @Autowired
    private WeatherController controller3;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void LogLoads() throws Exception {
        assertThat(controller2).isNotNull();
    }

    @Test
    public void weatherLoads() throws Exception {
        assertThat(controller3).isNotNull();
    }

    @Test
    public void IndexShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:"+ port+"/",
                String.class)).contains("Greetings from Spring Boot!");
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting",
                String.class)).contains("Hello, World!");
    }

    @Test
    public void greetingShouldReturntMessageWithParam() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting?name=juan",
                String.class)).contains("Hello, juan!");
    }

    @Test
    public void LoggerShouldReturntMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/Logger",
                String.class)).contains("Howdy! Check out the Logs to see the output...");
    }

}