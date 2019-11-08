package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PHeader;


@Repository
public interface PHeadDao extends JpaRepository<PHeader, Long>

{
	
}
	

