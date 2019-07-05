package com.objis.cmr.sge.service;

import java.util.List;

import com.objis.cmr.sge.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);
	

}
