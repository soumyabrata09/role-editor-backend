package com.sam09.roleeditor.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

    public static IllegalArgumentException invalidIdException(String id , String msg) {
        throw new IllegalArgumentException(msg + ": " + id);
    }
}
