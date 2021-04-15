package com.boot.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.project.model.Reserve;
import com.boot.project.model.User;
import com.boot.project.repository.ReserveRepository;




@Service
@Transactional
public class ReserveService {
	
	@Autowired
	private final ReserveRepository reserveRepository;
	
	public ReserveService(ReserveRepository reserveRepository) {
		this.reserveRepository=reserveRepository;
	}

	public void saveReservation(Reserve reserve ) {
		reserveRepository.save(reserve);
	}
	public Iterable<Reserve> showAllReservations(){
		return reserveRepository.findAll();
	}

	public Iterable<Reserve> deleteUserByEmail(String email) {
		reserveRepository.deleteByEmail(email);
		return reserveRepository.findAll();
	}

	  public Reserve updateReserve(final Reserve reserve){
	        return reserveRepository.save(reserve);
	    }
	  public Reserve findByEmail(final String email){
	        return reserveRepository.findByEmail(email).orElse(null);
	    }
	   public void deleteReserve(final Long reserveId){
	        reserveRepository.deleteById(reserveId);
	    }
	}

