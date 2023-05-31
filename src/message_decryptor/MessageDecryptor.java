package message_decryptor;

import java.util.Map;
import java.util.TreeMap;

public class MessageDecryptor {
	
    // Method to decrypt the encrypted message
    public static String decryptMessage(String encryptedMessage) {
    	
        // Splitting the message into words based on any non-word character
        String[] words = encryptedMessage.split("\\W+");
        
        // Initializing a TreeMap to keep words along with their numerical values
        // TreeMap is chosen because it keeps entries sorted by keys
        Map<Integer, String> wordMap = new TreeMap<>();

        // Iterate through each word
        for (String word : words) {
        	
            // Calculate the sum of all numeric characters in the word
            int sum = word.chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
            
            // Remove all numeric characters from the word
            String onlyLetters = word.replaceAll("\\d", "");
            
            // Add the word with its numerical value to the TreeMap
            // If a key already exists in the map, the new value replaces the old one
            wordMap.put(sum, onlyLetters);
        }

        // Return the words in ascending order of their numerical value as a single string
        // If there are no words, an empty string is returned
        return wordMap.values().stream().reduce((first, second) -> first + " " + second).orElse("");
    }

    // Main method to test the decryptMessage method
    public static void main(String[] args) {
        // Printing the decrypted message for the given encrypted message
        System.out.println(decryptMessage("1yo1ur; ro2ckst2ar;i2nn1er. us6, Come unl1eash 2wi2th1;"));
        System.out.println(decryptMessage("a3t f1or p2a2r1t1y y1o1u p4o1ol o1u3r cinema Waiting"));
        System.out.println(decryptMessage("In2vita1tion 1Night1 Cine1ma Po1ol Mo1vie"));
    }
}
