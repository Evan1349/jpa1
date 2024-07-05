package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SpringJpa1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpa1Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            // 檢查用戶是否存在，如果不存在則創建新的用戶
            if (userRepository.findByEmail("john.doe@example.com").isEmpty()) {
                User user1 = new User(null, "John Doe", "john.doe@example.com");
                userRepository.save(user1);
            }

            if (userRepository.findByEmail("jane.doe@example.com").isEmpty()) {
                User user2 = new User(null, "Jane Doe", "jane.doe@example.com");
                userRepository.save(user2);
            }

            // 查詢並打印所有用戶
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
