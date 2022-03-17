package com.develogical;

import com.oocode.weather.DayForecaster;
import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;
import com.oocode.weather.Forecaster.Regions;

public class ForecasterAdapterDayToForecast implements  ForecasterClient {

    @Override
    public Forecast forecastFor(Region region, Day day) {
        int int_day = 0;
        int counter = 0;

        for (Day day1 : Day.values()) {
            if(day == day1) {
                int_day = counter;
                break;
            }
            counter++;
        }

        Regions region_new;

        switch(region) {
            case BIRMINGHAM:
                region_new = Regions.NE_SCOTLAND;
                break;
            case        EDINBURGH:
                region_new = Regions.NE_SCOTLAND;
                break;
            case        GLASGOW:
                region_new = Regions.NE_SCOTLAND;
                break;
            case        LONDON:
                region_new = Regions.NW_ENGLAND;
                break;
            case        MANCHESTER:
                region_new = Regions.NW_ENGLAND;
                break;
            case        NORTH_ENGLAND:
                region_new = Regions.NW_ENGLAND;
                break;
            case        SOUTH_WEST_ENGLAND:
                region_new = Regions.NW_ENGLAND;
                break;
            case        SOUTH_EAST_ENGLAND:
                region_new = Regions.N_WALES;
                break;
            case        WALES:
                region_new = Regions.N_WALES;
                break;
            default:
                region_new = Regions.MID_ENGLAND;
        }

        Double forecastTemp = DayForecaster.forecast(region_new, int_day);
        String forecastSummary = DayForecaster.forecastSummary(region_new, int_day);


        return new Forecast(forecastSummary, forecastTemp.intValue());
    }
}
