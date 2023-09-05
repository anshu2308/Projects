package com.nagarro.training;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientService {
 
	@Autowired
	private RestTemplate restTemplate;
	
	String url="http://localhost:8079/books";
	public  List<Book> getbooks() {
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Book> entity =new HttpEntity(header);
//		System.out.println(restTemplate.exchange("http://localhost:8079/books",HttpMethod.GET,entity,String.class));
		ResponseEntity<List<Book>> book=restTemplate.exchange(url,HttpMethod.GET,entity,new ParameterizedTypeReference<List<Book>>() {
			@Override
			public Type getType() {
				return super.getType();
			}
		});
		List<Book> list=book.getBody();
		  for(Book b:list) {
			  System.out.println(b);
		  }
		return list;
	}
	public void getbook() {
//		System.out.println(restTemplate.getForObject(url+"/1",Book.class));
	}
	
	public void postbook(Book b) {
		Date d=new Date();

		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Book> entity =new HttpEntity(b,header);
		System.out.println(restTemplate.exchange("http://localhost:8079/books",HttpMethod.POST,entity,Book.class).getBody());
 }
	
	public void  deletebook(int code) {
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Book> entity =new HttpEntity(header);
		System.out.println(restTemplate.exchange(url+"/"+code,HttpMethod.DELETE,entity,Book.class).getBody());
	 }
}
