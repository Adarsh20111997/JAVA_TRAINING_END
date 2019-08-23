package com.visa1.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa1.prj.entity.Donation;

public interface DonationDao extends JpaRepository<Donation, Integer> {

}
