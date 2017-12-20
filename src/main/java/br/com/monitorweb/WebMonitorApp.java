package br.com.monitorweb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Eduardo Balan on 21/06/2017.
 */
@SpringBootApplication
@ComponentScan("br.com.monitorweb")
public class WebMonitorApp {

    public static void main(String[] args) {
        SpringApplication.run(WebMonitorApp.class, args);
    }
}
