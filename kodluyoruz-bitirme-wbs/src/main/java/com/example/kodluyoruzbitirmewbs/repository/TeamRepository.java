package com.example.kodluyoruzbitirmewbs.repository;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//team repository
@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {
}
