package com.example.kodluyoruzbitirmewbs.repository;

import com.example.kodluyoruzbitirmewbs.entity.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends CrudRepository<Work, Integer> {
}
