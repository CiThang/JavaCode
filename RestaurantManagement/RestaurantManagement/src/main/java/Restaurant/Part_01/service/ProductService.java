package Restaurant.Part_01.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.model.Product;
import Restaurant.Part_01.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public boolean isProductidExists(String productID) {
		return productRepository.existsByProductID(productID);
	}

	public void addProduct(Product prod) {
		productRepository.save(prod);
	}

	public void updateProduct(String productID, String productName, String type, int stock, double price, String status,
			String image, Date date) {
		productRepository.updateProduct(productID, productName, type, stock, price, status, image, date);
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public void deleteProductByProductID(String productID) {
		productRepository.deleteProductByProductID(productID);
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public String getStatus(String productID) {
		return productRepository.findStatusByProductID(productID);
	}

	public Integer getStock(String productID) {
		return productRepository.findStockByProdcutID(productID);
	}

	public void updateProductByProductName(String productName, String type, int stock, double price,
			String status, String image, Date date) {
		productRepository.updateProductByProductName(productName, type, stock, price, status, image, date);
	}
}
