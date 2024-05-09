package com.pasqualehorse.livecoding.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasqualehorse.livecoding.entity.User;
import com.pasqualehorse.livecoding.entity.UserRuolo;
import com.pasqualehorse.livecoding.entity.UserRuoloPK;

@Repository
public interface UserRuoloRepository extends JpaRepository<UserRuolo, UserRuoloPK>{


	Page<UserRuolo> findByUser(User user, org.springframework.data.domain.Pageable paegable);
}
