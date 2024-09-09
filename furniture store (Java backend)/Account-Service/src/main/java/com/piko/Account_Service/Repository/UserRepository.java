package com.piko.Account_Service.Repository;

import com.piko.Account_Service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByusername(String username);

    User findByemail(String email);

    User findByEmailAndUsername(String email, String username);
}
