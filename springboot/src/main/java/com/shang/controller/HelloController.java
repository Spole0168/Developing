package com.shang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/say.html")
	@ResponseBody
	public String hello(){
		return "Hello HHHH!";
	}
	
	@RequestMapping(value="/resful/list/{id}")
	@ResponseBody
	public String resful(@PathVariable String id){
		return "id="+id;
	}
	
	@RequestMapping(value="/test/index.btl")
	public String resful(Model m){
		m.addAttribute("name","HHH,hhh");
		return "/index.btl";
	}
	
	
}
