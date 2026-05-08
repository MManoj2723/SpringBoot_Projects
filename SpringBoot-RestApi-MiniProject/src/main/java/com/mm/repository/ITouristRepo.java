package com.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mm.entity.Tourist;

import jakarta.transaction.Transactional;

public interface ITouristRepo 
					extends JpaRepository<Tourist, Integer>{
	
	
	@Query("from Tourist where city in (:city1,:city2,:city3) order by name asc")
	public List<Tourist> findTouristByCities(String city1,String city2,String city3);
	
	
	
	@Query("from Tourist where name=:tName")
	public List<Tourist> getTouristsByName(@Param("tName")String tname);
	
	
	
	@Modifying
	@Transactional
	@Query("update Tourist set budget=budget+(budget*:per) where id=:tid")
	public int updateBudgetById(double per,int tid);
	
	
	@Modifying
	@Transactional
	@Query("delete from Tourist where budget between :start and :end")
	public int deleteByBudgetRange(double start,double end);

	
}
