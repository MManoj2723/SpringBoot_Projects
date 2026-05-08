package com.mm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mm.entity.Tourist;
import com.mm.exceptions.TouristNotFoundException;
import com.mm.repository.ITouristRepo;
import com.mm.service.TouristServImpl;

@ExtendWith(MockitoExtension.class)
public class ServImplTest {
	
	
	@Mock
	private ITouristRepo  repo;
	
	@InjectMocks
	private TouristServImpl service;
	
//	private static  List<Tourist> list = List.of(new Tourist(101,"A","Delhi","7",5000d),
//												new Tourist(102,"B","jaipur","5",4000d));
	
	
	
	
	
	@Test
    void testRegisterTourist() throws Exception {

        Tourist t = new Tourist(101, "Manoj", "Hyd", "Gold", 5000.0);

        when(repo.save(any(Tourist.class))).thenReturn(t);

        String msg = service.registerTourist(t);

        assertEquals("Tourist is saved with the Id:101", msg);
        verify(repo).save(t);
    }
	
	
	
	@Test
	void test_FetchAllTourist() {
	
		Tourist t1 = new Tourist(103, "A", "Hyd", "Gold", 4000.0);
        Tourist t2 = new Tourist(101, "B", "Delhi", "Silver", 3000.0);
        Tourist t3 = new Tourist(102, "C", "Pune", "Bronze", 2000.0);

        when(repo.findAll()).thenReturn(Arrays.asList(t1,t2,t3));
        
        List<Tourist> list = service.fetchAllTourist();
        
        assertEquals(3, list.size());
        assertEquals(101,list.get(0).getId());
        assertEquals(102,list.get(1).getId());
        assertEquals(103,list.get(2).getId());
        
		
	}
	
	
	 //3 fetchTouristByLoc()
    @Test
    void testFetchTouristByLoc() {

        List<Tourist> expected = List.of(
                new Tourist(101, "Manoj", "Hyd", "Gold", 5000.0)
        );

        when(repo.findTouristByCities("Hyd", "Pune", "Delhi"))
                .thenReturn(expected);

        List<Tourist> result =
                service.fetchTouristByLoc("Hyd", "Pune", "Delhi");

        assertEquals(1, result.size());
        assertEquals("Manoj", result.get(0).getName());
    }
	
	
  //4 findTouristById() success
    @Test
    void testFindTouristByIdSuccess() {

        Tourist t = new Tourist(101, "Manoj", "Hyd", "Gold", 5000.0);

        when(repo.findById(101)).thenReturn(Optional.of(t));

        Tourist result = service.findTouristById(101);

        assertEquals("Manoj", result.getName());
    }

    
    
    @Test
    void findTouristById() {
    	
    	
    	Tourist t = new Tourist(101, "Manoj", "Hyd", "Gold", 5000.0);
    	
    	when(repo.findById(101)).thenReturn(Optional.of(t));
    	
    	Tourist tId = service.findTouristById(101);
    	
    	assertEquals("Manoj", tId.getName());
    }
	
    
    @Test
    void findTouristByIdFails() {
    	
    	when(repo.findById(101)).thenReturn(Optional.empty());
    	
    	assertThrows(TouristNotFoundException.class, ()->service.findTouristById(101));
    	
    	
    }

}












