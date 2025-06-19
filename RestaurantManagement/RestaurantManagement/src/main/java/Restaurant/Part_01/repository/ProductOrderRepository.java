package Restaurant.Part_01.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Restaurant.Part_01.model.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

	@Query("SELECT SUM(c.quanlity) FROM ProductOrder c")
	Integer countQuantities();
	
	
	@Query("SELECT c FROM ProductOrder c WHERE c.customerName = :customerName AND c.date = :date")
	List<ProductOrder> findProductOrderByCustomerNameAndDate(@Param("customerName") String customerName, @Param("date") Date date);


}
