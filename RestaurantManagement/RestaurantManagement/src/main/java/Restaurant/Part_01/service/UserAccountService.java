package Restaurant.Part_01.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Restaurant.Part_01.model.Employee;
import Restaurant.Part_01.repository.UserAccountRepository;
import Restaurant.Part_01.dto.UserQuestionAnswerDTO;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Tạo tài khoản người dùng
    public Employee createUserAccount(Employee employee) {
        String hashedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(hashedPassword);
        return userAccountRepository.save(employee);
    }

    // Xác thực người dùng
    public boolean authenticate(String username, String password) {
        Employee employee = userAccountRepository.findByUsername(username);
        if (employee != null) {
        	System.out.println(password);
        	System.out.println(employee.getPassword());
            return passwordEncoder.matches(password, employee.getPassword());
        }
        return false;
    }

    // Kiểm tra câu hỏi bảo mật và câu trả lời
    public boolean checkQuestionAndAnswer(String username, String question, String answer) {
        UserQuestionAnswerDTO userQuestionAnswerDTO = userAccountRepository.findQuestionAndAnswerByUsername(username);
        if (userQuestionAnswerDTO != null) {
            return userQuestionAnswerDTO.getQuestion().equals(question)
                    && userQuestionAnswerDTO.getAnswer().equals(answer);
        }
        return false;
    }

    // Cập nhật thông tin người dùng
    public void updateData(String username, String newPassword, Date date) {
        Employee employee = userAccountRepository.findByUsername(username);
        if (employee != null) {
            // Validate new password complexity if needed
            if (newPassword.length() < 8) {
                throw new IllegalArgumentException("Mật khẩu mới phải có ít nhất 8 ký tự");
            }

            String hashedPassword = passwordEncoder.encode(newPassword);
            employee.setPassword(hashedPassword);
            employee.setDate(date);
            userAccountRepository.save(employee);
        }
    }

    // Kiểm tra sự tồn tại của tên người dùng
    public boolean checkUserName(String username) {
        return userAccountRepository.existsByUsername(username);
    }
}
