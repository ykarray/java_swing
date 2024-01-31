// HotelReviewForm.java
package com.example.admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReviewForm extends JFrame {

    public HotelReviewForm() {
        setTitle("Formulaire d'avis sur l'hôtel");
        setSize(700, 700); // Increased height to accommodate new components
        getContentPane().setBackground(new Color(249, 180, 171));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createFormPanel();

        setLocationRelativeTo(null);
        setVisible(true);
    }
    JLabel hotelNameLabel = new JLabel("1. Nom de l'hôtel:");
    JTextField hotelNameTextField = new JTextField();
    JLabel genderLabel = new JLabel("2. Sélectionnez votre sexe:");
    ButtonGroup genderButtonGroup = new ButtonGroup();
    JRadioButton femmeRadioButton = new JRadioButton("Femme");
    JRadioButton hommeRadioButton = new JRadioButton("Homme");
    JLabel ageLabel = new JLabel("3. Votre âge:");
    JTextField ageTextField = new JTextField();
    JLabel stayDurationLabel = new JLabel("4. Combien de temps avez-vous séjourné?");
    JComboBox stayDurationDays = new JComboBox<>(new String[]{"0","1", "2", "3", "4", "5", "6", "7"});
    JComboBox stayDurationWeeks = new JComboBox<>(new String[]{"0","1", "2", "3", "4"});
    JComboBox stayDurationMonths = new JComboBox<>(new String[]{"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});

    JLabel seasonLabel = new JLabel("5. Quelle saison étiez-vous là?");
    JCheckBox  summerCheckBox = new JCheckBox("Été");
    JCheckBox winterCheckBox = new JCheckBox("Hiver");
    JCheckBox springCheckBox = new JCheckBox("Printemps");
    JLabel purposeLabel = new JLabel("6. Étiez-vous en vacances ou en voyage d'affaires?");
    JCheckBox vacationCheckBox = new JCheckBox("Vacances/Familles");
    JCheckBox workCheckBox = new JCheckBox("Voyage d'affaires");
    JLabel familyLabel = new JLabel("7. Étiez-vous avec votre famille ou seul?");
    ButtonGroup familyButtonGroup = new ButtonGroup();
    JRadioButton familyRadioButton = new JRadioButton("Avec la famille");
    JRadioButton aloneRadioButton = new JRadioButton("Seul");
    JLabel animationLabel = new JLabel("8. Avez-vous aimé les animations?");
    ButtonGroup animationButtonGroup = new ButtonGroup();
    JRadioButton animationSatisfiedRadioButton = new JRadioButton("Satisfait");
    JRadioButton animationMoyenRadioButton = new JRadioButton("Moyen");
    JRadioButton animationNotSatisfiedRadioButton = new JRadioButton("Non satisfait");
    JLabel foodLabel = new JLabel("9. Avez-vous aimé la nourriture?");
    ButtonGroup foodButtonGroup = new ButtonGroup();
    JRadioButton foodSatisfiedRadioButton = new JRadioButton("Satisfait");
    JRadioButton foodMoyenRadioButton = new JRadioButton("Moyen");
    JRadioButton foodNotSatisfiedRadioButton = new JRadioButton("Non satisfait");
    JLabel cleanlinessLabel = new JLabel("10. Évaluation de la propreté:");
    JComboBox cleanlinessComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
    JLabel comfortLabel = new JLabel("11. Évaluation du confort:");
    JComboBox comfortComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});



    private void createFormPanel() {
        JPanel panelG = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(187, 212, 206));
        panel1.setBackground(new Color(187, 212, 206));
        panelG.setBackground(new Color(187, 212, 206));
        panel1.setLayout(new GridLayout(5, 2)); // Adjusted grid layout to accommodate new components
        panel2.setLayout(new GridLayout(7, 2)); // Adjusted grid layout to accommodate new components

        // 1 Add question about hotel name

        panel1.add(hotelNameLabel);

        panel1.add(hotelNameTextField);

        // 2Add question about gender

        JPanel genderPanel = new JPanel();

        genderPanel.setLayout(new GridLayout(2,1));
        genderPanel.setBackground(new Color(187, 212, 206));
        genderButtonGroup.add(femmeRadioButton);
        genderButtonGroup.add(hommeRadioButton);

        genderPanel.add(femmeRadioButton);
        genderPanel.add(hommeRadioButton);
        panel1.add(genderLabel);
        panel1.add(genderPanel);

        //3 Add question about age

        panel1.add(ageLabel);

        panel1.add(ageTextField);
        //4 Add question about stay duration

        JPanel durationPanel =new JPanel();
        durationPanel.setLayout(new GridLayout(3, 2));
        durationPanel.add(new JLabel("Jours:"));
        durationPanel.add(stayDurationDays);
        durationPanel.add(new JLabel("Semaines:"));
        durationPanel.add(stayDurationWeeks);
        durationPanel.add(new JLabel("Mois:"));
        durationPanel.add(stayDurationMonths);
        durationPanel.setBackground(new Color(187, 212, 206));
        panel1.add(stayDurationLabel);
        panel1.add(durationPanel);
        //5 Add question about season
        ;
        JPanel seasonPanel = new JPanel();
        seasonPanel.setLayout(new GridLayout(3,1));
        seasonPanel.setBackground(new Color(187, 212, 206));
        seasonPanel.add(summerCheckBox);
        seasonPanel.add(winterCheckBox);
        seasonPanel.add(springCheckBox);

        panel2.add(seasonLabel);
        panel2.add(seasonPanel);
        //6 Add question about purpose of stay

        JPanel purposePanel = new JPanel();
        purposePanel.setLayout(new GridLayout(2,1));
        purposePanel.add(vacationCheckBox);
        purposePanel.add(workCheckBox);
        purposePanel.setBackground(new Color(187, 212, 206));
        panel2.add(purposeLabel);
        panel2.add(purposePanel);

        //7 Add question about being with family or alone



        familyButtonGroup.add(familyRadioButton);
        familyButtonGroup.add(aloneRadioButton);

        JPanel familyPanel= new JPanel();
        familyPanel.add(familyRadioButton,BorderLayout.CENTER);
        familyPanel.add(aloneRadioButton,BorderLayout.SOUTH);
        familyPanel.setBackground(new Color(187, 212, 206));
        panel2.add(familyLabel);
        panel2.add(familyPanel);
        //8 Add question about liking animation



        animationButtonGroup.add(animationSatisfiedRadioButton);
        animationButtonGroup.add(animationMoyenRadioButton);
        animationButtonGroup.add(animationNotSatisfiedRadioButton);
        JPanel animationPanel= new JPanel();
        animationPanel.setLayout(new GridLayout(3,1));
        animationPanel.add(animationSatisfiedRadioButton);
        animationPanel.add(animationMoyenRadioButton);
        animationPanel.add(animationNotSatisfiedRadioButton);
        animationPanel.setBackground(new Color(187, 212, 206));
        panel2.add(animationLabel);
        panel2.add(animationPanel);
        // 9Add question about liking food



        foodButtonGroup.add(foodSatisfiedRadioButton);
        foodButtonGroup.add(foodMoyenRadioButton);
        foodButtonGroup.add(foodNotSatisfiedRadioButton);
        JPanel foodPanel =new JPanel();
        foodPanel.setLayout(new GridLayout(3,1));
        foodPanel.add(foodSatisfiedRadioButton);
        foodPanel.add(foodMoyenRadioButton);
        foodPanel.add(foodNotSatisfiedRadioButton);
        foodPanel.setBackground(new Color(187, 212, 206));

        panel2.add(foodLabel);
        panel2.add(foodPanel);

        //10 Add question about cleanliness

        panel2.add(cleanlinessLabel);

        panel2.add(cleanlinessComboBox);

        //11 Add question about comfort

        panel2.add(comfortLabel);

        panel2.add(comfortComboBox);
        panelG.add(panel2,BorderLayout.CENTER);


        // ... (code for the remaining form components)

        JButton submitButton = new JButton("Soumettre");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (saveFormData()) {
                    JOptionPane.showMessageDialog(HotelReviewForm.this, "Formulaire soumis avec succès!");
                } else {
                    JOptionPane.showMessageDialog(HotelReviewForm.this, "Erreur lors de la soumission du formulaire.");
                }
            }
        });
        panelG.add(submitButton,BorderLayout.SOUTH);
        JTabbedPane onglets = new JTabbedPane();
        onglets.setBounds(10,20,300,600);

        onglets.add("page1",panel1);
        onglets.add("page2",panelG);
        onglets.setBackground(new Color(187, 212, 206));
        add(onglets);
    }

    private boolean saveFormData() {
        String hotelNameValue = hotelNameTextField.getText();
        String genderValue = femmeRadioButton.isSelected() ? "Femme" : "Homme";
        String stayDurationDaysValue = stayDurationDays.getSelectedItem().toString();
        String stayDurationWeeksValue =stayDurationWeeks.getSelectedItem().toString();
        String stayDurationMonthsValue =stayDurationMonths.getSelectedItem().toString();
        boolean summerSelected = summerCheckBox.isSelected();
        boolean winterSelected = winterCheckBox.isSelected();
        boolean springSelected = springCheckBox.isSelected();
        boolean vacationSelected = vacationCheckBox.isSelected();
        boolean workSelected = workCheckBox.isSelected();
        boolean familySelected = familyRadioButton.isSelected();
        boolean aloneSelected = aloneRadioButton.isSelected();
        boolean animationSatisfied = animationSatisfiedRadioButton.isSelected();
        boolean animationMoyen= animationMoyenRadioButton.isSelected();
        boolean animationNotSatisfied = animationNotSatisfiedRadioButton.isSelected();
        boolean foodSatisfied = foodSatisfiedRadioButton.isSelected();
        boolean foodMoyen = foodMoyenRadioButton.isSelected();
        boolean foodNotSatisfied = foodNotSatisfiedRadioButton.isSelected();
        String cleanlinessValue = cleanlinessComboBox.getSelectedItem().toString();
        String comfortValue =comfortComboBox.getSelectedItem().toString();
        String ageValue = ageTextField.getText();

        // Call a method in DatabaseHandler to handle database operations
        return DatabaseHandler.insertReview(
                hotelNameValue
                ,genderValue ,
                ageValue ,stayDurationDaysValue ,stayDurationWeeksValue , stayDurationMonthsValue ,summerSelected,winterSelected ,springSelected, vacationSelected ,workSelected ,familySelected , aloneSelected ,animationSatisfied ,
                animationMoyen, animationNotSatisfied, foodSatisfied, foodMoyen,foodNotSatisfied , cleanlinessValue ,comfortValue
        );
    }

}
