package com.qa.enums;


/**
 * Enums to restrict the users to choose an appropriate country
 *
 *
 * July 16, 2022
 * @author Vishwajeet Samal
 * @version 1.0
 *
 */
public enum Country {

    INDIA("India"),
    SOUTH_AFRICA("South Africa"),
    AUSTRALIA("Australia"),
    SRILANKA("Srilanka") ;

    public final String property;

    Country(String property){
        this.property=property;
    }
}
