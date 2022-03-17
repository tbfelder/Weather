package com.develogical;

import com.oocode.weather.DayForecaster;
import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

public class Example {
    public static void main(String[] args) {
       // lib1();
        // lib2();
        lib3();
    }

    private static void lib1() {
        Forecaster forecaster = new Forecaster();

        Forecast londonForecast = forecaster.forecastFor(Region.LONDON, Day.MONDAY);

        System.out.println("London outlook: " + londonForecast.summary());
        System.out.println("London temperature: " + londonForecast.temperature());

        Forecast edinburghForecast = forecaster.forecastFor(Region.EDINBURGH, Day.MONDAY);

        System.out.println("Edinburgh outlook: " + edinburghForecast.summary());
        System.out.println("Edinburgh temperature: " + edinburghForecast.temperature());
    }

    private static void lib2() {
        Double londonForecastTemp = DayForecaster.forecast(com.oocode.weather.Forecaster.Regions.SE_ENGLAND, 0);
        String londonForecastSummary = DayForecaster.forecastSummary(com.oocode.weather.Forecaster.Regions.SE_ENGLAND, 0);

        System.out.println("London outlook: " + londonForecastSummary);
        System.out.println("London temperature: " + londonForecastTemp);

        Double edinburghForecastTemp = DayForecaster.forecast(com.oocode.weather.Forecaster.Regions.SE_SCOTLAND, 0);
        String edinburghForecastSummary = DayForecaster.forecastSummary(com.oocode.weather.Forecaster.Regions.SE_SCOTLAND, 0);

        System.out.println("Edinburgh outlook: " + edinburghForecastSummary);
        System.out.println("Edinburgh temperature: " + edinburghForecastTemp);
    }

    private static void lib3() {
        ForecasterClient forecaster = new CachingForcasterClient(new ForecasterAdapterDayToForecast());

        Forecast londonForecast = forecaster.forecastFor(Region.LONDON, Day.MONDAY);

        System.out.println("TEST London outlook: " + londonForecast.summary());
        System.out.println("TEST London temperature: " + londonForecast.temperature());

        Forecast edinburghForecast = forecaster.forecastFor(Region.EDINBURGH, Day.MONDAY);

        System.out.println("TEST Edinburgh outlook: " + edinburghForecast.summary());
        System.out.println("TEST dinburgh temperature: " + edinburghForecast.temperature());

        Forecast edinburghForecast2 = forecaster.forecastFor(Region.EDINBURGH, Day.MONDAY);

        System.out.println("TEST2 Edinburgh outlook: " + edinburghForecast2.summary());
        System.out.println("TEST2 dinburgh temperature: " + edinburghForecast2.temperature());
    }
}
