package com.example.kodluyoruzbitirmewbs.repository;

import com.example.kodluyoruzbitirmewbs.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
