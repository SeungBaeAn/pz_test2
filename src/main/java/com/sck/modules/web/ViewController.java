package com.sck.modules.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sck.model.Example;
import com.sck.modules.example.ExampleRepository;

@Controller
public class ViewController
{

	@Autowired
	private ExampleRepository repository;

	@RequestMapping(value={"/","index", "/app/*", "/app/*/*", "/app/*/*/*"})
	public String intro()
	{
		return "index";
	}

	@RequestMapping("/now")
	public @ResponseBody String now()
	{
		Example row = repository.map();
		System.out.println(row.getNowTime());
		return repository.now();
	}

	@RequestMapping("/login/success")
	public @ResponseBody String loginSuccess()
	{
		return "SUCCESS";
	}

	@RequestMapping("/login/fail")
	public @ResponseBody String loginFail()
	{
		return "FAIL";
	}
}
