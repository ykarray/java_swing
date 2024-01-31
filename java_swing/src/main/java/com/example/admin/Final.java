package com.example.admin;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Final extends JFrame {
    private JButton dashboardButton;
    private JButton formulaireButton;

    public Final() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bienvenue !");
        setSize(700, 700);
        getContentPane().setBackground(new Color(249, 180, 171)); // Equivalent to #f9b4ab
        setLocationRelativeTo(null);
        initUI();

        setVisible(true);
    }

    private void initUI() {
        JLabel welcomeLabel = new JLabel("Bienvenue !");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 43));
        welcomeLabel.setBounds(240, 75, 264, 40);

        // Load image from the classpath
        ImageIcon hotelImageIcon = new ImageIcon("/home/yassmine/IdeaProjects/admin/src/main/java/com/example/admin/hotel.png");
        Image hotelImage = hotelImageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        JLabel hotelImageLabel = new JLabel(new ImageIcon(hotelImage));
        hotelImageLabel.setBounds(240, 150, 200, 150);
        formulaireButton = new JButton("Formulaire");
        formulaireButton.setBounds(210, 355, 114, 38);
        formulaireButton.setBackground(new Color(187, 212, 206));

        dashboardButton = new JButton("Dashboard");
        dashboardButton.setBounds(362, 355, 114, 38);
        dashboardButton.setBackground(new Color(187, 212, 206));



        DashboardButtonListener dashboardButtonListener = new DashboardButtonListener();
        dashboardButton.addActionListener(dashboardButtonListener);

        FormulaireButtonListener formulaireButtonListener = new FormulaireButtonListener();
        formulaireButton.addActionListener(formulaireButtonListener);

        getContentPane().setLayout(null);
        getContentPane().add(welcomeLabel);
        getContentPane().add(hotelImageLabel);
        getContentPane().add(formulaireButton);
        getContentPane().add(dashboardButton);
    }

    private class DashboardButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle dashboard button click
            // Open HelloApplication on the EDT
            SwingUtilities.invokeLater(() -> {
                HelloApplication.launch(HelloApplication.class);
            });
        }
    }

    private class FormulaireButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle formulaire button click
            // Open HotelReviewForm on the EDT
            SwingUtilities.invokeLater(() -> {
                new HotelReviewForm();
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Final());
    }
}
