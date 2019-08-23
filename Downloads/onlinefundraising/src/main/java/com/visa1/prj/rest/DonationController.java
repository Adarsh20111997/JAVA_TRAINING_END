package com.visa1.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa1.prj.entity.Donation;
import com.visa1.prj.service.DonationService;

@RestController
public class DonationController {
	@Autowired
	private DonationService ds;
	
	@GetMapping("donations")
	public @ResponseBody List<Donation> getDonations(){
		return ds.getDonations();
	}
	
	@PostMapping("donations")
	public ResponseEntity<Donation> donate(@RequestBody Donation d){
		ds.donate(d);
		return new ResponseEntity<>(d,HttpStatus.CREATED);
	}
}
