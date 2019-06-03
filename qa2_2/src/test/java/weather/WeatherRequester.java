package weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import weather.model.Response;

import java.io.IOException;

public class WeatherRequester {

    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
    private final String POSTFIX = "&appid=b6907d289e10d714a6e88b30761fae22";

    public Response requestWeather(String country, String city) throws IOException {
        String url = PREFIX + city + "," + country + POSTFIX;

        RestTemplate template = new RestTemplate();
        String responseToParse = template.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
       return  objectMapper.readValue(responseToParse, Response.class);

    }
}
