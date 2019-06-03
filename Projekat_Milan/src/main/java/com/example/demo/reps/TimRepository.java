package com.example.demo.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpa.Tim;

public interface TimRepository extends JpaRepository<Tim, Integer> {

}
