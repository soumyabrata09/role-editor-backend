package com.sam09.roleeditor.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationConstants {

    public static final String PATH_SELECTOR = "api/v1/**";
    public static final String TITLE = "Role Editor Application";
    public static final String DESCRIPTION = "A reference-app(REST) to edit user roles";
    public static final String VERSION = "1.0";
    public static final String TERMS = "Terms of Service";
    public static final String CROSS_ORIGIN_VALUE = "*";
}
