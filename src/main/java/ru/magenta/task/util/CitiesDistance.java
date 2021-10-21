package ru.magenta.task.util;

import org.springframework.stereotype.Component;
import ru.magenta.task.entity.City;

import java.util.ArrayList;
import java.util.List;

@Component
public class CitiesDistance {
    public static float distFrom(City from, City to) {

        float lat1 = from.getLatitude();
        float lng1 = from.getLongitude();
        float lat2 = to.getLatitude();
        float lng2 = to.getLongitude();


        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }

    public static List<Float> distFrom(List<City> from, List<City> to) {
        List<Float> result = new ArrayList<>();
        for (int i = 0; i < from.size(); i++)
            result.add(distFrom(from.get(i), to.get(i)));

        return result;
    }
}
