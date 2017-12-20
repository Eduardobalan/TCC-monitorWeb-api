package br.com.monitorweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Eduardo Balan on 02/09/2017.
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.monitorweb")
@EntityScan({"br.com.monitorweb"})
@EnableJpaRepositories(basePackages = {"br.com.monitorweb.repository"})
public class WebMonitorAppTest {

    public static void main(String[] args) {
        SpringApplication.run(WebMonitorAppTest.class, args);
    }
}
