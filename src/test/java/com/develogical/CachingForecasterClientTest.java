package com.develogical;

import com.weather.Forecast;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CachingForecasterClientTest {

    private final ForecasterClient delegate = mock(ForecasterClient.class);


    private final CachingForcasterClient underTest = new CachingForcasterClient(delegate);

    @Test
    public void TestForcastLondonToday() {
when(delegate.forecastFor("London", "Wednesday")).thenReturn(new Forecast("Sunny", 70));
       Forecast testForecast = underTest.forecastFor("London", "Wednesday");

       assertEquals(70, testForecast.temperature());

    }



}
