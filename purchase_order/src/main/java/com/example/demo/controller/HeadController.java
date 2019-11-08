package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PHeadDao;
import com.example.demo.entity.PHeader;
import com.example.demo.service.HeaderService;

import javassist.NotFoundException;

@RestController
//@RequestMapping("/api")
public class HeadController {

	@Autowired
	private HeaderService headerService;

	@Autowired
	private PHeadDao dao;

	@GetMapping("/all")
	public List<PHeader> getAllPHeaders() {
		return dao.findAll();
	}

	@GetMapping("/pHeaders/{id}")
	public PHeader getPHeaderByID(@PathVariable Long id) throws NotFoundException {
		Optional<PHeader> optPHeader = dao.findById(id);
		if (optPHeader.isPresent()) {
			return optPHeader.get();
		} else {
			throw new NotFoundException("PHeader not found with id " + id);
		}
	}
	/*
	 * @PostMapping("/pHeaders") public PHeader createPHeader(@Valid @RequestBody
	 * PHeader pHeader) { dao.save(pHeader); System.out.println(pHeader.toString());
	 * return "no of records updated:" +pHeader. }
	 */

	/*
	 * @RequestMapping(value = "/pHeaders", method = RequestMethod.POST, produces =
	 * "application/json")
	 * 
	 * @Transactional
	 */
	@PostMapping("/pHeaders")
	public String createHead(@RequestBody List<PHeader> head) {
		System.out.println(head.toString());
		/*
		 * for (PHeader pHeader : head) { dao.saveAndFlush(pHeader); }
		 */
		dao.saveAll(head);
		System.out.println(head.toString());
		System.out.println(head.size());
		return "number of records created in header : " + head.size();
	}
	/*
	 * @PutMapping("/pHeaders/{id}") public PHeader updatePHeader(@PathVariable Long
	 * id,
	 * 
	 * @Valid @RequestBody PHeader pHeaderUpdated) { return dao.findById(id)
	 * .map(pHeader -> { pHeader.setName(pHeaderUpdated.getName());
	 * pHeader.setAge([pHeaderUpdated.getAge());
	 * 
	 * return dao.save(pHeader); }).orElseThrow(() -> new
	 * NotFoundException("PHeader not found with id " + id)); }
	 */

	@DeleteMapping("/pHeaders/{id}")
	public String deletePHeader(@PathVariable Long id) throws NotFoundException {
		return dao.findById(id).map(pHeader -> {
			dao.delete(pHeader);
			return "Delete Successfully!";
		}).orElseThrow(() -> new NotFoundException("PHeader not found with id " + id));
	}

	/*
	 * //@GetMapping(value="/all") //@RequestMapping(value="/all",
	 * method=RequestMethod.GET,consumes="application/json")
	 * 
	 * @RequestMapping("/all") public List<PHeader> getAll() {
	 * 
	 * List<PHeader> list= dao.findAll(); System.out.println(list.size()); return
	 * list; } //@PostMapping("/save")
	 * 
	 * @RequestMapping(value="/save", method=RequestMethod.POST, produces =
	 * "application/json")
	 * 
	 * @Transactional public String createHead(@Valid @RequestBody List<PHeader>
	 * head) { System.out.println( head.toString()); for (PHeader pHeader : head) {
	 * dao.saveAndFlush(pHeader); }
	 * 
	 * System.out.println( head.toString()); System.out.println( head.size());
	 * return "number of records created in header : " + head.size();
	 * 
	 * 
	 * }
	 * 
	 * //@PutMapping("/update")
	 * 
	 * @RequestMapping(value="/update", method=RequestMethod.PUT ,produces =
	 * "application/json") public PHeader update(@RequestBody PHeader head) { return
	 * dao.saveAndFlush(head); }
	 */
	/*
	 * @PutMapping("/employees/{id}") public ResponseEntity<Employee>
	 * updateEmployee(@PathVariable(value = "id") Long employeeId,
	 * 
	 * @Valid @RequestBody Employee employeeDetails) throws
	 * ResourceNotFoundException { Employee employee =
	 * employeeRepository.findById(employeeId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +
	 * employeeId));
	 * 
	 * employee.setEmailId(employeeDetails.getEmailId());
	 * employee.setLastName(employeeDetails.getLastName());
	 * employee.setFirstName(employeeDetails.getFirstName()); final Employee
	 * updatedEmployee = employeeRepository.save(employee); return
	 * ResponseEntity.ok(updatedEmployee); }
	 */

	/*
	 * public PHeader create(PHeader head) { return headerService.saveHeader(head);
	 * 
	 * }
	 * 
	 * @GetMapping("/all")
	 * 
	 * public List<PHeader> getAllPOs() { return headerService.getHeader(); }
	 * 
	 * 
	 * public PHeader update(PHeader head) { return
	 * headerService.updateHeader(head);
	 * 
	 * }
	 */

}