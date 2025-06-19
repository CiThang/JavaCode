package Restaurant.Part_01.repository;

import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Restaurant.Part_01.model.CustomerAccount;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
		
//	  Optional<CustomerAccount> findByCusName(String cusname);
	
	  Optional<CustomerAccount> findByEmail(String email);
	
	  boolean existsByCusname(String Cusname) ;
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CustomerAccount p WHERE p.cusname = :cusname")
	void deleteCustomerAccountByCusname(@Param("cusname") String cusname);
	
	@Transactional
	@Modifying
    @Query("UPDATE CustomerAccount c SET c.cusname = :cusname, c.password = :password, c.secretkey = :secretkey WHERE c.email = :email")
    void updateCustomerAccount(
        @Param("cusname") String cusname,
        @Param("email") String email,
        @Param("password") String password,
        @Param("secretkey") SecretKey secretkey
    );
	
}
