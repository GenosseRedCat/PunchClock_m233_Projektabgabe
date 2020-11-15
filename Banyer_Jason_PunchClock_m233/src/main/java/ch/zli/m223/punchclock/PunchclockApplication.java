package ch.zli.m223.punchclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * This class was not created, but modified by Jason Banyer
 * Date: 02.11.2020
 *
 * This is the Backbone of all classes. Without this class, Spring wouldn't know where to start.
 * It is thus designated as "SpringBootApplication"
 *
 * It literally commands spring to "run" this class.
 */
@SpringBootApplication
public class PunchclockApplication {

	public static void main(String[] args) {
		SpringApplication.run(PunchclockApplication.class, args);
	}

}
