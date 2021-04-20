package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterNewUser;
import com.pojo.TripDtls;

@Path("/filterTripData")
public class FilterDate {


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<TripDtls> getTripDtls(@FormParam("userId") int id,@FormParam("date") String date)
	{
		List<TripDtls> ob = new ArrayList<TripDtls>();
		
		RegisterNewUser obj = new RegisterNewUser();
		ob = obj.filterTrip(id, date);
	
		return ob;
}
}
