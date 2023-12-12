package com.example.chat.chat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
class ChatApplicationTests {
	private static TestRestTemplate template;
	private static String baseUrl= "";
	@BeforeAll
	private static void init(){
		template = new TestRestTemplate();

	}

	@Test
	void contextLoads() {

	}

	@Test
	void testWs() {


	}

}
