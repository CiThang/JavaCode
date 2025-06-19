package Restaurant.Part_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Restaurant.Part_01.model.Customer;

@Repository
public interface CusomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT IFNULL(MAX(customer_ID), 0) FROM Customer", nativeQuery = true)
	Integer findMaxCustomerId();

//	Customer save(Customer customer);

	@Query("SELECT SUM(c.price) FROM Customer c WHERE c.customer_ID = :customerId")
	Double sumPriceByCustomerId(Integer customerId);

	@Query("SELECT c FROM Customer c WHERE c.customer_ID = :customer_ID")
	List<Customer> findCustomersByCustomerId(@Param("customer_ID") Integer customerId);

	@Transactional
	@Modifying
	@Query("DELETE FROM Customer p WHERE p.id = :id")
	void deleteCustomerByCustomerID(@Param("id") Integer id);

	@Query("SELECT SUM(c.quantity) FROM Customer c")
	Integer countQuantities();

}
