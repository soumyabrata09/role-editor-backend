package com.sam09.roleeditor.utils;

public class ExceptionUtils {

    public static void invalidIdException(String id ) {
        throw new RuntimeException("Unable to Delete as invalid Id: " + id);
    }
}
