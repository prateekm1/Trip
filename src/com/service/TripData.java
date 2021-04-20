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

@Path("/tripData")
public class TripData {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<TripDtls> getTripDtls(@FormParam("userId") int id)
	{
		List<TripDtls> ob = new ArrayList<TripDtls>();
		
		RegisterNewUser obj = new RegisterNewUser();
		ob = obj.fetchtripDtls(id);
		int n = ob.size();
//		for(int i=0;i<n;i++)
//		{
//			System.out.println(ob.get(i));
//		}
		return ob;
		
	}
}
