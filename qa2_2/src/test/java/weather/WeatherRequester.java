package weather;

import weather.model.Response;

public class WeatherRequester {

    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
    private final String POSTFIX = "&appid=b6907d289e10d714a6e88b30761fae22";

    public Response requestWeather(String country, String city) {
        Response response = new Response();

        return response;

    }
}
