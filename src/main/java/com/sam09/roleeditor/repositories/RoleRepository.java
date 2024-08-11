package com.sam09.roleeditor.repositories;

import com.sam09.roleeditor.dtos.RoleDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<RoleDto, String> {

}
