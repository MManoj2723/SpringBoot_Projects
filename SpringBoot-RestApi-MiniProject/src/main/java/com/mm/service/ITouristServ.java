package com.mm.service;

import java.util.List;

import com.mm.entity.Tourist;

public interface ITouristServ {
	
	
	public String registerTourist(Tourist tourist) throws Exception;
	
	
	public List<Tourist> fetchAllTourist();
	
	
	public List<Tourist> fetchTouristByLoc(String c1,String c2,String c3);
	
	
	public Tourist findTouristById(Integer id);
	
	public Tourist updateTouristDetails(Tourist tourist);
	
	
	public List<Tourist> gettingTouristInfoByName(String name);
	
	
	public String updateTheTouristBudget(double per,int id);
	
	
	public String deleteById(int id);
	
	
	public String deleteTouristsByBudgetRange(double start,double end);
	

}












