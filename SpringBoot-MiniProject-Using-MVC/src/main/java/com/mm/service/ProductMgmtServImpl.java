package com.mm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mm.controller.ProductOperationsController;
import com.mm.entity.ProductEntity;
import com.mm.repo.IProductRepository;
import com.mm.vo.ProductVO;
import com.mm.errors.*;
@Service
public class ProductMgmtServImpl implements IProductMgmtService{

    

	@Autowired
	private IProductRepository pRepo;

    
	//1
	@Override
	public String registerProduct(ProductVO vo) {
		
		ProductEntity entity = new ProductEntity();
		
		BeanUtils.copyProperties(vo, entity);
		
		entity.setCreatedBy(System.getProperty("user.name"));
		
		int pId = pRepo.save(entity).getPid();
		
		return "Product is Registered With idValue:"+pId;
	}
	
	
	//2
	@Override
	public List<ProductVO> getTheProducts() {
			
		List<ProductEntity> prodEntity = pRepo.findAll();
		
		
		
		
		
		ArrayList<ProductVO> voEntity = new ArrayList<>();
		
		prodEntity.forEach(prod->{
			ProductVO pVO = new ProductVO();
			
			BeanUtils.copyProperties(prod, pVO);
			
			voEntity.add(pVO);
		});

				
		
		return voEntity;
	}

	//3
	@Override
	public ProductVO showProductById(int pno) {
		
		ProductEntity pe = pRepo.findById(pno).orElseThrow(()->new ProductNotFoundException("invalid id"));							
		
		ProductVO pv = new ProductVO();
		
		BeanUtils.copyProperties(pe, pv);
		
		return pv;
	}

	//4
	@Override
	public String editTheProduct(ProductVO pVO) {
		
		ProductEntity pE = pRepo.findById(pVO.getPid()).orElseThrow(()->new IllegalArgumentException("invalid id"));
		
		BeanUtils.copyProperties(pVO, pE);
		pE.setUpdatedBy(System.getProperty("user.name"));
		
		ProductEntity save = pRepo.save(pE);
		
		return save.getPid()+":Id ProductDetails are updated!";
	}

	
	//5
	@Override
	public String deleteTheProductById(int pno)throws Exception  {
		
		
		Optional<ProductEntity> byId = pRepo.findById(pno);
		
		if(byId.isPresent()) {
			
			pRepo.deleteById(pno);
		}
		else {
			throw new IllegalArgumentException("Doctor Not Found!");
		}
		
		
		
		
		
		return pno+":id Product Deleted!";
	}
	
	

}

































