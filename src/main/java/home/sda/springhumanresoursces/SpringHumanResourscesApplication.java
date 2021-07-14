package home.sda.springhumanresoursces;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.ExcludeSuperclassListeners;

@Slf4j
@SpringBootApplication
public class SpringHumanResourscesApplication {

    public static void main(String[] args) {

        log.info("Engine started! Yes!");
        SpringApplication.run(SpringHumanResourscesApplication.class, args);
        log.info("I'm ready!");
    }

}
