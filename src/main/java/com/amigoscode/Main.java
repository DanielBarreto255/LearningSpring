package com.amigoscode;

import java.util.List;
import java.util.Objects;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse(
                "Hello",
                List.of("Java", "Golang", "Javascript"),
                new Person("Alex", 28, 30_000));
        return response;
    }

    record Person(String name, int age, double savings) {

    }

    record GreetResponse(
            String greet,
            List<String> favProgramingLaunguages,
            Person person) {
    }

    /*
     * class GreetResponse {
     * private final String greet;
     * private
     * 
     * GreetResponse(String greet) {
     * this.greet = greet;
     * }
     * 
     * public String getGreet() {
     * return greet;
     * }
     * 
     * @Override
     * public String toString() {
     * return "GreetResponse{" + greet + '\'' + '}';
     * }
     * 
     * @Override
     * public boolean equals(Object o) {
     * if (this == o)
     * return true;
     * if (o == null || getClass() != o.getClass())
     * return false;
     * GreetResponse that = (GreetResponse) o;
     * return Objects.equals(greet, that.greet);
     * }
     * 
     * @Override
     * public int hashCode() {
     * return Objects.hash(greet);
     * }
     * 
     * }
     */
}
