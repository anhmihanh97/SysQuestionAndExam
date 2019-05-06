package com.cmcglobal.repository;

import org.springframework.data.repository.CrudRepository;

import com.cmcglobal.entity.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String>{
	ConfirmationToken findByConfirmationToken(String confirmationToken);

}