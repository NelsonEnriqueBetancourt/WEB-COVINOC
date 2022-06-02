package com.COVINOC.USER.Services.Users;

import com.COVINOC.USER.Models.User;
import com.COVINOC.USER.Repositorys.UserRepository;
import com.COVINOC.USER.Services.Pagination.PageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements PageUser {

    @Autowired
    private UserRepository userRepository;


    public List<User> GetUsers(){
        return userRepository.findAll();
    }

    public User GetUserId(Integer id){
        return userRepository.findById(id).get();
    }

    public void SaveUser(User user){
        userRepository.save(user);
    }

    public void DeleteUserId(Integer id){
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> USER_PAGE(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
