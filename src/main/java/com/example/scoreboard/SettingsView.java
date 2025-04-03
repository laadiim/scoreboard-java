package com.example.scoreboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;

import java.io.IOException;

public class SettingsView {
    public Controller parent;
    public Scoreboard scoreboard;

    @FXML
    private Spinner<Integer> spinner1_1;
    @FXML
    private Spinner<Integer> spinner1_2;
    @FXML
    private Spinner<Integer> spinner2_1;
    @FXML
    private Spinner<Integer> spinner2_2;
    @FXML
    public Spinner<Integer> spinner1_3;
    @FXML
    public Spinner<Integer> spinner2_3;

    public void setParentController(Controller helloController) {
        parent = helloController;
        scoreboard = parent.child;
        spinner1_1.getValueFactory().setValue(parent.sizes[0]);
        spinner1_2.getValueFactory().setValue(parent.sizes[1]);
        spinner1_3.getValueFactory().setValue(parent.sizes[2]);
        spinner2_1.getValueFactory().setValue(parent.sizes[3]);
        spinner2_2.getValueFactory().setValue(parent.sizes[4]);
        spinner2_3.getValueFactory().setValue(parent.sizes[5]);
    }

    public void initialize(){
        spinner1_1.valueProperty().addListener((obs, oldValue, newValue) ->{
            parent.sizeChange(0,newValue);});
        spinner1_2.valueProperty().addListener((obs, oldValue, newValue) ->{
            parent.sizeChange(1,newValue);});
        spinner2_1.valueProperty().addListener((obs, oldValue, newValue) ->{
            parent.sizeChange(3,newValue);});
        spinner2_2.valueProperty().addListener((obs, oldValue, newValue) ->{
            parent.sizeChange(4,newValue);});
        spinner1_3.valueProperty().addListener((obs, oldValue, newValue) ->{
            parent.sizeChange(2,newValue);});
        spinner2_3.valueProperty().addListener((obs, oldValue, newValue) ->{
            parent.sizeChange(5,newValue);});

    }

    public void saveSettings(ActionEvent actionEvent) throws IOException {
        parent.saveSettings();
    }
}
