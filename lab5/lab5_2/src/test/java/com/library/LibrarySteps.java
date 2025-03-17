package com.library;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LibrarySteps {
    static final Logger log = getLogger(lookup().lookupClass());

    @ParameterType("([0-9]{4}) .* ([0-9]{2})")
    public LocalDate iso8601Date(String year, String month, String day){
        return LocalDate.of(Integer.parseInt(year), Month.valueOf(month), Integer.parseInt(day));
    }

    /*@DataTableType
    public Book bookEntry(Map<String, String> entry){
        return new Book(
            entry.get("title");
            entry.get("author");
            entry.
        )
    }*/

    private Library library = new Library();
    private List<Book> queryResult;

    @Given("a book with the title {string}, written by {string}, published in {date}")
    @Given("another book with the title {string}, written by {string}, published in {date}")
    public void setup(String arg1, String arg2, LocalDate arg3){
        library.addBook(new Book(arg1, arg2, arg3));
    }

    @When("the customer searches for books published between {year} and {year}")
    public void search(Year arg1, Year arg2){
        queryResult = library.findBooks(arg1.atDay(1), arg2.atDay(arg2.length()));
    }

    @Then("{int} books should have been found")
    public void checkResultLength(int length){
        assertEquals(length, queryResult.size());
    }

    @Then("Book {int} should have the title {String}")
    public void checkResult(int n, String title){
        assertEquals(title, queryResult.get(n-1).getTitle());
    }
}
