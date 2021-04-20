package com.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterNewUser;



@Path("/deletetrip")
public class DeleteTrip {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteUser(@FormParam("tripid") String tripid)
	{
		RegisterNewUser usrDao = new RegisterNewUser();
		boolean tempStatus = false;
		tempStatus=usrDao.deleteUser(tripid);
		
			
		return tempStatus;
	}
}
