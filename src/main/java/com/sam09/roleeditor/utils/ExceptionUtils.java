package com.sam09.roleeditor.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

    public static void invalidIdException(String id ) {
        throw new IllegalArgumentException("Unable to Delete as invalid Id: " + id);
    }
}
