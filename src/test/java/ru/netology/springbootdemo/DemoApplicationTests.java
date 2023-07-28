package ru.netology.springbootdemo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    private static final int DEV_PORT = 8080;
    private static final int PROD_PORT = 8081;

    private static final GenericContainer <?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(DEV_PORT);
    private static final GenericContainer <?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(PROD_PORT);

    @BeforeAll
    public static void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void testDev() {
        Integer devAppPort = devApp.getMappedPort(DEV_PORT);
        ResponseEntity<String> devAppEntity = restTemplate.getForEntity(
                "http://localhost:" + devAppPort, String.class);
        assertEquals(devAppEntity.getBody(), "Current profile is dev");
    }

    @Test
    void testProd() {
        Integer prodAppPort = prodApp.getMappedPort(PROD_PORT);
        ResponseEntity<String> prodAppEntity = restTemplate.getForEntity(
                "http://localhost:" + prodAppPort + "/profile", String.class);
        assertEquals(prodAppEntity.getBody(), "Current profile is production");
    }
}
