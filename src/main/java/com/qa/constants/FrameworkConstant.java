package com.qa.constants;

import lombok.Getter;

/**
 * Framework Constants holds all the constant values used within the framework.
 *
 * July 16, 2022
 * @author Vishwajeet Samal
 * @version 1.0
 *
 */
public class FrameworkConstant {

    /**
     * Private constructor to avoid external instantiation
     */
    private FrameworkConstant(){

    }


    private static @Getter final String JSONFILEPATH=System.getProperty("user.dir") +"/src/test/resources/team.json";
    private static @Getter final String COUNTRY_NAME="India";
    private static @Getter final String ROLE="Wicket-keeper";
    public static final double TOTAL_PRICE=36.50;
}
