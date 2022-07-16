package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import com.qa.exceptions.CustomizeException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FrameworkUtils {

        JSONArray companyList;
        JSONObject jsonObject;
        public JSONArray getPlayerList() {

            JSONParser parser = new JSONParser();
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(System.getProperty("user.dir")+"/src/test/resources/team.json");
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
            companyList = (JSONArray) Objects.requireNonNull(jsonObject).get("player");
            return companyList;
        }

        /**
         *
         * To check the team size
         *
         * July 16, 2022
         * @author Vishwajeet Samal
         *
         */
        public void checkTeamSize(){
            if (getPlayerList().size() > 11 || getPlayerList().size() < 11) {
                throw new CustomizeException("Please provide correct team size");
            }

        }

        /**
         * Get the country count from the json array
         *
         * July 16, 2022
         * @author Vishwajeet Samal
         * @param country get the country from the test class
         * @return count which give the total country count
         */
        public int getCountryCount(String country) {
            checkTeamSize();
            int count = 0;
            for (Object list : companyList) {
                jsonObject = (JSONObject) list;
                String countryName = (String) jsonObject.get("country");

                if (!countryName.equals(country)) {
                    count++;
                }

            }
            return count;
        }

        /**
         * Get the country count from the json array
         *
         * July 16, 2022
         * @author Vishwajeet Samal
         * @param role get the role in the team  from the test class
         * @return count which give the total  count for particular role
         */
        public int getRoleCount(String role) {
            checkTeamSize();
            int count = 0;
            for (Object list : companyList) {
                jsonObject = (JSONObject) list;
                String roleName = (String) jsonObject.get("role");

                if (roleName.equals(role)) {
                    count++;
                }

            }
            return count;
        }



    }
