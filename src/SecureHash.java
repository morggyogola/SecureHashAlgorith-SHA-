import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureHash {

    private static final String LAB_KEY = "0C/5F7QHdMv40uVGaTbt5nXdJOxi105k2LN9goPRqTUrwZrdYOYbvC0sJz7G0iT9";

    public static String Hash512Msg(String payload) {
        String result = null;
        try {
            String data = payload + LAB_KEY;
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            // ** NOTE: All bytes that are retrieved from the data string must be done so using UTF-8 Character Set.
            byte[] hashBytes = data.getBytes("UTF-8");
            // Create the hash bytes from the data
            byte[] messageDigest = digest.digest(hashBytes);
            // Create a HEX string from the hashed data
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            // Log your errors;
            ex.printStackTrace();
        }
        // Sample result: 2611e1ad3a8077020c55a227408329f0b2bb4f00c0e409a93abd69dba133c5d5a7d7575fef87cb13a9d5319c2f78199d8e674ce6f7d63acea95ae5a214ad9f5a
        return result;
    }

    public static void main(String[] args) {
        String param1 = "Aymard";
        String    param2 = "Gildas";
        String    param3= "MILANDOU";
        String   param4 = "Ecobank";
        String    param5 = "Group";

        String payload = param1+param2+param3+param4+param5;

        String hashedValue = Hash512Msg(payload);

        System.out.println("Hashed Value: " + hashedValue);
    }
}