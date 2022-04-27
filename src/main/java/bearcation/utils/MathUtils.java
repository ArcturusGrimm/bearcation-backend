package bearcation.utils;

public class MathUtils {
    public static Double toRad(Double value) {
        return (value * Math.PI) / 180.0;
    }

    public static Double calculateDistance(Double slat1, Double long1, Double slat2, Double long2) {
        double R = 3950.0; // km
        double dLat = toRad(slat2 - slat1);
        double dLong = toRad(long2 - long1);
        double lat1 = toRad(slat1);
        double lat2 = toRad(slat2);

        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.sin(dLong / 2) * Math.sin(dLong / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
