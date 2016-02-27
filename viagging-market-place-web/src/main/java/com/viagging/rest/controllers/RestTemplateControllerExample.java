package com.viagging.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.rest.dto.PostJSON;

@RestController //will add automatically the @ResponseBody annotation to all methods
public class RestTemplateControllerExample {
	
	  //JSON SAVES a post
	  @RequestMapping(value = "/savePost", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void savePost(@RequestBody PostJSON postJSON) {
	
		  System.out.println("savePost postJSON.getUserId(): " + postJSON.getUserId());
	  System.out.println("savePost postJSON.getTitle(): " + postJSON.getTitle());
	  System.out.println("savePost postJSON.getId(): " + postJSON.getId());
	  System.out.println("savePost postJSON.getBody(): " + postJSON.getBody());
	  System.out.println("@RestTemplateControllerExample savePost is called");
	  }




}
