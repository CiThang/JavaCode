package Restaurant.Part_01.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Restaurant.Part_01.model.ReceiptOrder;

@Repository
public interface ReceiptOrderRepository extends JpaRepository<ReceiptOrder, Long> {

	@Query("SELECT SUM(r.total) FROM ReceiptOrder r WHERE r.date = :date")
	Double sumTotalByDate(@Param("date") Date date); 
	
	@Query("SELECT SUM(r.total) FROM ReceiptOrder r")
	Double sumTotal();
}
