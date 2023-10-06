package com.dakota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Main class for application

//VVV how to specify that it's a spring boot application it condenses a few different annotation reducing syntax clutter
@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
//^^ condenses a few annotations a part of web mvc that helps handles http request for you making things a lot easier
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //^^^required method in springboot main class
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    static record NewCustomerRequest(
        String name,
        String email,
        Integer age
    ){}

    //VV Postmapping because it is a post request
    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email);
        customer.setAge(request.age());
        customerRepository.save(customer);

    }
    //^^Code for adding customers to the psql database It takes a json object


    //VV Code for deleting row in the table based off the id
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable ("customerId")Integer id){
        customerRepository.deleteById(id);
    }



 /*   //VV Simpler form of RequestMapping GetMapping is made for HTTP get request
@GetMapping("/greet")// /greet is the path if this server got a request on port 3000 with a path /greet this method would run
    public GreetResponse greet(){
        return new GreetResponse("wassup", List.of("Java","php","C++"));
    }

    record GreetResponse(
            String greet,
            List<String> favProgramminglg
    ){}
*/
}