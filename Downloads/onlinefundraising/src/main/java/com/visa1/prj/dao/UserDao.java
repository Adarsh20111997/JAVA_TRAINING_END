package com.visa1.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa1.prj.entity.User;

public interface UserDao extends JpaRepository<User, String> {

}
