package weather;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import weather.model.Response;

import java.io.IOException;


public class WeatherStepDefs {
    //private final String URL = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    private String country;
    private String city;
    private Response response;

    @Given("country: ([a-z]*)")
    public void set_country(String country) {
        this.country = country;
    }

    @Given("city: (.*)")
    public void set_city(String city) {
        this.city = city;
    }

    @When("we are requesting weather data")
    public void request_weather_data() throws IOException {
        WeatherRequester weatherRequester = new WeatherRequester();
        response = weatherRequester.requestWeather(country, city);
    }

    @Then("longitude is (.*)")
    public void check_longitude(Double lon) {

    }

    @Then("latitude is (.*)")
    public void check_latitude(Double lat) {

    }
}
