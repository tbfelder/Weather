package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

public class ForecasterAdapter implements  ForecasterClient {

    @Override
    public Forecast forecastFor(Region region, Day day) {


        return new Forecaster().forecastFor(region, day);
    }
}
