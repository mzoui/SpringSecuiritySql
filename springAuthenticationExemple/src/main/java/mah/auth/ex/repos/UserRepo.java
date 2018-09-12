package mah.auth.ex.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mah.auth.ex.models.Users;

public interface UserRepo extends JpaRepository <Users , Integer>{

	 Optional  <Users> findByName(String user_name);

}
