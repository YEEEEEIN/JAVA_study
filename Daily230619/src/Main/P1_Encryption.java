package Main;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class P1_Encryption {
	public static void main(String[] args) {
		String kopo2123 = encrypt("1111222233334444", "안녕하세요");
		System.out.println(kopo2123);

	}

	public static String encrypt(String key, String text) {
		String cipherText = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] keyBytes = Arrays.copyOf(key.getBytes("UTF-8"), 16);
			SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
			IvParameterSpec ivspec = new IvParameterSpec(keyBytes);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);  // new SecretKeySpec(key.getBytes("UTF-8"),"AES") -> secretKeySpec
			byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
			cipherText = new String(Base64.getEncoder().encode(encrypted), "UTF-8");  // Base64.encodeBase64 -> Base64.getEncoder().encode
		} catch (Exception e) {
			cipherText = "";
			e.printStackTrace();
		}
		return cipherText;
	}

}
