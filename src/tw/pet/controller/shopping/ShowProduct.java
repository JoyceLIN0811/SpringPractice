package tw.pet.controller.shopping;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.pet.dao.ProductDao;
import tw.pet.model.shopping.ProductBean;

@Controller
public class ShowProduct {
	@Autowired
	SessionFactory session;
	@Autowired
	ProductDao dao;
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/test")
	public ProductBean single(@RequestParam(value="id")int productId) {
		ProductBean selectOne = dao.selectOne(productId);	
		return selectOne;
	}
	

	// 本方法於新增時，送出空白的表單讓使用者輸入資料
	@GetMapping(value = "/insertProduct")
	public String showEmptyForm(Model model) {
		//一定要給一個空的bean
		ProductBean productBean=new ProductBean();
		
		model.addAttribute("productBean",productBean);
		return"insertProduct";
	}
	
	
	
	//新增商品
	public String addProduct(
			@ModelAttribute("productBean") 
			ProductBean productBean,
			BindingResult result,
			Model model
			) {
		MultipartFile productImage = productBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
			productBean.setFileName(originalFilename);
		}
		// 建立Blob物件，交由 Hibernate 寫入資料庫
		if (productImage != null && !productImage.isEmpty()) {
			try {
				byte[] b = productImage.getBytes();
				Blob blob = new SerialBlob(b);
				productBean.setCoverImage(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		
		//新增放入商品的時間
		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
		productBean.setAdmissionTime(adminTime);
		
		try {
			dao.insert(productBean);
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			result.rejectValue("account", "", "商品已存在，請重新輸入");
			return "crm/insertMember";
		} catch (Exception ex) {
			System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
			result.rejectValue("account", "", "請通知系統人員...");
			return "回到新增商品的頁面";
		}
		
		
		return "查看您新增的商品";
	}
	
}
