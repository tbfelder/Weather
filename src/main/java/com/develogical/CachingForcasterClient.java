package com.develogical;


import com.weather.Forecast;

public class CachingForcasterClient implements ForecasterClient{

    private ForecasterClient delegate;

    public CachingForcasterClient(ForecasterClient delegate) {
        this.delegate = delegate;
    }

    public Forecast forecastFor(String Region, String Day) {

        return delegate.forecastFor(Region, Day);

    }
    
    
}
