package Restaurant.Part_01.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.repository.ProductOrderRepository;

@Service
public class ProductOrderService {

	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	  public Integer getQuantityCount() {
	        return productOrderRepository.countQuantities();
	    }
}
