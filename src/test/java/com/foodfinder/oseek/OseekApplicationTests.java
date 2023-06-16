package com.foodfinder.oseek;

import io.jsonwebtoken.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
class OseekApplicationTests {
    private static final String API_KEY = "3d14807b0b451bd6893386270fd4f310";
    @Test
    void contextLoads() {

        test();
    }


    public static void test() {
        double latitude = 37.5665; // 위도
        double longitude = 126.9780; // 경도

        try {
            String address = getAddressFromCoordinates(latitude, longitude);
            System.out.println("주소: " + address);
        } catch (IOException | java.io.IOException e) {
            System.err.println("주소 변환 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static String getAddressFromCoordinates(double latitude, double longitude) throws IOException, java.io.IOException {
        String apiUrl = "https://dapi.kakao.com/v2/local/geo/coord2address.json?x=" + longitude + "&y=" + latitude;

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

        // JSON 파싱 등을 통해 주소 추출
        // 주소 추출 예시:
        // String address = parseAddressFromResponse(response.toString());

        return response.toString();
    }

}
