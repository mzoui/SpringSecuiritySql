package mah.auth.ex;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mah.auth.ex.models.Roles;
import mah.auth.ex.models.Users;
import mah.auth.ex.repos.UserRepo;

@SpringBootApplication
public class SpringAuthenticationExempleApplication  implements CommandLineRunner {
	 @Autowired
	 private UserRepo userRepo;
	
	 public static void main(String[] args) {
		SpringApplication.run(SpringAuthenticationExempleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Roles role1 = new Roles("admin");
		Roles role2 = new Roles("user");
		Roles role3 = new Roles("admin_net");
		Set<Roles> roles = new HashSet<Roles>();
		roles.add(role1);
		roles.add(role2);
		roles.add(role3);
		Users user = new Users("mimo","toto","mimi@toto.com","1111",1 ,roles);
		userRepo.save(user);
		*/
		
	}
}
