/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.security;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.jboss.security.Base64Encoder;

public class PassGenerator {
    
	public static String generate(String rawPassword){
		
		try {
			
			byte[] hash = java.security.MessageDigest.getInstance("SHA-256")
					.digest(rawPassword.getBytes("UTF-8"));
			
			return Base64Encoder.encode(hash);
			
		} catch (IOException | NoSuchAlgorithmException e) {
			
			throw new RuntimeException(e);
		} 
	}
}