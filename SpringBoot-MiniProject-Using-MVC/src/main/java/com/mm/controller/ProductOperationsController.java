package com.mm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mm.service.IProductMgmtService;
import com.mm.vo.ProductVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductOperationsController {
	
	@Autowired
	private IProductMgmtService serv;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	
	@GetMapping("/report")
	public String showReport(HttpServletRequest req,Map<String,Object> map) {
		
//		System.out.println(req.getServletPath());
		
		List<ProductVO> prods = serv.getTheProducts();
		
		map.put("products", prods);
		
		return "show_report";
	}
	
	
	
	@GetMapping("/register")
	public String showRegisterProductForm(@ModelAttribute("prodVO")ProductVO vo) {
		
		System.out.println("ProductOperationsController.registerProduct()");
		
		//LVN
		return "register_product_form";
		
	}
	
	
	@PostMapping("/register")
	public String registerProduct(@ModelAttribute("prodVO)")ProductVO vo,
									RedirectAttributes attrs) {
		
		System.out.println("ProductOperationsController.registerProduct()");
		
		String msg = serv.registerProduct(vo);

		//keeps the results in flash model attribute
		
		attrs.addFlashAttribute("resultMsg", msg);
		
		return "redirect:report";
	}
	
	
	@GetMapping("/edit")
	public String showEditProduct(@RequestParam int pno,
							  @ModelAttribute("pvo") ProductVO pVO) {
		
		ProductVO pv = serv.showProductById(pno);
		
		BeanUtils.copyProperties(pv, pVO);
		
		return "edit_product_form";
	}
	
	
	@PostMapping("/edit")
	public String editProductDetails(@ModelAttribute("pvo")ProductVO pVO,
									 RedirectAttributes attr) {
		
		String msg = serv.editTheProduct(pVO);
		
		attr.addFlashAttribute("resultMsg", msg);
		
		
		return "redirect:report";
	}
	
	
	@GetMapping("/delete")
	public String deleteTheProduct(@RequestParam int pno,
									RedirectAttributes attr) throws Exception {
		
		String msg = serv.deleteTheProductById(pno);
		attr.addFlashAttribute("resultMsg", msg);
		
		return "redirect:report";
	}
	
}




















