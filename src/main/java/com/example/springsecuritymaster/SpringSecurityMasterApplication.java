package com.example.springsecuritymaster;

import com.example.springsecuritymaster.dao.CustomerDao;
import com.example.springsecuritymaster.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SpringSecurityMasterApplication {

    @Autowired
    private CustomerDao customerDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityMasterApplication.class, args);
    }

    @Bean @Transactional @Profile("dev")
    public ApplicationRunner runner() {
        return runner -> {
            Customer c1 = new Customer("JD", "John", "Doe", "Saint Mountain Belly Bridge");
            Customer c2 = new Customer("JW", "John", "william", "Dream land");
            Customer c3 = new Customer("TH", "Thomas", "Hardy", "Belly Bridge");
            Customer c4 = new Customer("RC", "Richard", "Chan", "Saint Gorge");
            Customer c5 = new Customer("AC", "Army", "Chan", "University Avenue");

            customerDao.save(c1);
            customerDao.save(c2);
            customerDao.save(c3);
            customerDao.save(c4);
            customerDao.save(c5);

        };
    }
}
