package com.training.model;

import java.util.List;

import com.example.demo.services.Product;
import com.example.demo.services.ProductService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
	private static ProductService service = new ProductService();
	
	
	//findAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> findAll()
	{
		return service.findAll();
	}
	
	
	//findbyID
	@GET
	@Path("/srch/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id")int id){
		try
		{
		Product entity = service.findById(id)
					.orElseThrow (() -> new RuntimeException("id not found"));
                 	return Response.ok(entity).status(202,"founded").build();
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			return Response.ok("id not found").status(400).build();
                 
		}
	}
	
	
	//Add
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response addProduct(Product entity)
	{

		int result=service.addProduct(entity);
		if(result!=0) {
			return Response.ok(entity).status(201).build();
		}else {
			return Response.status(400,"Not Created").build();
		} 
	}
	
	
	
	//Delete
	@DELETE
	@Path("{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteByName(@PathParam("productId")int id)
	{
		int result= service.deleteById(id);
		if(result!=0)
		{
			return Response.ok("one resource deleted").status(204).build();
		}
		else
		{
			return Response.status(400,"not deleted").build();
		}
	}
	
	
	
	//Update
	@PUT
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePriceById(@PathParam("productId")  int id , Product product )
	{
		int result= service.updatePriceById(id,product.getPrice());
		
		if(result!=0)
		{
	 return Response.ok(product).build();
				}
				else {
				return Response.status(400,"Not updated").build();
		}
	}

}
	
	
	


