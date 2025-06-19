package Restaurant.Part_01.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.model.ProductOrder;
import Restaurant.Part_01.repository.ProductOrderRepository;

@Service
public class ProductOrderService {

	@Autowired
	private ProductOrderRepository productOrderRepository;

	public Integer getQuantityCount() {
		return productOrderRepository.countQuantities();
	}
	
	public List<ProductOrder> getProductOrdersByCustomerName(String customerName,Date date){
		return productOrderRepository.findProductOrderByCustomerNameAndDate(customerName,date);
	}
}
