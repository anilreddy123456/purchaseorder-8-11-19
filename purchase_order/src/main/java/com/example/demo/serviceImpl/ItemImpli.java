package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemDao;
import com.example.demo.entity.PLineItem;
import com.example.demo.service.LineItemService;



@Service
public class ItemImpli implements LineItemService {

	@Autowired
	private ItemDao itemDao;

	public PLineItem saveItem(PLineItem item) {
		
		return itemDao.save(item);
	}

	public PLineItem udateItem(PLineItem item) {
		
		return itemDao.saveAndFlush(item);
	}

	
	


}
