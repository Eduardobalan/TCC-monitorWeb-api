package br.com.webmonitor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Eduardo Balan on 21/06/2017.
 */
@SpringBootApplication
@ComponentScan("br.com.webmonitor")
@EnableAutoConfiguration
public class WebMonitorApp {

    public static void main(String[] args) {
        SpringApplication.run(WebMonitorApp.class, args);
    }
}
