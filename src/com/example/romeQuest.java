package com.example;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.desktop.QuitEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A simple RPG game I made, multiple choices offered
//@iznaor
public class romeQuest {

    JFrame gameWindow; // name to be referenced
    Container gameBox;

    JPanel titlePanel;
    JLabel titleLabel;

    JPanel subTitlePanel;
    JLabel subTitleLabel;

    JPanel startButtonPanel;
    JButton startButtonLabel;

    JPanel mainText;

    JTextArea areaForMainText;

    JPanel choiceButtonPanel;

    JButton choice1, choice2, choice3, choice4;

    JPanel playerStatsPanel;

    JLabel hpLabel, hpLabelState, weaponLabel, weaponLabelStat, staminaLabel, staminaLabelState, goldLabel, goldLabelState;

    TitleScreenHandler scControl = new TitleScreenHandler();
    PlayerChoiceHandler plChoControl = new PlayerChoiceHandler();

    Font titleSize = new Font("Times New Roman", Font.PLAIN, 50);
    Font subTitleSize = new Font("Times New Roman", Font.PLAIN, 25);
    Font startButtonSize = new Font("Times New Roman", Font.PLAIN, 35);

    int playerHP;
    int playerStamina;
    int playerGold;
    String weaponType;
    String position;

    ImageIcon logo = new ImageIcon(".//res//myimage.jpg");

    public static void main(String[] args){
        new romeQuest();
    }
    public romeQuest(){
        gameWindow = new JFrame(); // initializing
        gameWindow.setSize(1280,720);
        gameWindow.setIconImage(logo.getImage());
        // self explanatory
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.black);
        gameWindow.setLayout(null); // done so custom layout can be used
        gameWindow.setVisible(true); // makes the window visible to the player
        gameBox = gameWindow.getContentPane();
        //-----------------------------------------------------------------------------------------
        //panel is defined
        titlePanel = new JPanel();
        titlePanel.setBounds(120,100, 1280, 100);
        titlePanel.setBackground(Color.red);
        //panel is shown
        gameBox.add(titlePanel);

        //label is defined
        titleLabel = new JLabel("Rome Quest");
        titleLabel.setForeground(Color.white);
        //label is shown on panel
        titlePanel.add(titleLabel);
        //Font and its sized used
        titleLabel.setFont(titleSize);
        //--------------------------------------------------------------------------
        //panel subTitle is defined
        subTitlePanel = new JPanel();
        subTitlePanel.setBounds(120,200, 1280, 50);
        subTitlePanel.setBackground(Color.red);
        //panel subTitle is shown
        gameBox.add(subTitlePanel);

        //label subTitle is defined
        subTitleLabel = new JLabel("Forge your destiny!");
        subTitleLabel.setForeground(Color.white);
        //label subTitle is shown on panel
        subTitlePanel.add(subTitleLabel);
        //Font and its sized used
        subTitleLabel.setFont(subTitleSize);
        //--------------------------------------------------------------------------------
        //panel startButton is defined
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(655,500,200,65);
        startButtonPanel.setBackground(Color.BLACK);
        //panel startButton  is shown
        gameBox.add(startButtonPanel);

        //label startButton is defined
        startButtonLabel = new JButton("START");
        startButtonLabel.setForeground(Color.WHITE);
        startButtonLabel.setBackground(Color.RED);
        //label startButton is shown on panel
        startButtonPanel.add(startButtonLabel);
        //Font and its sized used
        startButtonLabel.setFont(startButtonSize);

