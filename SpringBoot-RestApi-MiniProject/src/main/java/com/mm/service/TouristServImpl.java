package com.mm.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.entity.Tourist;
import com.mm.exceptions.TouristNotFoundException;
import com.mm.repository.ITouristRepo;

import jakarta.transaction.Transactional;



@Service
public class TouristServImpl implements ITouristServ{
	
	@Autowired
	private ITouristRepo repo;

	//1
	@Override
	@Transactional
	public String registerTourist(Tourist tourist) {
		
		Tourist save = repo.save(tourist);
		
		if(true) {
			throw new IllegalArgumentException("Throwing The Error Intentionally");
		}
		return "Tourist is saved with the Id:"+save.getId();
		
	}

	//2
	@Override
	public List<Tourist> fetchAllTourist() {
		
		
		
			List<Tourist> list = repo.findAll()
					.stream()
					.sorted((t1,t2)->t1.getId().compareTo(t2.getId())).toList();

				return list;
		
		
		
	}

	//3
	@Override
	public List<Tourist> fetchTouristByLoc(String c1, String c2, String c3) {
		
		List<Tourist> list = repo.findTouristByCities(c1, c2, c3);
		
		return list;
	}

	//4
	@Override
	public Tourist findTouristById(Integer id) {
		
		
		
		Tourist obj = repo.findById(id).orElseThrow(()->new TouristNotFoundException("No Tourist Available With this Id"+id));													
		
		return obj;
	}

	//5
	@Override
	public Tourist updateTouristDetails(Tourist tourist) {
		
		Optional<Tourist> byId = repo.findById(tourist.getId());
		
		if(byId.isPresent()) {
			Tourist save = repo.save(tourist);
			
			return save;
		}
		else {
			throw new TouristNotFoundException("No Tourist Available With this Id"+tourist.getId());
		}
		
	}

	//6
	@Override
	public List<Tourist> gettingTouristInfoByName(String name) {
			
		
		List<Tourist> list = repo.getTouristsByName(name);
		
		return list;
	}

	//7
	@Override
	public String updateTheTouristBudget(double per, int id) {
		
		
		int numUpdate = repo.updateBudgetById(per, id);
		
		
		
		return numUpdate==0?"No Tourist found With That id=>"+id
							
							:"Budget Updated of a Tourist:"+id;
	}
	//8
	
	@Override
	public String deleteById(int id) {

		Optional<Tourist> byId = repo.findById(id);
		
		if(byId.isPresent()) {
			repo.deleteById(id);
			
			return "Tourist deleted with id:"+id; 
		}
		else {
			return "No Tourist Present with that id:"+id;
		}
	
	}

	
	//9
	@Override
	public String deleteTouristsByBudgetRange(double start, double end) {
		
		int numOfUpdates = repo.deleteByBudgetRange(start, end);
		
		return numOfUpdates == 0 ?" No Records Are Found in that Range"
								:numOfUpdates+":Records Are Deleted";
		
	}
	
	
	
	
	

	
}










































