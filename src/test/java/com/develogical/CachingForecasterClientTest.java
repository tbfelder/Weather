package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CachingForecasterClientTest {

    private final ForecasterClient delegate = mock(ForecasterClient.class);


    private final CachingForcasterClient underTest = new CachingForcasterClient(delegate);

    @Test
    public void TestForcastLondonToday() {
        when(delegate.forecastFor(Region.LONDON, Day.WEDNESDAY)).thenReturn(new Forecast("Sunny", 70));
       Forecast testForecast = underTest.forecastFor(Region.LONDON, Day.WEDNESDAY);

       assertEquals(70, testForecast.temperature());

    }

    @Test
    public void RandomForcastLondonToday() {

        int temperature = new Random().nextInt();
        when(delegate.forecastFor(Region.LONDON, Day.WEDNESDAY)).thenReturn(new Forecast("Sunny", temperature));
        Forecast testForecast = underTest.forecastFor(Region.LONDON, Day.WEDNESDAY);

        assertEquals(temperature, testForecast.temperature());

    }

    @Test
    public void CallForecastOnlyOnce() {
        int temperature = new Random().nextInt();
        when(delegate.forecastFor(Region.LONDON, Day.WEDNESDAY)).thenReturn(new Forecast("Sunny", temperature));
        Forecast testForecast1 = underTest.forecastFor(Region.LONDON, Day.WEDNESDAY);
        Forecast testForecast2 = underTest.forecastFor(Region.LONDON, Day.WEDNESDAY);

        verify(delegate, times(1)).forecastFor(any(), any());

    }

    @Test
    public void LimitedCacheSize() {
        int cacheSize = underTest.cachesize;
        int temperature = new Random().nextInt();
        when(delegate.forecastFor(Region.LONDON, Day.WEDNESDAY)).thenReturn(new Forecast("Sunny", temperature));
        when(delegate.forecastFor(Region.LONDON, Day.MONDAY)).thenReturn(new Forecast("Sunny", temperature));
        when(delegate.forecastFor(Region.GLASGOW, Day.THURSDAY)).thenReturn(new Forecast("Sunny", temperature));
        when(delegate.forecastFor(Region.BIRMINGHAM, Day.THURSDAY)).thenReturn(new Forecast("Sunny", temperature));
        underTest.forecastFor(Region.LONDON, Day.WEDNESDAY);
        underTest.forecastFor(Region.LONDON, Day.MONDAY);
        underTest.forecastFor(Region.GLASGOW, Day.THURSDAY);
        underTest.forecastFor(Region.BIRMINGHAM, Day.THURSDAY);

        underTest.forecastFor(Region.LONDON, Day.WEDNESDAY);

        verify(delegate, times(5)).forecastFor(any(), any());


    }

}
