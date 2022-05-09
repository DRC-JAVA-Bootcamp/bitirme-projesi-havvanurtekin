package com.example.kodluyoruzbitirmewbs.repository;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import com.example.kodluyoruzbitirmewbs.entity.User;
import com.example.kodluyoruzbitirmewbs.entity.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends CrudRepository<Work, Integer> {
    List<Work> findAllByTeam(Team team);

    List<Work> findAllByUser(User user);

    List<User> findByUser(User user);

    List<Work> findAllById(Integer workId);
}
