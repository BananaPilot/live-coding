package com.pasqualehorse.livecoding.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pasqualehorse.livecoding.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

	@Query( value = "select * from userT where username like %:username%", nativeQuery = true)
	List<User> getLikeUsername(@Param("username") String username);
	@Query ( value = "select * from userT where username like :username",nativeQuery = true)
	Page<User> findPageByUsernameLike(String username, Pageable page);

	
}
