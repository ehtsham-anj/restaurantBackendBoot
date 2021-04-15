package com.boot.project.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.project.model.Reserve;
import com.boot.project.model.User;

public interface ReserveRepository extends JpaRepository <Reserve, Long>  {

	 Optional<Reserve> findByEmail(String email);

	Reserve findByFirstname(String firstname);

//	void deleteUserByEmail(String email);
	public Iterable<Reserve> deleteByEmail(String email);

}
