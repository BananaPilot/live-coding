package com.pasqualehorse.livecoding.repository;

import com.pasqualehorse.livecoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasqualehorse.livecoding.entity.UserRuolo;
import com.pasqualehorse.livecoding.entity.UserRuoloPK;

import java.util.List;

@Repository
public interface UserRuoloRepository extends JpaRepository<UserRuolo, UserRuoloPK>{

    List<UserRuolo> findByUser(User user);
}
