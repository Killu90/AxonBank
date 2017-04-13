package Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import read.AccountQueryObject.AccountQueryObject;
import read.repository.AccountQueryObjectRepository;

@RestController
public class AccountController {

	AccountQueryObjectRepository repository;
	
	@PostMapping("/acountId")
	public AccountQueryObject findById(@PathVariable String acountId) {

		return repository.findOne(acountId);
	}
	
	@PostMapping("/all")
	public List<AccountQueryObject> findAll() {
		return repository.findAll();
	}

}
