package com.example.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.LineChart;

import java.net.URL;
import java.util.ResourceBundle;
public class HelloController implements Initializable{

    @FXML
    private BarChart<String , Integer> barchart;

    @FXML
    private PieChart animation ;
    @FXML
    private PieChart food ;
    @FXML
    private LineChart<?, ?> prop;
    @FXML
    private PieChart season ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try { //connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reviews", "root", "");

            //barchart clean
            XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
            series1.setName("Cleanliness");
            series1.getData().add(new XYChart.Data<>("Femme", HotelReviewAnalyzer.getfemme(connection)));
            series1.getData().add(new XYChart.Data<>("Homme", HotelReviewAnalyzer.gethomme(connection)));
            barchart.getData().addAll(series1);
            //piechart animation
            ObservableList<PieChart.Data> pieChartData_animation =
                    FXCollections.observableArrayList(
                            new PieChart.Data("satisfied",HotelReviewAnalyzer.getAnimationSatisfactionPercentage(connection)),
                            new PieChart.Data("not satisfied",HotelReviewAnalyzer.getAnimationNotSatisfiedPercentage(connection)),
                            new PieChart.Data("Moyen ",HotelReviewAnalyzer.getAnimationMoyenPercentage(connection)));

            // to see the percentage
           pieChartData_animation.forEach(data -> data.nameProperty().bind(
                    Bindings.concat(data.getName(), " Amount: ", data.pieValueProperty())
            ));

           animation.setData(pieChartData_animation); // set data to the PieChart
            //piechart food
            ObservableList<PieChart.Data> pieChartData_food =
                    FXCollections.observableArrayList(
                            new PieChart.Data("satisfied",HotelReviewAnalyzer.getFoodSatisfactionPercentage(connection)),
                            new PieChart.Data("not satisfied",HotelReviewAnalyzer.getFoodNotSatisfiedPercentage(connection)),
                            new PieChart.Data("Moyen ",HotelReviewAnalyzer.getFoodMoyenPercentage(connection)));

            // to see the percentage
            pieChartData_food.forEach(data -> data.nameProperty().bind(
                    Bindings.concat(data.getName(), " Amount: ", data.pieValueProperty())
            ));

            food.setData(pieChartData_food); // set data to the PieChart
        // line chart
            prop.getXAxis().setLabel("XAxis");
            prop.getYAxis().setLabel("YAxis");

            XYChart.Series series_prop= new XYChart.Series();

            series_prop.getData().add(new XYChart.Data("1",HotelReviewAnalyzer.getCleanlinessCount1(connection)));
            series_prop.getData().add(new XYChart.Data("2",HotelReviewAnalyzer.getCleanlinessCount2(connection)));
            series_prop.getData().add(new XYChart.Data("3",HotelReviewAnalyzer.getCleanlinessCount3(connection)));
            series_prop.getData().add(new XYChart.Data("4",HotelReviewAnalyzer.getCleanlinessCount4(connection)));
            series_prop.getData().add(new XYChart.Data("5",HotelReviewAnalyzer.getCleanlinessCount5(connection)));



            XYChart.Series series_cf= new XYChart.Series();

            series_cf.getData().add(new XYChart.Data("1",HotelReviewAnalyzer.getConfortCount1(connection)));
            series_cf.getData().add(new XYChart.Data("2",HotelReviewAnalyzer.getConfortCount2(connection)));
            series_cf.getData().add(new XYChart.Data("3",HotelReviewAnalyzer.getConfortCount3(connection)));
            series_cf.getData().add(new XYChart.Data("4",HotelReviewAnalyzer.getConfortCount4(connection)));
            series_cf.getData().add(new XYChart.Data("5",HotelReviewAnalyzer.getConfortCount5(connection)));

            prop.getData().addAll(series_prop,series_cf);


            //piechart season
            ObservableList<PieChart.Data> pieChartData_season=
                    FXCollections.observableArrayList(
                            new PieChart.Data("satisfied",HotelReviewAnalyzer.getWinterPercentage(connection)),
                            new PieChart.Data("not satisfied",HotelReviewAnalyzer.getSummerPercentage(connection)),
                            new PieChart.Data("Moyen ",HotelReviewAnalyzer.getSpringPercentage(connection)));

            // to see the percentage
            pieChartData_season.forEach(data -> data.nameProperty().bind(
                    Bindings.concat(data.getName(), " Amount: ", data.pieValueProperty())
            ));

            season.setData(pieChartData_season); // set data to the PieChart







            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    }
