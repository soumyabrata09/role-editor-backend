package com.sam09.roleeditor.repositories;

import com.sam09.roleeditor.dtos.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDto, String> {

}
