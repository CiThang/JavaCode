package Restaurant.Part_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.model.CustomerAccount;
import Restaurant.Part_01.repository.CustomerAccountRepository;

@Service
public class CustomerAccountService {

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	public List<CustomerAccount> listCustomerAccounts() {
		return customerAccountRepository.findAll();
	}

	public CustomerAccount createCustomerAccount(CustomerAccount customerAccount) {
		return customerAccountRepository.save(customerAccount);
	}

	public boolean cusNameExists(String cusName) {
		return customerAccountRepository.existsByCusname(cusName);
	}

	public boolean emailExists(String email) { // New method to check if email exists
		Optional<CustomerAccount> customerAccount = customerAccountRepository.findByEmail(email);
		return customerAccount.isPresent();
	}

	public void deleteCustomerAccountByCusName(String cusName) {
		customerAccountRepository.deleteCustomerAccountByCusname(cusName);
	}

}
