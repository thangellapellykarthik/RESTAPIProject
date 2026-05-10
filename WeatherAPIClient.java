import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIClient {

    public static void main(String[] args) {

        try {

            // Weather API URL
            String apiUrl =
                "https://api.open-meteo.com/v1/forecast?latitude=17.3850&longitude=78.4867&current_weather=true";

            // Create URL object
            URL url = new URL(apiUrl);

            // Open connection
            HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();

            System.out.println("HTTP Response Code: " + responseCode);

            // Read response
            BufferedReader reader =
                new BufferedReader(
                    new InputStreamReader(
                        connection.getInputStream()
                    )
                );

            String inputLine;

            StringBuilder response =
                new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {

                response.append(inputLine);
            }

            reader.close();

            // Display JSON response
            System.out.println("\nWeather API Response:\n");

            System.out.println(response.toString());

            connection.disconnect();

        } catch (Exception e) {

            System.out.println("Error occurred.");

            e.printStackTrace();
        }
    }
}