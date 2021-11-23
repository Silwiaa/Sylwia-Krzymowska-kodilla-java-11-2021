package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String,Double> calculateForecast() {
        Map<String,Double> resultMap = new HashMap<>();

        for(Map.Entry<String,Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calcAverageTemp() {
        double i = 0.0;
        double sum = 0.0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            double myTemperature = temperature.getValue();
            sum += myTemperature;
            ++i;
        }
        return sum / i;
    }

    public double calcMedianTemp() {
        double median = 0.0;
        List<Double> temperatureList = new ArrayList<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            temperatureList.add(temperature.getValue());
        }

        Collections.sort(temperatureList);
        int ListSize = temperatureList.size();

        if (ListSize % 2 == 0) {
            double value1 = temperatureList.get((ListSize /2)-1);
            double value2 = temperatureList.get(ListSize /2);
            median = (value1 + value2) / 2;
        } else {
            median = temperatureList.get((ListSize - 1) /2);
        }

        return median;
    }
}
