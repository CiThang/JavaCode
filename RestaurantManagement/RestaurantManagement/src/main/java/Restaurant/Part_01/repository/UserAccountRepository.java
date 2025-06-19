package Restaurant.Part_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Restaurant.Part_01.dto.UserQuestionAnswerDTO;
import Restaurant.Part_01.model.Employee;

@Repository
public interface UserAccountRepository extends JpaRepository<Employee, Integer> {

	// Phuong thuc truy van tuy chinh neu can
//	@Query("SELECT u FROM User u WHERE u.username = :username")
//    Optional<employee> findByUsername(@Param("username") String username);

	Employee findByUsernameAndPassword(String username, String password);

	@Query("SELECT new Restaurant.Part_01.dto.UserQuestionAnswerDTO(e.question, e.answer) FROM Employee e WHERE e.username = :username")
	UserQuestionAnswerDTO findQuestionAndAnswerByUsername(@Param("username") String username);
	
	Employee findByUsername(String username);
	
	boolean existsByUsername(String username) ;
}
