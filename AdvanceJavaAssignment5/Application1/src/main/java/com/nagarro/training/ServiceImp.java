package com.nagarro.training;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceImp {

	@Autowired
	private RestTemplate restTemplate;
	
	String url="http://localhost:8079/books";
	
	public void getbooks(){
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Book> entity =new HttpEntity(header);
//		System.out.println(restTemplate.exchange("http://localhost:8079/books/1",HttpMethod.GET,entity,
//				new ParameterizedTypeReference<List<Book>>() {
//			
//			public Type getType() {
//				return super.getType();
//			}
//		}));
//		
//		ResponseEntity<List<Book>> book=restTemplate.exchange(url,HttpMethod.GET,entity,new ParameterizedTypeReference<List<Book>>() {
//			@Override
//			public Type getType() {
//				return super.getType();
//			}
//		});
////		
//		System.out.println("************");
////		List<Book> list=new ArrayList<Book>();
////  list.stream().map(b->{Book book=restTemplate.getForObject("http://localhost:8079/books/1",Book.class);
////  return new Book(b.getbCode(),b.bName,b.getbAuthor(),b.getAddedDate());
////  })
////  .collect(Collectors.toList());
////  System.out.println(list.size());
//		List<Book> list=book.getBody();
//  for(Book b:list) {
//	  System.out.println(b);
//  }
//		Book book=restTemplate.getForObject(url+"/1",HttpMethod.GET,entity, Book.class);
//		System.out.println(restTemplate.getForObject(url, null))
		
		
		System.out.println(restTemplate.getForObject("http://localhost:8079/books",Book.class));
//		return restTemplate.exchange("http://localhost:8079/books",HttpMethod.GET,entity,String.class).getBody();
//	return restTemplate.getForObject("http://localhost:8079/books/1",Book.class);
	
	
	}
	
	public void getbook() {
//		Map<String,Integer> param=new HashMap<>();
//		param.put("id", 1);
//		Book book=restTemplate.getForObject("http://localhost:8079/books",Book.class,param);
//		System.out.println(book);
		System.out.println(restTemplate.getForObject("http://localhost:8079/books",Book.class));
	}
	
	
}
