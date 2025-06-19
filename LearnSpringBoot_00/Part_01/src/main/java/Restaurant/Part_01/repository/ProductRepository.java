package Restaurant.Part_01.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Restaurant.Part_01.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	// Kiem tra su ton tai cua ID Product
	boolean existsByProductID(String productID);

	void deleteByproductID(String productID);

	@Transactional
	@Modifying
	@Query("UPDATE Product p SET p.productName = :productName, p.type = :type, p.stock = :stock, p.price = :price, p.status = :status, p.image = :image, p.date = :date WHERE p.productID = :productID")
	void updateProduct(@Param("productID") String productID, @Param("productName") String productName,
			@Param("type") String type, @Param("stock") int stock, @Param("price") double price,
			@Param("status") String status, @Param("image") String image, @Param("date") Date date);

	@Transactional
	@Modifying
	@Query("DELETE FROM Product p WHERE p.productID = :productID")
	void deleteProductByProductID(@Param("productID") String productID);

	@Query("SELECT new Product(p.productID, p.productName, p.price, p.image, p.date) FROM Product p")
	List<Product> findAllWithSelectedColumns();

	@Query("SELECT p.status FROM Product p WHERE p.productID = :productID")
	String findStatusByProductID(@Param("productID") String productID);

	@Query("SELECT p.stock FROM Product p WHERE p.productID = :productID")
	Integer findStockByProdcutID(@Param("productID") String productID);
	
	@Transactional
	@Modifying
	@Query("UPDATE Product p SET p.type = :type, p.stock = :stock, p.price = :price, p.status = :status, p.image = :image, p.date = :date WHERE p.productName = :productName")
	void updateProductByProductName( @Param("productName") String productName,
			@Param("type") String type, @Param("stock") int stock, @Param("price") double price,
			@Param("status") String status, @Param("image") String image, @Param("date") Date date);
	
}
