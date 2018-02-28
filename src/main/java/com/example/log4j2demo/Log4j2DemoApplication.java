package com.example.log4j2demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4j2DemoApplication implements ApplicationRunner {
	private static final Logger logger = LogManager.getLogger("FileAppender");

	public static void main(String[] args) {
		SpringApplication.run(Log4j2DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

        //
        //Prepare map with attributes valid for input
        //
        MapMessage msgRequest = new MapMessage();
        msgRequest.put("processName", "BUSINESS_PROCESS_NAME");
        msgRequest.put("EventState", "start");
        msgRequest.put("extIdSu", "ext_subscriber_id_value");
        //msg.put("extIdSu", "ext_subscriber_id_value");
        //msg.put("extIdSu", "ext_subscriber_id_value");

        logger.info(msgRequest);

        //
        //Prepare map with attributes valid for output
        //
        MapMessage msgResponse = new MapMessage();
        msgResponse.put("processName", "BUSINESS_PROCESS_NAME");
        msgResponse.put("EventState", "stop");
        msgResponse.put("extIdSu", "ext_subscriber_id_value");
        msgResponse.put("status", "OK");

		logger.info(msgResponse);

	}
}
