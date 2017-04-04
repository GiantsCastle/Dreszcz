package pl.giantscastle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.giantscastle.DAO.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao user;
	
	public String getUserID(){
		String test = user.getID("user10");
		System.out.println("-----------dana testowa id:"+test);
		return test;
	}
}
