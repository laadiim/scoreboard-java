package com.example.scoreboard;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Scoreboard2 implements Scoreboard{
    public Label home1;
    public Label separator1;
    public Label away1;
    public Label home2;
    public Label separator2;
    public Label away2;
    protected Controller controller;
    private Stage stage;

    public void setParentController(Controller helloController, Stage stage) {
        this.controller = helloController;
        this.stage = stage;
    }

    public void resize(int[] sizes) {
        Label[] labels = {home1, away1, home2, away2};
        for (int i = 0; i < labels.length; i++){
            if (labels[i].getText().length() == 1){
                labels[i].setFont(new Font(sizes[3]));
            }
            else{
                labels[i].setFont(new Font(sizes[4]));
            }
        }
        separator1.setFont(new Font(sizes[5]));
        separator2.setFont(new Font(sizes[5]));
    }

    public void setScores(int[] scores) {
        Label[] labels = {home1, away1, home2, away2};
        for (int i = 0; i < labels.length; i++){
            labels[i].setText(String.valueOf(scores[i]));
        }
        resize(controller.sizes);
    }

    public void exit() {
        stage.close();
    }
}
