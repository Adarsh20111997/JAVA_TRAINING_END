package com.visa1.prj.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa1.prj.entity.Campaign;
import com.visa1.prj.service.DonationService;

@RestController
public class CampaignController {
	@Autowired
	private DonationService ds;
	
	@GetMapping("campaigns")
	public List<Campaign> getCampaign(){
		return ds.getCampaigns();
	}
	
	@PostMapping("campaigns")
	public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign c){
		ds.saveCampaign(c);
		return new ResponseEntity<>(c,HttpStatus.CREATED);
	}
}
