package pl.giantscastle.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import pl.giantscastle.DAO.UserDao;

@SpringBootApplication
@ComponentScan("pl.giantscastle.*")
public class Application {
		

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
