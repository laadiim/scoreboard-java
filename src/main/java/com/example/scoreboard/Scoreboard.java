package com.example.scoreboard;

import javafx.stage.Stage;

public interface Scoreboard {

    void setParentController(Controller helloController, Stage stage);
    void resize(int[] sizes);
    void setScores(int[] scores);
    void exit();
}
