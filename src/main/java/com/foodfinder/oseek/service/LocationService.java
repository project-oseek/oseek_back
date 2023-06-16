package com.foodfinder.oseek.service;

import com.foodfinder.oseek.dto.location.LocationResDto;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@RequiredArgsConstructor
@Service
public class LocationService {


    @Value("${kakao.location.api-key}") private String API_KEY;

    public LocationResDto findMemberLocationDetail(double longitude, double latitude) throws java.io.IOException {
        LocationResDto locationResDto = new LocationResDto();
        locationResDto.setLongitude(longitude);
        locationResDto.setLatitude(latitude);

        try {
            locationResDto = getAddressFromCoordinates(locationResDto);
        } catch (IOException | java.io.IOException e) {
            throw e;
        }

        return locationResDto;
    }

    private LocationResDto getAddressFromCoordinates(LocationResDto locationResDto) throws IOException, java.io.IOException {
        String apiUrl = "https://dapi.kakao.com/v2/local/geo/coord2address.json?x=" + locationResDto.getLongitude() + "&y=" + locationResDto.getLatitude();

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "KakaoAK " + API_KEY);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        br.close();

        return parseAddressFromResponse(response.toString(), locationResDto);
    }

    private LocationResDto parseAddressFromResponse(String jsonResponse, LocationResDto locationResDto) {

        try {
            JSONObject responseJson = new JSONObject(jsonResponse);
            JSONArray documents = responseJson.getJSONArray("documents");
            if (documents.length() > 0) {

                JSONObject addressObject = documents.getJSONObject(0).getJSONObject("address");
                String region_1depth_name = (String) addressObject.get("region_1depth_name");
                String region_2depth_name = (String) addressObject.get("region_2depth_name");
                String region_3depth_name = (String) addressObject.get("region_3depth_name");

                locationResDto.setRegion_1depth_name(region_1depth_name);
                locationResDto.setRegion_2depth_name(region_2depth_name);
                locationResDto.setRegion_3depth_name(region_3depth_name);

                return locationResDto;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}