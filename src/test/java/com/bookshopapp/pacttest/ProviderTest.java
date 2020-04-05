package com.bookshopapp.pacttest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.bookshopapp.model.entities.Book;
import com.bookshopapp.model.service.MyConsumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ProviderTest {

	private int PORT = 8090;
			
			@Rule
		    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("mybookservice", "localhost", PORT, this);
			
			@Pact(consumer = "consumer1",provider="mybookservice")
		    public RequestResponsePact  createPact(PactDslWithProvider builder) {
		         Map<String, String> headers = new HashMap<String, String>();
		        return builder
		        		.given("Head Fiest Java is created")
		                .uponReceiving("request a book")
		                .path("/bookshopmaintenanceapplication/api/book/7")
		                .method("GET")
		                .willRespondWith()
		                .status(200)
		                .body("{\"bookName\":\"Head First Java\",\"bookPrice\":\"498\",\"publisherName\":\"Raj\",\"publishingYear\":\"2005\"}")
		                .toPact();
		    }
			
			@Test
			 
			  @PactVerification(value="mybookservice") public void testData() {
			  
			  Book book = MyConsumer.getBook(PORT, 7);
			  Assert.assertTrue(book.getBookName().equals("Head First Java")&&
		/* book.getBookPrice()==498 && */
			  book.getPublisherName().equals("Raj"));
		/* && book.getPublishingYear()==2005);*/
			  
			  
			  }

		}





