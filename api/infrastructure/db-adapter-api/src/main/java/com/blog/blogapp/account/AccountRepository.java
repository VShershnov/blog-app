package com.blog.blogapp.account;

import com.blog.blogapp.account.entity.AccountJdbc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountJdbc, Long> {

    Optional<AccountJdbc> findOneByEmailIgnoreCase(String email);
}
