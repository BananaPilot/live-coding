package com.pasqualehorse.livecoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasqualehorse.livecoding.entity.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Long>{

}