        //when startButton clicked
        startButtonLabel.addActionListener(scControl);
        //remove ghost lines
        startButtonLabel.setFocusPainted(false);

    }
    //NEW GAME METHOD
    public void romeQuestGameScreen(){
        //when player starts game the other panels are hidden
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        subTitlePanel.setVisible(false);
        //panel for mainText is defined
        mainText = new JPanel();
        mainText.setBounds(120,200,1280,200);
        mainText.setBackground(Color.gray);
        //panel for mainText  is shown
        gameBox.add(mainText);

        //areaForMainText is defined
        areaForMainText = new JTextArea();
        areaForMainText.setBounds(120,100,1280,250);
        //color of the main text
        areaForMainText.setBackground(Color.gray);
        areaForMainText.setForeground(Color.black);
        areaForMainText.setFont(subTitleSize);
        areaForMainText.setLineWrap(true);

        mainText.add(areaForMainText);

        //user button choices represented on this panel
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(120,500,1280,250);
        //button color
        choiceButtonPanel.setBackground(Color.gray);
        //custom grid
        choiceButtonPanel.setLayout(new GridLayout(2,2));
        gameBox.add(choiceButtonPanel);
        //---------------------------------------------------------------------------------
        //choice buttons settings
        choice1 = new JButton("");
        choice2 = new JButton("");
        choice3 = new JButton("");
        choice4 = new JButton("");
        //-------------------------------
        choice1.setBackground(Color.black);
        choice2.setBackground(Color.black);
        choice3.setBackground(Color.black);
        choice4.setBackground(Color.black);
        //---------------------------------
        choice1.setForeground(Color.white);
        choice2.setForeground(Color.white);
        choice3.setForeground(Color.white);
        choice4.setForeground(Color.white);
        //-----------------------------------
        choice1.setFont(subTitleSize);
        choice2.setFont(subTitleSize);
        choice3.setFont(subTitleSize);
        choice4.setFont(subTitleSize);
        //-----------------------------------
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        choiceButtonPanel.add(choice4);
        //------------------------------------
        //remove ghost lines
        choice1.setFocusPainted(false);
        choice2.setFocusPainted(false);
        choice3.setFocusPainted(false);
        choice4.setFocusPainted(false);
        //------------------------------------
        choice1.addActionListener(plChoControl);
        choice2.addActionListener(plChoControl);
        choice3.addActionListener(plChoControl);
        choice4.addActionListener(plChoControl);
        //------------------------------------
        choice1.setActionCommand("y1");
        choice2.setActionCommand("y2");
        choice3.setActionCommand("y3");
        choice4.setActionCommand("y4");
        //------------------------------------
        //panel for player stats
        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(120,50,1280,100);
        playerStatsPanel.setBackground(Color.darkGray);
        playerStatsPanel.setLayout(new GridLayout(1,4));
        //ADD PANEL TO BOX, needed for it to show to player
        gameBox.add(playerStatsPanel);
        //labels for player
        hpLabel = new JLabel("HEALTH:");
        hpLabelState = new JLabel();

        goldLabel = new JLabel("GOLD:");
        goldLabelState =new JLabel();

        weaponLabel = new JLabel("WEAPON:");
        weaponLabelStat = new JLabel();

        staminaLabel = new JLabel("STAMINA:");
        staminaLabelState = new JLabel();

        hpLabel.setFont(subTitleSize);
        hpLabelState.setFont(subTitleSize);
        weaponLabel.setFont(subTitleSize);
        weaponLabelStat.setFont(subTitleSize);
        staminaLabel.setFont(subTitleSize);
        staminaLabelState.setFont(subTitleSize);
        goldLabel.setFont(subTitleSize);
        goldLabelState.setFont(subTitleSize);

        hpLabel.setForeground(Color.white);
        hpLabelState.setForeground(Color.GREEN);
        weaponLabel.setForeground(Color.white);
        weaponLabelStat.setForeground(Color.red);
        staminaLabel.setForeground(Color.white);
        staminaLabelState.setForeground(Color.CYAN);
        goldLabel.setForeground(Color.white);
        goldLabelState.setForeground(Color.ORANGE);

        playerStatsPanel.add(hpLabel);
        playerStatsPanel.add(hpLabelState);
        playerStatsPanel.add(weaponLabel);
        playerStatsPanel.add(weaponLabelStat);
        playerStatsPanel.add(staminaLabel);
        playerStatsPanel.add(staminaLabelState);
        playerStatsPanel.add(goldLabel);
        playerStatsPanel.add(goldLabelState);

        playerValueSetup();

    }
    //new method
    public void playerValueSetup(){
        playerHP = 100;
        hpLabelState.setText(""+playerHP);

        playerGold = 0;
        goldLabelState.setText(""+playerGold);

        playerStamina = 100;
        staminaLabelState.setText(""+playerStamina);

        weaponType = "Gladius";
        weaponLabelStat.setText(weaponType);
        romeHome();
    }
    //new method
    public void romeHome(){
        position = "romeHome";
        areaForMainText.setText("A Roman Centurion comes to your house asking you to join the Caesars new military campaign." +
                "\nHe doesn't look like the type of guy that will take a no for an answer.");
        choice1.setText("Go with him");
        choice2.setText("Attempt to get away");
        choice3.setText("Plead for exemption");
        choice4.setText("Try to bribe him");
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            romeQuestGameScreen();
        }
    }
    //--------------------------------------------------------------------------------------------------
    //First action
    //--------------------------------------------------------------------------------------------------

    public void Away(){
        position = "Away";
        areaForMainText.setText("You try to overpower him, but fail, you wake up in the camp and are told by a guard to start digging a toilet" +
                "\nfor the troops.");
        choice1.setText("Do what you are told");
        choice2.setText("Refuse");
        choice3.setText("Spit in his face");
        choice4.setText("Try to bribe him");
        playerHP=playerHP-20;
        hpLabelState.setText(""+playerHP);
    }
    public void GoWithHim(){
        position = "GoWithHim";
        areaForMainText.setText("You were given 10 golden coins for the first month of your service, in the armory you are offered heavy armor for the price of \n5 golden coins or a light armor for the price of 2 golden coins.\n" +
                "What will you do?");
        choice1.setText("Buy the heavy armor");
        choice2.setText("Buy the light armor");
        choice3.setText("Try to steal the heavy armor");
        choice4.setText("Try to steal the light armor");
        playerGold=10;
        goldLabelState.setText(""+playerGold);
    }
    public void Plead(){
        position = "Plead";
        areaForMainText.setText("Perhaps you can still serve the Roman Empire in the kitchen... What do you say?");
        choice1.setText("Thank you!");
        choice2.setText("I want something better!");
        choice3.setText("Your mother can cook for the legions, I will not!");
        choice4.setText("Try to run away");
    }
    public void Bribe(){
        position = "Bribe";
        areaForMainText.setText("Hah you have no gold, you are coming with me!");
        choice1.setText("Attack him");
        choice2.setText("Laugh at him");
        choice3.setText("Ask him what he wants");
        choice4.setText("Try to run away");
    }
    //-------------------------------------------------------------------------------------------------
    // actions away
    //-------------------------------------------------------------------------------------------------
    public void DoTold() {
        position = "DoTold";
        areaForMainText.setText("You see that another soldier is also digging holes.");
        choice1.setText("Attempt to make small talk");
        choice2.setText("Pay him 2 golden coins to do your work");
        choice3.setText("Go back to the tent");
        choice4.setText("Slack off");
    }

    public void Refuse() {
        position = "Refuse";
        areaForMainText.setText("That is the end of you boy!" +
                "\nThe guards kill you and they make an example of you for others to see " +
                "\nwhat happens when someone refuses to do his job.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("EXIT");
        playerHP=playerHP-80;
        hpLabelState.setText(""+playerHP);
        playerStamina=playerStamina-100;
        staminaLabelState.setText(""+playerStamina);
    }

    public void Spit(){
        position = "stealHeavy";
        areaForMainText.setText("The seller went to get something in the back room but he heard the noise, you are caught!");
        choice1.setText("Please do not report me, I will pay you double");
        choice2.setText("Kill the seller");
        choice3.setText("Run away");
        choice4.setText("Surrender");
    }
    public void Bribe2(){
        position = "stealSoft";
        areaForMainText.setText("The seller went to get something in the back room, you managed to steal the armor.");
        choice1.setText("Go to the camp");
        choice2.setText("Go home");
        choice3.setText("Kill the seller and steal everything you can");
        choice4.setText("Try to steal the heavy armor as well");
    }

    //-------------------------------------------------------------------------------------------------
    // actions after go with him
    public void Heavy() {
        position = "Heavy";
        areaForMainText.setText("Good choice young legionnaire, now hurry up to the port the ship is waiting.");
        choice1.setText("Go to the port");
        choice2.setText("Go slowly");
        choice3.setText("Try to go home");
        choice4.setText("Thank the seller");
        playerStamina=playerStamina-30;
        staminaLabelState.setText(""+playerStamina);
        playerGold=playerGold-5;
        goldLabelState.setText(""+playerGold);
    }

    public void Soft() {
        position = "Soft";
        areaForMainText.setText("Well you guys are walking to France!");
        choice1.setText("Go join the other legionnaires");
        choice2.setText("Try to replace it for the heavy armor");
        choice3.setText("Try to go home");
        choice4.setText("Insult the seller");
        playerStamina=playerStamina-10;
        staminaLabelState.setText(""+playerStamina);
        playerGold=playerGold-2;
        goldLabelState.setText(""+playerGold);
    }

    public void stealHeavy(){
        position = "stealHeavy";
        areaForMainText.setText("The seller went to get something in the back room but he heard the noise, you are caught!");
        choice1.setText("Please do not report me, I will pay you double");
        choice2.setText("Kill the seller");
        choice3.setText("Run away");
        choice4.setText("Surrender");
    }
    public void stealSoft(){
        position = "stealSoft";
        areaForMainText.setText("The seller went to get something in the back room, you managed to steal the armor.");
        choice1.setText("Go to the camp");
        choice2.setText("Go home");
        choice3.setText("Kill the seller and steal everything you can");
        choice4.setText("Try to steal the heavy armor as well");
    }
    //-------------------------------------------------------------------------------------------------
    //Exit ACTION
    public void Exit() {
        position = "Exit";
        System.exit(0);

    }
    //-------------------------------------------------------------------------------------------------
    // this handles the choices of the player
    public class PlayerChoiceHandler implements  ActionListener{
        public void actionPerformed(ActionEvent event ){
            String userChoice = event.getActionCommand();

            switch(position){
                case "romeHome":
                    switch (userChoice){
                        case "y1": GoWithHim(); break;
                        case "y2": Away(); break;
                        case "y3": Plead(); break;
                        case "y4": Bribe(); break;
                    }
                    break;
                case "GoWithHim":
                    switch (userChoice){
                        case "y1": Heavy(); break;
                        case "y2": Soft(); break;
                        case "y3": stealHeavy(); break;
                        case "y4": stealSoft(); break;
                    }
                    break;
                case "Away":
                    switch (userChoice){
                        case "y1": DoTold(); break;
                        case "y2": Refuse(); break;
                        case "y3": Spit(); break;
                        case "y4": Bribe2(); break;
                    }
                    break;
                case "Refuse":
                    switch (userChoice){
                        case "y4": Exit();break;

                    }
                    break;
            }
        }
    }
}
