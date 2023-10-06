package com.dakota;

import org.springframework.data.jpa.repository.JpaRepository;

//This interface gives the classes that implements the ability to do all the crud operations
public interface CustomerRepository
        extends JpaRepository<Customer,Integer> { //If this was to go out into production would be smart to get rid of the deletall in JpaRep

}
