package co.edu.uco.terraxs.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"co.edu.uco.terraxs"})
public class TerraxsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerraxsApplication.class, args);
	}

}
