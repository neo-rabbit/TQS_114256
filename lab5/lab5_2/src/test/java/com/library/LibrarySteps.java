package com.library;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import org.slf4j.Logger;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LibrarySteps {
    static final Logger log = getLogger(lookup().lookupClass());

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDate isoDate(String year, String month, String day){
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    private Library library = new Library();
    private List<Book> queryResult;

    @Given("a book with the title {string}, written by {string}, published in {isoDate}")
    @Given("another book with the title {string}, written by {string}, published in {isoDate}")
    public void setup(String arg1, String arg2, LocalDate arg3){
        library.addBook(new Book(arg1, arg2, arg3));
    }

    @When("the customer searches for books published between {int} and {int}")
    public void search(int arg1, int arg2){
        Year beginYear = Year.of(arg1);
        Year endYear = Year.of(arg2);
        queryResult = library.findBooks(beginYear.atDay(1), endYear.atDay(endYear.length()));
    }

    @Then("{int} books should have been found")
    public void checkResultLength(int length){
        assertEquals(length, queryResult.size());
    }

    @Then("Book {int} should have the title {string}")
    public void checkResult(int n, String title){
        assertEquals(title, queryResult.get(n-1).getTitle());
    }
}
