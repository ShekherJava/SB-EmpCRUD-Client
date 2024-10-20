package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;

@Component
public class MyApplicationRunner implements ApplicationRunner {
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String url = "http://localhost:8080/api/{id}";
		
		// param1 : url
		// param2 : response type as Class object
		// param3 : the value to the uri variable
		//Employee e = restTemplate.getForObject(url, Employee.class, 7121);
		
		//System.out.println(e);
		
		/*
		ResponseEntity<Employee> re = restTemplate.getForEntity(url, Employee.class, 7201);
		System.out.println("Http status code : " + re.getStatusCode().value());
		System.out.println(re.getBody());
		*/
		
		String postUrl = "http://localhost:8080/api/add";
		Employee newEmployee = new Employee(5121, "Juli", 9999.0, 20);
		
		//param1: url
		//param2: object to be sent in the request body
		//param3: response type as Class object
		//String message = restTemplate.postForObject(postUrl, newEmployee, String.class);
		//System.out.println("Message : "+ message);
		
		//ResponseEntity<String> re = restTemplate.postForEntity(postUrl, newEmployee, String.class);
		//System.out.println(re.getBody());
		
		//invoking POST url, using exchange() method
		HttpEntity<Employee> entity = new HttpEntity<>(newEmployee);
		//param1: url
		//param2: HttpMethod
		//param3: HttpEntity
		//param4: respone type as a Class object
		
		ResponseEntity<String> re = restTemplate.exchange(postUrl, HttpMethod.POST, entity, String.class);
		System.out.println(re.getBody());
		

	}

}
