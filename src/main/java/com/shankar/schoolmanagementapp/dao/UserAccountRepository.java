package com.shankar.schoolmanagementapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.entities.UserAccount;

public interface UserAccountRepository  extends CrudRepository<UserAccount,Long>  {
    
}
