package com.tls.camel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CamelRestDslApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(CamelRestDslApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CamelRestDslApplication.class, args);
	}
	 @Autowired
	    ApplicationContext applicationContext;
	@Override
	public void run(String... args) throws Exception {
		 /*Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);
	        beansOfType.forEach((s, o) -> {
	            logger.info("{} - {}", s, o.getClass());
	        });
	        Set<String> keys = beansOfType.keySet();
	        // printing the elements of LinkedHashMap
	        for (String key : keys) {
	            System.out.println(beansOfType.get(key));
	        }	*/    
		
	}
}
