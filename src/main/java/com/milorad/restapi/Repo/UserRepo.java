package com.milorad.restapi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.milorad.restapi.Models.User;


public interface UserRepo extends JpaRepository< User, Long> {
}
