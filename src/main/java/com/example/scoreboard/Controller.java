package com.example.scoreboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import java.io.File;

public class Controller {
    public Button toggle2;
    public Button settingsBtn;
    public int counter = 0;
    public Scoreboard child;
    public SettingsView settings;
    public int[] sizes;
    public Label lblScore1;
    public Button btn1HomeAdd;
    public Button btn1HomeRem;
    public Label lblScore2;
    public Button btn1AwayAdd;
    public Button btn1AwayRem;
    public Label lblScore3;
    public Button btn2HomeAdd;
    public Button btn2HomeRem;
    public Label lblScore4;
    public Button btn2AwayAdd;
    public Button btn2AwayRem;
    public Button zero2;
    public Button zero1;
    public VBox vbox;
    private int[] scores = {0, 0, 0, 0};
    public SettingsManager settingsManager;
    private boolean dvaZapasy = false;

    public void initialize() throws IOException {
        loadSizes();

        showScoreboard("scoreboard1View.fxml");
    }

    public void openSettings() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settingsView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        settings = fxmlLoader.getController();
        settings.setParentController(this);
        stage.setTitle("Settings!");
        stage.setScene(scene);
        stage.show();
    }

    public void sizeChange(int index, int newSize){
        sizes[index] = newSize;
        child.resize(sizes);
    }

    private void loadSizes() throws IOException {
        //String userHome = System.getProperty("user.home");
        //String settingsFilePath = userHome + File.separator + "AppData" + File.separator + "Local" + File.separator + "Scoreboard" + File.separator + "settings.txt";
        String settingsFilePath = "src/main/java/com/example/scoreboard/settings.txt";
        settingsManager = new SettingsManager(settingsFilePath);
        String[] sizeKeys = settingsManager.loadKeys();
        sizes = new int[sizeKeys.length];
        for (int i = 0; i < sizes.length; i++){
            sizes[i] = settingsManager.getSetting(sizeKeys[i]);
        }
    }

    private void updateScores(){
        Label[] labels = {lblScore1,lblScore2,lblScore3,lblScore4};
        for (int i = 0; i < labels.length; i++){
            labels[i].setText(String.valueOf(scores[i]));
        }
        child.setScores(scores);
    }

    public void saveSettings() throws IOException {
        String userHome = System.getProperty("user.home");
        String settingsFilePath = userHome + File.separator + "AppData" + File.separator + "Local" + File.separator + "Scoreboard" + File.separator + "settings.txt";
        settingsManager.saveSettings(sizes, settingsFilePath);
    }

    public void toggle(ActionEvent actionEvent) throws IOException {
        child.exit();
        if (dvaZapasy){
            showScoreboard("scoreboard1View.fxml");
//            vbox.setVisible(false);
//            vbox.setManaged(false);
//            vbox.setMaxHeight(195);
//            vbox.setPrefHeight(195);
        }
        else {
            showScoreboard("scoreboard2View.fxml");
//            vbox.setVisible(true);
//            vbox.setManaged(true);
//            vbox.setMaxHeight(345);
        }
        dvaZapasy = !dvaZapasy;
        updateScores();
        sizeChange(0, sizes[0]);
    }

    public void Add1(ActionEvent actionEvent) {
        scores[0]++;
        updateScores();
    }
    public void Rem1(ActionEvent actionEvent) {
        if (scores[0] > 0){
            scores[0]--;
            updateScores();
        }
    }
    public void Add2(ActionEvent actionEvent) {
        scores[1]++;
        updateScores();
    }
    public void Rem2(ActionEvent actionEvent) {
        if (scores[1] > 0){
            scores[1]--;
            updateScores();
        }
    }
    public void Add3(ActionEvent actionEvent) {
        scores[2]++;
        updateScores();
    }
    public void Rem3(ActionEvent actionEvent) {
        if (scores[2] > 0){
            scores[2]--;
            updateScores();
        }
    }
    public void Add4(ActionEvent actionEvent) {
        scores[3]++;
        updateScores();
    }
    public void Rem4(ActionEvent actionEvent) {
        if (scores[3] > 0){
            scores[3]--;
            updateScores();
        }
    }

    private void showScoreboard(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        child = fxmlLoader.getController();
        child.setParentController(this, stage);
        stage.setTitle("Scoreboard");
        stage.setScene(scene);
        stage.show();
        child.resize(sizes);
    }

    public void Zero2(ActionEvent actionEvent) {
        scores[2] = 0;
        scores[3] = 0;
        updateScores();
    }

    public void Zero1(ActionEvent actionEvent) {
        scores[0] = 0;
        scores[1] = 0;
        updateScores();
    }
}