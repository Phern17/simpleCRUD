package com.pooihern.simpleCRUD.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public CustomerController() {
		
	}
	
	public CustomerController(CustomerRepo userRepo) {
		this.customerRepo = userRepo;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getalldetails/{pageNumber}")
	public List<CustomerEntity> retrieveAllUsers(@PathVariable int pageNumber) {
		int max = (int) customerRepo.count();
		return (List<CustomerEntity>) customerRepo.findAll(PageRequest.of(pageNumber, max));
	}
	
	@GetMapping("/getdetailById/{id}")
	public CustomerEntity findUser(@PathVariable long id) throws Exception {
		Optional<CustomerEntity> customer = customerRepo.findById(id);
		
		if (customer.isEmpty())
			throw new Exception("User with id: " + id + " not found!");
		
		return customer.get();
	}
	
	@PostMapping("/create")
	public CustomerEntity createUser(@RequestBody CustomerEntity customer) {
		customerRepo.save(customer);
		return customer;
	}
	
	
	@PatchMapping("/update")
	public void updateUser(@RequestBody CustomerEntity customer) {
		long id = customer.getId();
		
		Optional<CustomerEntity> customerResult = customerRepo.findById(id);
		
		if (!customerResult.isEmpty()) {
			customerRepo.save(customer);
		}
	}
	
	@DeleteMapping("/delete")
	public void deleteUser(@RequestBody CustomerEntity customer) {
		long id = customer.getId();
		
		Optional<CustomerEntity> customerResult = customerRepo.findById(id);
		
		if (!customerResult.isEmpty()) {
			customerRepo.deleteById(id);
		}
	}
}
