package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PHeadDao;
import com.example.demo.entity.PHeader;
import com.example.demo.service.HeaderService;

@Service
public class HeaderImpl implements HeaderService {

	@Autowired
	private PHeadDao headDao;

	public PHeader saveHeader(PHeader head) {

		return headDao.save(head);
	}

	public PHeader updateHeader(PHeader head) {

		return headDao.saveAndFlush(head);
	}

	@Override
	public List<PHeader> getHeader() {
		
		return headDao.findAll();
	}

}
