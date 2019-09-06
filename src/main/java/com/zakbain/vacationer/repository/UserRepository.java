package com.zakbain.vacationer.repository;

import com.zakbain.vacationer.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
