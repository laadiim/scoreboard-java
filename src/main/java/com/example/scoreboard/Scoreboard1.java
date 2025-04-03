package com.example.scoreboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Scoreboard1 implements Scoreboard {
    @FXML
    public Label home;
    @FXML
    public Label separator;
    @FXML
    public Label away;

    protected Controller controller;
    private Stage stage;


    public void setParentController(Controller helloController, Stage stage) {
        this.controller = helloController;
        this.stage = stage;
    }

    public void resize(int[] sizes) {
        Label[] labels = {home, away};
        for (int i = 0; i < labels.length; i++){
            if (labels[i].getText().length() == 1){
                labels[i].setFont(new Font(sizes[0]));
            }
            else{
                labels[i].setFont(new Font(sizes[1]));
            }
        }
        separator.setFont(new Font(sizes[2]));
    }

    public void setScores(int[] scores) {
        Label[] labels = {home, away};
        for (int i = 0; i < labels.length; i++){
            labels[i].setText(String.valueOf(scores[i]));
        }
        resize(controller.sizes);
    }

    public void exit(){
        stage.close();
    }
}
