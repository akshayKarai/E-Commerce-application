package uncc.ssdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("uncc.ssdi")
public class Ssdi2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ssdi2Application.class, args);
	}
}
