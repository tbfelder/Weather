package com.develogical;

import com.weather.Forecast;
import com.weather.Forecaster;

public interface ForecasterClient {

    public Forecast forecastFor( String Region, String Day);
}
