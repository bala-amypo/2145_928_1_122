package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Influencer;

@Repository
public interface InfluencerRepository
        extends JpaRepository<Influencer, Long> {
}
