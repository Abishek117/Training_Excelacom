package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
	
		//int rowAdded = this.repo.add(entity);
		//return "addProduct";
	}
	
	
	@RequestMapping(value="/product/srch",method=RequestMethod.GET)
	public String searchProduct(Model model)
	{
		return "searchproduct";
			
	}
	@RequestMapping(value="/product/srch",method=RequestMethod.POST)
	public String showProduct(@RequestParam("id")int id,Model model) 
	{
		Product entity= repo.findById(id);
		model.addAttribute("found", entity);
		return "showproduct";
			
	}
	
	@RequestMapping(value="/product/delete", method=RequestMethod.GET)
	public String delete(Model model) {
		
		model.addAttribute("delete","deleteProduct");
		return "deleteproduct";
		
	}
	
	@RequestMapping(value="/product/delete",method=RequestMethod.POST)
	public String remove(@RequestParam("id")int id, Model model) {
		int entity = repo.remove(id);
		model.addAttribute("found",entity);
		return "deletebyid";
		
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String indexOf(Model model) {
		model.addAttribute("title","index");
		return "index";
		
	}

	
	
	
	

}
	
	


