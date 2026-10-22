package com.snhu;
import java.security.SecureRandom;

// Unique ID Generator that ensures a 10-digit randomly generated ID that is private and unalterable
public class IdGenerator {

    // Define the pool of allowed characters (alphanumeric)
    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int ID_LENGTH = 10;
    private static final SecureRandom random = new SecureRandom();

    
    // Generates a random 10-character unique ID.
     
    public static String generateID() {
        StringBuilder id = new StringBuilder(ID_LENGTH);
        
        for (int i = 0; i < ID_LENGTH; i++) {
            // Pick a random index from the character pool
            int randomIndex = random.nextInt(CHAR_POOL.length());
            // Append that character to the ID
            id.append(CHAR_POOL.charAt(randomIndex));
        }
        
        return id.toString();
    }
}
    