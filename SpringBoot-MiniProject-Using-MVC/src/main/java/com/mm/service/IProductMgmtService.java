package com.mm.service;

import java.util.List;

import com.mm.errors.ProductNotFoundException;
import com.mm.vo.ProductVO;

public interface IProductMgmtService {
	
	public String registerProduct(ProductVO vo);
	
	public List<ProductVO> getTheProducts();
	
	public ProductVO showProductById(int pno);
	
	public String editTheProduct(ProductVO pVO);
	
	public String deleteTheProductById(int pno) throws Exception;
}
