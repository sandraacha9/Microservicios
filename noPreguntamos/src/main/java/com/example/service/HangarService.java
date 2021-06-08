package com.example.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Hangar;

@Repository
@Transactional
public interface HangarService extends JpaRepository<Hangar, Integer> {

}
