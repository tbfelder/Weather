package com.develogical;


import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

import java.util.HashMap;
import java.util.Map;

public class CachingForcasterClient implements ForecasterClient {

    public int cachesize = 3;
    private ForecasterClient delegate;
    private static HashMap<Region, Map<Day, Forecast>> currentForecasts = new HashMap();

    public CachingForcasterClient(ForecasterClient delegate) {
        this.delegate = delegate;
    }


    public Forecast forecastFor(Region region, Day day) {

        if (!currentForecasts.containsKey(region)) {
            currentForecasts.put(region, new HashMap());
        }

        if (!((Map)currentForecasts.get(region)).containsKey(day)) {
            ((Map)currentForecasts.get(region)).put(day, delegate.forecastFor(region, day));
        }



        return (Forecast)((Map)currentForecasts.get(region)).get(day);

    }
    
    
}
