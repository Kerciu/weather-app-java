package main.java.Backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GeocodingService {
    public static JSONArray getGeographicCoordinates(String locationName) {
        locationName = locationName.replaceAll(" ", "+");
        String url = buildLocationURL(locationName);
        JSONObject response = APIUtils.callAPI(url);
        return (JSONArray) response.get("results");
    }

    private static String buildLocationURL(String locationName) {
        return "https://geocoding-api.open-meteo.com/v1/search?name=" + locationName +
                "&count=10&language=en&format=json";
    }
}
