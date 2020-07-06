package com.amazing.store.util;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SecurityTest {

	@Test
	public void testShouldAuthenticate() throws NoSuchAlgorithmException {
		Assertions.assertEquals(true, Security.authenticate("banana", "72B302BF297A228A75730123EFEF7C41"));
		Assertions.assertEquals(true, Security.authenticate("apple", "1F3870BE274F6C49B3E31A0C6728957F"));
		Assertions.assertEquals(true, Security.authenticate("pineapple", "9DEE45A24EFFFC78483A02CFCFD83433"));
	}
	     
	@Test
	public void testShouldNotAuthenticate() throws NoSuchAlgorithmException {
		Assertions.assertEquals(false, Security.authenticate("banana", "72B302BF297A300B75730123EFEF7C41"));
		Assertions.assertEquals(false, Security.authenticate("apple", "1F3870BE274F7C50B3E31A0C6728957C"));
		Assertions.assertEquals(false, Security.authenticate("pineapple", "8DEE45A24EFFFC78483A02CFCFD83433"));
	}
	
}
