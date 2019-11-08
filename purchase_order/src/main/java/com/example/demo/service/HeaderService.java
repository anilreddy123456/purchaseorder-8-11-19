package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PHeader;


public interface HeaderService {

	public PHeader saveHeader(PHeader head);
	 
	public PHeader updateHeader(PHeader head);
	
	public List<PHeader> getHeader();
	
}
