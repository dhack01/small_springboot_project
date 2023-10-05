package com.dakota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Main class for application

//VVV how to specify that it's a spring boot application it condenses a few different annotation reducing syntax clutter
@SpringBootApplication
@RestController
//^^ condenses a few annotations a part of web mvc that helps handles http request for you making things a lot easier
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //^^^required method in springboot main class
    }

    //VV Simpler form of RequestMapping GetMapping is made for HTTP get request
@GetMapping("/greet")// /greet is the path if this server got a request on port 3000 with a path /greet this method would run
    public GreetResponse greet(){
        return new GreetResponse("wassup");
    }

    record GreetResponse(String greet){}
}
