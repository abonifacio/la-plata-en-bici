package com.laplataenbici.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.laplataenbici.model.domain.Usuario;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class CryptoUtils {
	
	
	private static CryptoUtils instance;
	private final Key aesKey;
	private Cipher cipher;
	private static final String SECRET_KEY = "AugustoBonifacio";

	private CryptoUtils(){
		aesKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
		try {
			cipher = Cipher.getInstance("AES");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CryptoUtils getInstance(){
		if(instance==null){
			instance = new CryptoUtils();
		}
		return instance;
	}
	
	public String generateToken(Usuario u){
		try{
			String text = String.valueOf(u.getId());
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));			
			return Base64.encode(encrypted);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public Long getUserId(String token){
		try{
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] decrypted = cipher.doFinal(Base64.decode(token));
			return Long.valueOf(new String(decrypted));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
