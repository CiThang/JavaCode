package LearnSpringBoot_03.example.part_03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import Service.UserService;

import entity.User;

@SpringBootApplication
@EnableMongoRepositories("Service")
public class Part03Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Part03Application.class, args);

        UserService userService = context.getBean(UserService.class);

        // Thêm một số dữ liệu mẫu
        User user1 = new User();
        user1.setUsername("user1");
        user1.setEmail("user1@example.com");

        User user2 = new User();
        user2.setUsername("user2");
        user2.setEmail("user2@example.com");

        // Lưu dữ liệu vào cơ sở dữ liệu
        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
