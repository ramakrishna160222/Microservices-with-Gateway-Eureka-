package com.krishna;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;

@RestController
@RequestMapping("/user")

public class UserController {
	
	
	@Autowired
	private RestTemplate restTemplate;


		@GetMapping(value="/{userId}")
		public User getUser(@PathVariable("userId") String userId) {
			User userOne=new User(userId,"User Name"+userId,"xxxx"+userId);
			
			
			
			Post post=restTemplate.getForObject
					("http://post-service/post/1/", Post.class);
			userOne.setPost(post);
			Notification notification=restTemplate.
					getForObject("http://localhost:8080/notification/1", Notification.class);
			userOne.setNotification(notification);
			
			return userOne;
		}
}
