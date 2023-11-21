package in.theartisticescape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.theartisticescape.exception.CustomerException;

@RestController
@RequestMapping(value="/theartisticescape")
public class CustomerAPI {
//
//	@Autowired
//	private CustomerServiceImpl customerService;
//	
//	@GetMapping(value="/customers/{customerId}")
//	public ResponseEntity<List<Customer>> getCustomer(@PathVariable Integer customerId) throws CustomerException{
//		
//	}
//	
//	@PostMapping(value="/customer")
//	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException{
//		
//	}
//	
//	@PutMapping(value="/customer/{customerId}")
//	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) throws CustomerException{
//		
//	}
//	
//	@DeleteMapping(value="/customer/{customerId}")
//	public ResponseEntity<String> deleteCustomer(@PathVariable, Intger customerId) throws CustomerException{
//		
//	}
//	
	
}
