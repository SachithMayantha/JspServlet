package com.jspservlet.util;

import java.util.Base64;

public class EncryptDecrypt {
	public String encrypt(String ep) {
		String en = Base64.getEncoder().encodeToString(ep.getBytes());
		return en;
	}
	public String decrypt(String encrypted) {
		return new String(Base64.getDecoder().decode(encrypted));
	}
}
