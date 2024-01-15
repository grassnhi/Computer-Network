package Lession;
import java.io.*;
import java.net.*;

public class WebPageDownloader {
    public static void main(String[] args) {
        try {
            String website = "http://www.google.com";
            URI url = new URI(website);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();

            // Get input stream from the connection with specified character encoding
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder content = new StringBuilder();

            // Read the content line by line
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Close the input stream
            in.close();

            // Print the content of the website
            System.out.println(content.toString());

            // Save the content to a local file
            String fileName = "homepage.html"; // Adjust the file name as needed
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content.toString());
            writer.close();

            System.out.println("The webpage has been downloaded and saved as " + fileName);

        }  catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
