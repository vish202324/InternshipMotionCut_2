package Project_1;
import java.util.HashMap;
import java.util.Random;

public class URLShortener {
    // HashMap to store long and short URLs
    private final HashMap<String, String> urlMap;
    private final String domain;
    private final String chars;
    private final Random random;

    // Constructor to initialize variables
    public URLShortener() {
        urlMap = new HashMap<>();
        domain = "http://short.url/";  // Base domain for the short URLs
        chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        random = new Random();
    }

    // Method to generate a short URL
    public String shortenURL(String longURL) {
        String shortURL = domain + generateKey();
        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    // Method to retrieve the original URL from a short URL
    public String retrieveURL(String shortURL) {
        return urlMap.getOrDefault(shortURL, "URL not found.");
    }

    // Helper method to generate a random 6-character key
    private String generateKey() {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            key.append(chars.charAt(random.nextInt(chars.length())));
        }
        return key.toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        // Testing the URL shortener
        String longURL = "https://www.example.com/very/long/url/to/be/shortened";
        String shortURL = shortener.shortenURL(longURL);
        System.out.println("Original URL: " + longURL);
        System.out.println("Shortened URL: " + shortURL);

        // Retrieve the original URL using the shortened URL
        String retrievedURL = shortener.retrieveURL(shortURL);
        System.out.println("Retrieved URL: " + retrievedURL);
    }
}
