package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.qa.constants.FrameworkConstant;
import com.qa.enums.Field;
import com.qa.exceptions.CustomizeException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FrameworkUtils {

    JSONArray playerList;
    JSONObject jsonObject;

    public JSONArray getPlayerList() {

        JSONParser parser = new JSONParser();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FrameworkConstant.getJSONFILEPATH());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object object = null;
        try {
            object = parser.parse(fileReader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) object;

        playerList = (JSONArray) Objects.requireNonNull(jsonObject).get(Field.PLAYER.property);
        return playerList;
    }

    /**
     * To check the team size
     * <p>
     * July 16, 2022
     *
     * @author Vishwajeet Samal
     */
    public void checkTeamSize() {
        if (getPlayerList().size() > 11 || getPlayerList().size() < 11) {
            throw new CustomizeException("Please provide correct team size");
        }

    }

    /**
     * Get the country count from the json array
     * <p>
     * July 16, 2022
     *
     * @param country get the country from the test class
     * @return count which give the total country count
     * @author Vishwajeet Samal
     */
    public int getCountryCount(String country) {
        checkTeamSize();
        int count = 0;
        for (Object list : playerList) {
            jsonObject = (JSONObject) list;
            String countryName = (String) jsonObject.get(Field.COUNTRY.property);

            if (!countryName.equals(country)) {
                count++;
            }

        }
        return count;
    }

    /**
     * Get the role count from the json array
     * <p>
     * July 16, 2022
     *
     * @param role get the role in the team  from the test class
     * @return count which give the total  count for particular role
     * @author Vishwajeet Samal
     */
    public int getRoleCount(String role) {
        checkTeamSize();
        int count = 0;
        for (Object list : playerList) {
            jsonObject = (JSONObject) list;
            String roleName = (String) jsonObject.get(Field.ROLE.property);

            if (roleName.equals(role)) {
                count++;
            }

        }
        return count;
    }

    public double getTotalPrice(double price,String country) {
        double totPrice = 0;
        checkTeamSize();
        for (Object list : playerList) {
            jsonObject = (JSONObject) list;
            String countryName = (String) jsonObject.get(Field.COUNTRY.property);
            if (!countryName.equals(country)) {
                    String totalPrice = (String) jsonObject.get(Field.PRICE.property);
                    double calPrice = Double.parseDouble(totalPrice);
                    List<Double> priceList = new ArrayList<>();
                    priceList.add(calPrice);
                    for (double i : priceList) {
                        totPrice = totPrice + i;
                    }

                }

            }

        return totPrice;


    }
}
