package Restaurant.Part_01.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.model.Employee;
import Restaurant.Part_01.repository.UserAccountRepository;
import Restaurant.Part_01.dto.UserQuestionAnswerDTO;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	// Tao tai khoan nguoi dung
	public Employee createUserAccount(Employee employee) {
		return userAccountRepository.save(employee);
	}

	// Dang nhap
	public boolean authenticate(String username, String password) {
		return userAccountRepository.findByUsernameAndPassword(username, password) != null ;
	}

	public boolean checkQuestionAndAnswer(String username, String question, String answer) {
		UserQuestionAnswerDTO userQuestionAnswerDTO = userAccountRepository.findQuestionAndAnswerByUsername(username);
        if (userQuestionAnswerDTO != null) {
            return userQuestionAnswerDTO.getQuestion().equals(question) && userQuestionAnswerDTO.getAnswer().equals(answer);
        }
        return false;
    }

	public void updatedata(String username, String newpass, Date date) {
		Employee employee = userAccountRepository.findByUsername(username);
		employee.setPassword(newpass);
		employee.setDate(date);
		userAccountRepository.save(employee);
	}
	public boolean checkUserName(String username) {
		return userAccountRepository.existsByUsername(username);
	}

}
