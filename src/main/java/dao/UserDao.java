package dao;

import org.springframework.data.repository.CrudRepository;

import entity.User;

public interface UserDao  extends CrudRepository<User,String>{
    
}
