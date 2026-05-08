package com.mm.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mm.entity.Tourist;
import com.mm.service.ITouristServ;

@RestController
public class TouristControllerOperations {
	
	@Autowired
	private ITouristServ serv;
	
	@Value("${file.upload-dir}") 	
	private String uploadDir;

	
	
	//Register The Tourist
	@PostMapping("/register")
	public ResponseEntity<String>  enrollTourist(@RequestBody Tourist tourist)throws Exception {			
		
		

// 		  Need not to write try catch block for every method global exception handling is 
//		  there that's why i have removed try catch block here 	( check by throwing exception in service b.method)													
		
			String msg = serv.registerTourist(tourist);
			
			
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
		
	
		
	}
	
	
	
	//FinAll Tourists
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourist(){
		
		try {
			System.out.println("FindAll ThreadName:"+Thread.currentThread().getName());
			List<Tourist> list = serv.fetchAllTourist();
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Problem Occured While Fetching Tourist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	//Find Tourists By Location
	@GetMapping("/findAll/{city1}/{city2}/{city3}")
	public ResponseEntity<?> displayTouristByCities(@PathVariable String city1,
													@PathVariable String city2,
													@PathVariable(required = false) String city3){
		try {
			List<Tourist> list = serv.fetchTouristByLoc(city1, city2, city3);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			
			
			return new ResponseEntity<>("Problem Occured While Fetching Through City Names",
										HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
	}
	
	
	
	//Find Tourist By Id
	@GetMapping("/findTouriest/{tid}")
	public ResponseEntity<?> getTheTouristById(@PathVariable(name = "tid") Integer id) {
		
		
		if(id<=0) {
			
				return new ResponseEntity<>("Exception Occured Manually!!!!!",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		try {
			System.out.println("FindById ThreadName:"+Thread.currentThread().getName());
			Tourist obj = serv.findTouristById(id);
			
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}
		catch(Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	
	
	@PutMapping("/modify")
	public ResponseEntity<?>  modifyTheTouristDetails(@RequestBody Tourist tourist){
		
		try {
			Tourist obj = serv.updateTouristDetails(tourist);
			
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}
		catch(Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	
	
	
	@GetMapping("/find/{name}")
	public ResponseEntity<?> showTouristsByName(@PathVariable String name){
		
		List<Tourist> list = serv.gettingTouristInfoByName(name);
		
		try {
			if(!list.isEmpty()) {
				
				return new ResponseEntity<>(list,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("No Tourist Found with That name:"+name,HttpStatus.OK);
			}
		}
		catch(Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	@PatchMapping("/budget/{per}/{id}")
	public ResponseEntity<?> modifyingTouristBudget(@PathVariable double per,
													@PathVariable int id){
		
		 String msg = serv.updateTheTouristBudget(per, id);
		
		
		try {
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Failed to Update",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTouristById(@PathVariable int id){
		
		try {
			String msg = serv.deleteById(id);
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	@DeleteMapping("/delete/{start}/{end}")
	public ResponseEntity<?> deleteTouristBasedOnBudgetRange(@PathVariable double start,
															@PathVariable double end){
		
		try {
			
			String msg = serv.deleteTouristsByBudgetRange(start, end);
			
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	@PostMapping("/upload")
    public String uploadImage(
            @RequestParam("image") MultipartFile file)
            throws IOException {

		String filename = file.getOriginalFilename();
		Path path = Paths.get(uploadDir, filename);
		
		Files.createDirectory(path.getParent());
		
		Files.write(path, file.getBytes());
		
     
        return "Image Uploaded Successfully";
    }


    @GetMapping("/images/{fileName}")
    public ResponseEntity<byte[]> getImage(
            @PathVariable String fileName)
            throws IOException {
    	
    	Path path = Paths.get(uploadDir, fileName);
    	
    	byte[] image = Files.readAllBytes(path);
    	
        return ResponseEntity
        		.ok()
        		.contentType(MediaType.IMAGE_JPEG)
        		.body(image);
        
    }

}

















































