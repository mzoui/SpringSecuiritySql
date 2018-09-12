package mah.auth.ex.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class AutentifiactionController {
	
	@GetMapping("/all")
	public String Hello() {
		return "hello All";
	}
	
	
	@GetMapping("/secuired/all")
	@PreAuthorize("hasAnyRole('admin','user')")
	public String secuirHello() {
		return "secuired";
	}
	
	@GetMapping("/secuired/all/user")
	@PreAuthorize("hasAnyRole()")
	public String secuirSEcuiredNestlevel() {
		return "user secuired";
	}
}
