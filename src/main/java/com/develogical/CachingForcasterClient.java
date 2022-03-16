package com.develogical;


import com.weather.Forecast;

public class CachingForcasterClient implements ForecasterClient{

    public CachingForcasterClient(ForecasterClient delegate) {
    }

    public Forecast forecastFor(String Region, String Day) {
        return new Forecast("", 70);
    }
    
    
}
