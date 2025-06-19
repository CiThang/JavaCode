package Restaurant.Part_01.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Restaurant.Part_01.model.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

	@Query(value = "SELECT IFNULL(MAX(customerID), 0) FROM Receipt", nativeQuery = true)
	Integer findMaxCustomerId();

	@Query("SELECT r FROM Receipt r WHERE r.customerID = :customerID")
	Receipt findReceiptByCustomerId(@Param("customerID") Integer customerId);

	@Query("SELECT COUNT(r.id) FROM Receipt r")
	long countReceipts();

	@Query("SELECT SUM(r.total) FROM Receipt r WHERE r.Date = :Date")
	Double sumTotalByDate(@Param("Date") Date date);

	@Query("SELECT SUM(r.total) FROM Receipt r")
	Double sumTotal();

	@Query("SELECT r.Date, SUM(r.total) FROM Receipt r GROUP BY r.Date ORDER BY TIMESTAMP(r.Date)")
	List<Object[]> sumTotalByDateGroupByDateOrderByDate();

	@Query("SELECT r.Date, COUNT(r.id) FROM Receipt r GROUP BY r.Date ORDER BY TIMESTAMP(r.Date)")
	List<Object[]> countByIdGroupByDateOrderByDate();
}
