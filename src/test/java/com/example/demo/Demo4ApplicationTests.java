package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Demo4ApplicationTests {

    @Test
    void contextLoads() {
        String expected = "Baeldung";
        String actual = "Baeldung";

        assertEquals(expected, actual);
    }

}
