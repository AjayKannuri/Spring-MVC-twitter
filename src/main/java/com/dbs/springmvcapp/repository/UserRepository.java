package com.dbs.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.springmvcapp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
