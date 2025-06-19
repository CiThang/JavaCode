package Restaurant.Part_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Restaurant.Part_01.model.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

	@Query("SELECT SUM(c.quanlity) FROM ProductOrder c")
	Integer countQuantities();
}
