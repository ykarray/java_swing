// DatabaseHandler.java
package com.example.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_reviews";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static boolean insertReview(

            String hotelName, String gender, String age,String stayDurationDays, String stayDurationWeeks,
            String stayDurationMonths, boolean summer, boolean winter, boolean spring,
            boolean vacation, boolean work, boolean family, boolean alone,
            boolean animationSatisfied, boolean animationNotSatisfied,boolean animationMoyen,
            boolean foodSatisfied,boolean foodMoyen, boolean foodNotSatisfied,
            String cleanliness, // Convert to Integer
            String comfort // Convert to Integer
            ) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            String sql = "INSERT INTO review1 (hotel_name,gender  ,age  ,stay_duration_days,stay_duration_weeks  ,stay_duration_months  ,summer   ,winter  ,spring  ,vacation  ,  work  ,  family ,alone  , animation_satisfied  ,animation_moyen  ,animation_not_satisfied  ,food_satisfied , food_moyen  ,  food_not_satisfied  ,cleanliness  ,comfort ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, hotelName);
                preparedStatement.setString(2, gender);
                preparedStatement.setInt(3, Integer.parseInt(age));
                preparedStatement.setInt(4, Integer.parseInt(stayDurationDays));
                preparedStatement.setInt(5, Integer.parseInt(stayDurationWeeks));
                preparedStatement.setInt(6, Integer.parseInt(stayDurationMonths));
                preparedStatement.setBoolean(7, summer);
                preparedStatement.setBoolean(8, winter);
                preparedStatement.setBoolean(9, spring);
                preparedStatement.setBoolean(10, vacation);
                preparedStatement.setBoolean(11, work);
                preparedStatement.setBoolean(12, family);
                preparedStatement.setBoolean(13, alone);
                preparedStatement.setBoolean(14, animationSatisfied);
                preparedStatement.setBoolean(15, animationMoyen);
                preparedStatement.setBoolean(16, animationNotSatisfied);
                preparedStatement.setBoolean(17, foodSatisfied);
                preparedStatement.setBoolean(18, foodMoyen);
                preparedStatement.setBoolean(19, foodNotSatisfied);
                preparedStatement.setInt(20, Integer.parseInt(cleanliness)); // Pass as Integer
                preparedStatement.setInt(21, Integer.parseInt(comfort)); // Pass as Integer


                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
