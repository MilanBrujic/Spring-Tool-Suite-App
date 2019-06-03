package com.example.demo.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpa.Igrac;

public interface IgracRepository extends JpaRepository<Igrac, Integer> {

}
