package exam;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingExample {

    public static String hashWithSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        // Convert byte array to hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        String input = "Hello World";
        try {
            String hashedOutput = hashWithSHA256(input);
            System.out.println("Input: " + input);
            System.out.println("SHA-256 Hash: " + hashedOutput);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
