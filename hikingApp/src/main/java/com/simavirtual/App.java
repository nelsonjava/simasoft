package com.simavirtual;

import org.hibernate.ogm.demos.ogm101.part1.*;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App{

    public static void main( String[] args ){

	EntityManagerFactory entityManagerFactory;
	entityManagerFactory = Persistence.createEntityManagerFactory( "hikePu" );
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	entityManager.getTransaction().begin();

	// create a Person
	Person bob = new Person( "Bob", "McRobb" );

	entityManager.close();

        System.out.println( "Hello World!" );
    } // main

} // App
