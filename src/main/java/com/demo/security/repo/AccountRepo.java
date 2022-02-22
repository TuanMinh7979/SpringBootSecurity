package com.demo.security.repo;

import com.demo.security.models.Account;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account, Integer> {
   @Query("from Account where userName= :username")
    Account findAccountByUserName(@Param("username")String username);


}
