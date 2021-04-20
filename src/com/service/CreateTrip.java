package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterNewUser;

@Path("/tripCreate")
public class CreateTrip {
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> createTrip(@FormParam("from") String fromLoc,@FormParam("to") String toLoc,
			@FormParam("start") String startTime,@FormParam("end") String endTime,
			@FormParam("uid") int uid, @FormParam("dist") String distance, @FormParam("date") String date)
    {
		List<String> tripResponse = new ArrayList<String>();

		RegisterNewUser ob = new RegisterNewUser();
		boolean status = ob.createNewTrip(fromLoc, toLoc, startTime, endTime, distance, uid,date);
		
		if(status)
		{
			tripResponse.add("New Trip Created");
			return tripResponse;
		}
		else
			tripResponse.add("Trip not created");
		
		
		System.out.println(tripResponse.get(0).toString());
		return tripResponse;
		
    }
}
