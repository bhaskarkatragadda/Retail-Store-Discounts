package com.retail.store.billing

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest
class BillingApplicationTests(@Autowired val client: TestRestTemplate) {

	@Test
	fun contextLoads() {
	}

	@Test
	fun `User Should Be Created`(){

	}



}
