package com.restservice.hello;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping( path="/helloworld")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping(path="/helloworldbean")
	  public HelloWorldBean helloworldbean() {
		  return new HelloWorldBean("Hello World Bean");
	  }
	
	@GetMapping(path="/helloworldbean/path/{name}")
	  public HelloWorldBean helloworldbeanpath(@PathVariable String name) {
		  return new HelloWorldBean("Hello World   "+ name);
	  }
	
	@GetMapping(path="/helloworldi18n")
	  public String helloworldInternationalized() {
		  return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	  }
}
