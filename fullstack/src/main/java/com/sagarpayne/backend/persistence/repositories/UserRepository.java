package com.sagarpayne.backend.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sagarpayne.backend.persistence.domain.backend.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{

}
