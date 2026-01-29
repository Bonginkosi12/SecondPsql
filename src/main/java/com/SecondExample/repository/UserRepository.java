// Communicates with the database
// allows you to query the database
//Uses JPA interface

package com.SecondExample.repository;

import com.SecondExample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //query to get user by name
    User findByName(String name);

    //query to get user by name
    List<User> findByRole(String role);

   //query to get user by email and mobile numbers(using request params)
    User findByEmailAndMobileNumbers(String email, String mobileNumbers);
}
