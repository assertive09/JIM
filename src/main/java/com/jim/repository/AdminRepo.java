package com.jim.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jim.model.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer> {
   
    @Query("select a from Admin a where a.email = :e and a.password= :p")
    public Admin getAdminByNameandPassword(@Param ("e") String email, @Param ("p") String password);
    

}