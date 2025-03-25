package com.example;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

public class AppTest {
    
    @Test
    public void testListToDosAvailable(){
        get("https://jsonplaceholder.typicode.com/todos").then()
            .assertThat().statusCode(200);
    }

    @Test
    public void testGetToDo(){
        get("https://jsonplaceholder.typicode.com/todos/4").then()
            .assertThat().body("title", equalTo("et porro tempora"));
    }

    @Test
    public void testListToDos(){
        get("https://jsonplaceholder.typicode.com/todos").then()
            .assertThat().body("id", hasItems(198,199));
    }

    @Test
    public void testListToDosResponseTime(){
        Response response = get("https://jsonplaceholder.typicode.com/todos");
        long time = response.timeIn(TimeUnit.SECONDS);
        assertTrue(time < 2);
    }
}
