package com.service;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterNewUser;

@Path("/registerNewUser/")
public class RegisterUserService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> registerNewUser(@FormParam("userName") String userName,@FormParam("email") String email,
			@FormParam("address") String address,@FormParam("password") String password)
	{
		List<String> registerResponse = new ArrayList<String>();
		
		RegisterNewUser ob = new RegisterNewUser();
		
		boolean status = ob.registerNewUser(userName, email, address, password);
		
		if(status)
		{
			registerResponse.add("User Created");
			return registerResponse;
		}
		else
			registerResponse.add("User not created");
		
		return registerResponse;
	}
}
