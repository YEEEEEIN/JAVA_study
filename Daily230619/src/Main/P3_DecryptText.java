package Main;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class P3_DecryptText {

	public static void main(String[] args) {
		String key = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"; // 키 값 초기화
        String encryptedText = "ruDZ3CTS5Md3+ipVKt20hQ=="; // 암호화된 텍스트 초기화

        // 마지막 세 글자를 찾기 위해 1부터 999까지 반복문 실행
        for (int i = 1; i < 1000; i++) {
            String paddedNumber = String.format("%03d", i); // 세 자리 숫자를 001 형식으로 포맷팅
            String currentKey = key + paddedNumber; // 현재 키 생성

            // 복호화 실행
            String decryptedText = decrypt(currentKey, encryptedText);

            // 복호화된 텍스트 출력
            System.out.println("Key: " + currentKey);
            System.out.println("Decrypted Text: " + decryptedText);

            // 텍스트에 숫자만 포함되어 있는지 확인
            if (decryptedText.matches("\\d+")) {
                // 텍스트에 숫자만 포함되어 있다면, 메인 메서드에 들어갈 답 출력
                System.out.println("Answer: " + decryptedText);
                break; // 답을 찾았으므로 반복문 종료
            }
        }
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