package Main;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class P4_LoginModule {
	 public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver"); 

	            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23");
	            java.sql.Statement stmt = conn.createStatement();

	            Scanner scanner = new Scanner(System.in);

	            System.out.print("이름을 입력하세요: ");
	            String inputName = scanner.nextLine();

	            System.out.print("비밀번호를 입력하세요: ");
	            String inputPassword = scanner.nextLine();

	            
	            String encryptedInputPassword = encryptPassword(inputPassword);
	            // System.out.println(encryptedInputPassword); // 비밀번호 암호화 확인용
	            // 데이터베이스에서 일치하는 레코드를 찾기 위한 SQL 문을 작성합니다.
	            String sql = "SELECT * FROM login WHERE name = '" + inputName + "' AND password = '" + encryptedInputPassword + "'";

	            // SQL 문을 실행하고 결과를 가져옵니다.
	            
	            ResultSet resultSet = stmt.executeQuery(sql);

	            if (resultSet.next()) {
	                System.out.println("일치합니다.");
	            } else {
	                System.out.println("불일치합니다.");
	            }

	            resultSet.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    
	    private static String encryptPassword(String password) {
	        try {
	            String secretKey = "abcdefghijklmnop"; // 암호화에 사용할 키 (16, 24 또는 32 바이트)
	            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
	            Cipher cipher = Cipher.getInstance("AES");
	            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
	            byte[] encryptedBytes = cipher.doFinal(password.getBytes());
	            return Base64.getEncoder().encodeToString(encryptedBytes);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	}