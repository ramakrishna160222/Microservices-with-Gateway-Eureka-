package com.krishna;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

	@GetMapping(value="/{postId}")
	public Post getPost(@PathVariable("postId") String postId) {
		Post postOne=new Post(postId,"Post Description for "+postId);
		return postOne;
	}
}
