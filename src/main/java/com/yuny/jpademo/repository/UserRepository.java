package com.yuny.jpademo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yuny.jpademo.pojo.User;


//
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    public List<User> findByEmailLike(String email);
    public User findByUsername(String username);
    public User findByName(String name);
}
