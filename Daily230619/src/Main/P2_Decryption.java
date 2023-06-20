package Main;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class P2_Decryption {

    public static void main(String[] args) {
        String encryptedText = "r6dIlJGzeswDSkCjVjC23A==";
        String decryptedText = decrypt("1111222233334444", encryptedText);
        System.out.println(decryptedText);
    }

    public static String decrypt(String key, String encryptedtext) {
        String plainText = "";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivspec = new IvParameterSpec(Arrays.copyOfRange(key.getBytes("UTF-8"), 0, cipher.getBlockSize()));
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), ivspec);
            Base64.Decoder decoder = Base64.getDecoder();
            plainText = new String(cipher.doFinal(decoder.decode(encryptedtext.getBytes("UTF-8"))), "UTF-8");
        } catch (Exception e) {
            plainText = "";
            e.printStackTrace();
        }
        return plainText;
    }
}