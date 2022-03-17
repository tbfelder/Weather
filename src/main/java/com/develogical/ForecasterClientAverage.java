package com.develogical;


import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

public class ForecasterClientAverage implements ForecasterClient {

    private ForecasterClient forecasterClient1;
    private ForecasterClient forecasterClient2;

    @Override
    public Forecast forecastFor(Region region, Day day) {
        int T1 = forecasterClient1.forecastFor(region, day).temperature();
        int T2 = forecasterClient2.forecastFor(region, day).temperature();

        String summary1 = forecasterClient1.forecastFor(region, day).summary();
        String summary2 = forecasterClient2.forecastFor(region, day).summary();

        int averageT = (T1 + T2) / 2;
        String summary = summary1 + summary2;

        return new Forecast(summary, averageT);
    }

    public ForecasterClientAverage(ForecasterClient forecasterClient1, ForecasterClient forecasterClient2) {
        this.forecasterClient1 = forecasterClient1;
        this.forecasterClient2 = forecasterClient2;

    }
    
    
}
