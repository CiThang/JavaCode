package Restaurant.Part_01.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.model.Customer;
import Restaurant.Part_01.repository.CusomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CusomerRepository cusomerRepository;

//	public void addCustomer()
	public Integer findMaxCusomerId() {
		return cusomerRepository.findMaxCustomerId();
	}

	public Customer createCustomer(Integer cID, String productID, String productName, String type, Integer quantity,
			Double price, Date date, String img, String em_username) {
		Customer customer = new Customer(cID, productID, productName, type, quantity, price, date, img, em_username);
		return cusomerRepository.save(customer);
	}

	public List<Customer> listCustomer() {
		return cusomerRepository.findAll();
	}

	public Double sumPriceByCustomerId(Integer customerId) {
		return cusomerRepository.sumPriceByCustomerId(customerId);
	}

	public List<Customer> getCustomersByCustomerId(Integer customerId) {
		return cusomerRepository.findCustomersByCustomerId(customerId);
	}
	
	public void deleteCusomerByProdId(Integer id) {
		cusomerRepository.deleteCustomerByCustomerID(id);
	}
	
    public Integer getQuantityCount() {
        return cusomerRepository.countQuantities();
    }

}
