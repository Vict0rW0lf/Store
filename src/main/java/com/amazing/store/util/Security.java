package com.amazing.store.util;

import java.security.NoSuchAlgorithmException;

public class Security {
	
	public static boolean authenticate(String password, String passwordDatabase) throws NoSuchAlgorithmException {
		return passwordDatabase.contentEquals(MD5.turnIntoMD5(password));
	}

}
