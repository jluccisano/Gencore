package com.gencore.backend.java.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordGenerator {
	
	
	private static final Random random = new Random();
	private static final String PASSWORD_POSSIBILITIES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ123456789";
	private static final int PASSWORD_LENGTH = 8;
	 
	public static String generateNewPassword ( String login ) {
		
		StringBuffer buffer = new StringBuffer();
		
		
		int i, randomValue;	
		String password = null;;
		
		for ( i = 0 ; i < PASSWORD_LENGTH ; i++ ) {
			randomValue = random.nextInt( PASSWORD_POSSIBILITIES.length() );
			buffer.append( PASSWORD_POSSIBILITIES.charAt( randomValue ) );
		}
		
		password = buffer.toString();
	
		return password;
	}
	
	public static String generateHashedPassword ( String login , String password ) {
		
		String salt = '{' + login +'}';
		
		String hashedPassword = null;
		
		password += salt;
		
		try {
			hashedPassword = encryptToSHA1(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return hashedPassword;
	}
	
	private static String encryptToSHA1(String text) throws NoSuchAlgorithmException , UnsupportedEncodingException  {
	    	MessageDigest md = MessageDigest.getInstance("SHA-1");
	    	byte[] sha1hash = new byte[40];
	    	md.update(text.getBytes("iso-8859-1"), 0, text.length());
	    	sha1hash = md.digest();
	    	return convToHex(sha1hash);
	    }
	
    private static String convToHex(byte[] data) {
        
    	StringBuilder buf = new StringBuilder();
        
    	for (int i = 0; i < data.length; i++) {
            
    		int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
           
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
                
            } while(two_halfs++ < 1);
        }
        return buf.toString();
    }

   

	
	
	
	
}
