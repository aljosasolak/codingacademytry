package com.aljosasolak.codingacademyTry;

import com.aljosasolak.codingacademyTry.model.Event;
import com.aljosasolak.codingacademyTry.model.Venue;
import com.aljosasolak.codingacademyTry.resource.EventResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingacademyTryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingacademyTryApplication.class, args);

		EventResource er = new EventResource();
		er.getEventId();
	}

}
