package com.sam09.roleeditor.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "Roles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleDto implements Serializable {

    @Id
    String id;
    String roleName;
}
