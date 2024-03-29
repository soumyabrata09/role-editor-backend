package com.sam09.roleeditor.models;

import com.sam09.roleeditor.dtos.RoleDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    String id;
    String userName;
    String lastName;
    RoleDto role;
}
