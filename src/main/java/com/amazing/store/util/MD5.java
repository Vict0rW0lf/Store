package com.amazing.store.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD5 {

	public static String turnIntoMD5(String txt) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		byte[] digest = md.digest(txt.getBytes(StandardCharsets.UTF_8));
		return DatatypeConverter.printHexBinary(digest);
	}
	
	
}
