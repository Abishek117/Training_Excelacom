package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Product;
import com.example.demo.ifaces.ProductRepository;

@Controller
public class ProductController {
	 
    @Autowired
	private Product entity;
    
    @Autowired
    private ProductRepository repo;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String initForm(Model model)
	{
		model.addAttribute("title","Add Products");
		model.addAttribute("command",entity);
		
		return "addProduct";
	}
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("command") Product entity)
	{
		try
		{
			this.repo.add(entity);
			return "success";
		}
		catch(Exception e)
		{
			return "failure";
		}
	}
	
	

}
