package org.squidmin.gradlelabs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GradleLabsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleLabsApplication.class, args);

        log.info("Gradle command line arguments setting system properties example: {}", System.getProperty("arg_1"));
        log.info("-".repeat(50));
        log.info("Gradle command line arguments to main method example");
        for (String arg : args) {
            log.info("Got argument [" + arg + "]");
        }
    }

}
