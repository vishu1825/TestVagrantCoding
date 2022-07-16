package com.qa.enums;


/**
 * Enums to restrict the users to choose an appropriate field
 *
 * July 16, 2022
 * @author Vishwajeet Samal
 * @version 1.0
 *
 */
public enum Field {

    PLAYER("player"),
    COUNTRY("country"),
    ROLE("role");
    public final String property;

    Field(String property){
        this.property=property;
    }
}

