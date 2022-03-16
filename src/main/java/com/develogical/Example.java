package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

public class Example {
    public static void main(String[] args) {
        // This is just an example of using the 3rd party API - delete this class before submission.

        ForecasterClient forecaster = new CachingForcasterClient(new ForecasterAdapter());

        Forecast londonForecast = forecaster.forecastFor(Region.LONDON, Day.FRIDAY);

        System.out.println("London outlook: " + londonForecast.summary());
        System.out.println("London temperature: " + londonForecast.temperature());

        Forecast edinburghForecast = forecaster.forecastFor(Region.EDINBURGH, Day.MONDAY);

        System.out.println("Edinburgh outlook: " + edinburghForecast.summary());
        System.out.println("Edinburgh temperature: " + edinburghForecast.temperature());

        Forecast birminghamForecast = forecaster.forecastFor(Region.BIRMINGHAM, Day.MONDAY);

        System.out.println("Edinburgh outlook: " + birminghamForecast.summary());
        System.out.println("Edinburgh temperature: " + birminghamForecast.temperature());
    }
}


