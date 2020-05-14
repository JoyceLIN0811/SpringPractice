package tw.pet.dao;

import java.util.List;

import org.hibernate.Session;

import tw.pet.model.shopping.OrderBean;
import tw.pet.model.shopping.ProductBean;

public interface ProductDao {

	Session getSession();

	ProductBean selectOne(int ProductId);

	List<ProductBean> selectAll();

	List<ProductBean> selectCategory(int categoryId);

	//用銷售金額去選擇
	List<ProductBean> selectSales();

	//用名稱去選擇
	List<ProductBean> selectName(String name);

	//用價格去選  從高到低
	List<ProductBean> selectPriceUp();

	//用價格去選  從低到高
	List<ProductBean> selectPriceDown();

	//取得總商品數目
	long getRecordCounts();

	String insert(ProductBean productBean);
	
	 List<ProductBean> getAllProductsJson() ;

}