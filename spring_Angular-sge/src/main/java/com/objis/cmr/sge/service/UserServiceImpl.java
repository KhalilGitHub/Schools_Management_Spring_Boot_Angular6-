package com.objis.cmr.sge.service;



import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.objis.cmr.sge.model.User;
import com.objis.cmr.sge.repository.UserRepository;
import com.objis.cmr.sge.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) {

		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreateDate(new Date());
		
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmailIgnoreCase(email);
	}

}
