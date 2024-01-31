package com.example.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelReviewAnalyzer {

    private static final String URL = "jdbc:mysql://localhost:3306/hotel_reviews";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Call the functions
            double animationSatisfactionPercentage = getAnimationSatisfactionPercentage(connection);
            double animationMoyenPercentage = getAnimationMoyenPercentage(connection);
            double animationNotSatisfiedPercentage = getAnimationNotSatisfiedPercentage(connection);
            double foodSatisfactionPercentage = getFoodSatisfactionPercentage(connection);
            double foodMoyenPercentage = getFoodMoyenPercentage(connection);
            double foodNotSatisfiedPercentage = getFoodNotSatisfiedPercentage(connection);

            double summerPercentage = getSummerPercentage(connection);
            double winterPercentage = getWinterPercentage(connection);
            double springPercentage = getSpringPercentage(connection);

            // Print the results
           System.out.println("Animation Satisfaction Percentage: " + animationSatisfactionPercentage + "%");
            System.out.println("Animation Moyen Percentage: " + animationMoyenPercentage + "%");
            System.out.println("Animation Not Satisfied Percentage: " + animationNotSatisfiedPercentage + "%");
            System.out.println("Food Satisfaction Percentage: " + foodSatisfactionPercentage + "%");
            System.out.println("Food Moyen Percentage: " + foodMoyenPercentage + "%");
            System.out.println("Food Not Satisfied Percentage: " + foodNotSatisfiedPercentage + "%");
            System.out.println("Summer Percentage: " + summerPercentage + "%");
            System.out.println("Winter Percentage: " + winterPercentage + "%");
            System.out.println("Spring Percentage: " + springPercentage + "%");

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static double getAnimationSatisfactionPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(animation_satisfied) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }
    public static double getAnimationMoyenPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(animation_moyen) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }

    public static double getAnimationNotSatisfiedPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(animation_not_satisfied) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }
    public static double getFoodSatisfactionPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(food_satisfied) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }

    public static double getFoodMoyenPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(food_moyen) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }

    public static double getFoodNotSatisfiedPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(food_not_satisfied) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }

    public static double getWinterPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(winter) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }
    public static double getSummerPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(summer) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }

    public static double getSpringPercentage(Connection connection) throws SQLException {
        String query = "SELECT (SUM(spring) / COUNT(*)) * 100 AS percentage FROM review1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("percentage");
            }
        }
        return 0.0;
    }








    public static int getCleanlinessCount1(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE cleanliness = 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int getCleanlinessCount2(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE cleanliness = 2";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int getCleanlinessCount3(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE cleanliness = 3";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int getCleanlinessCount4(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE cleanliness = 4";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int getCleanlinessCount5(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE cleanliness = 5";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }


    ////confort
    public static int getConfortCount1(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE comfort = 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int getConfortCount2(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE comfort = 2";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int getConfortCount3(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE comfort = 3";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int getConfortCount4(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE comfort = 4";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int getConfortCount5(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE comfort = 5";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }




    /////
    public static int getfemme(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE gender = 'Femme'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }
    public static int gethomme(Connection connection) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM review1 WHERE gender = 'Homme'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }


}
