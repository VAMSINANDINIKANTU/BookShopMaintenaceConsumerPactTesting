package com.bookshopapp.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


import com.bookshopapp.model.entities.Book;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MyConsumer {
		public static String readAll(InputStream stream) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(stream));
			try {
				StringBuilder result = new StringBuilder();
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					result.append(inputLine);
				return result.toString();
			} finally {
				in.close();
			}
		}
		
		
		public static Book getBook(int port, int id) {
			
			Book book = null;

			try {
				URLConnection url = new URL("http://localhost:" + port + "/bookshopmaintenanceapplication/api/book/" + id).openConnection();
				InputStream stream = url.getInputStream();
				String result = readAll(stream);

				byte[] jsonData = result.getBytes();

				// create ObjectMapper instance
				ObjectMapper objectMapper = new ObjectMapper();

				// convert json string to object
				book = objectMapper.readValue(jsonData, Book.class);

				

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return book;
		}

		public static void main(String[] args) {
			

		}

	}