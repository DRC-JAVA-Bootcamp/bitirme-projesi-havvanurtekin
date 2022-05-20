package com.example.kodluyoruzbitirmewbs.repository;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import com.example.kodluyoruzbitirmewbs.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//user repository
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAllByTeam(Team team);

    List<Object> findByUser(User user);
}
