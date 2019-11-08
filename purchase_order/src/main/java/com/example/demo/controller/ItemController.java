package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ItemDao;
import com.example.demo.entity.PHeader;
import com.example.demo.entity.PLineItem;
import com.example.demo.service.LineItemService;





@RestController
//@RequestMapping("/item")
public class ItemController {

	@Autowired
	private LineItemService itemService;
	
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping(value="/itemall", method=RequestMethod.GET,consumes="application/json")
		//@RequestMapping("/itemall")
		public List<PLineItem> getAll() {
			
			List<PLineItem> list= itemDao.findAll();
			System.out.println(list.size());
			return list;
		}
		
	@RequestMapping(value="/itemsave", method=RequestMethod.POST,produces = "application/json")
	public PLineItem createItem(@Valid @RequestBody PLineItem item) {
		return itemService.saveItem(item);
		
	}
	
	@RequestMapping(value="/itemupdate", method=RequestMethod.PUT,produces = "application/json")
	public PLineItem udate(@Valid @RequestBody PLineItem item) {
		return itemService.udateItem(item);
		
	}
}
