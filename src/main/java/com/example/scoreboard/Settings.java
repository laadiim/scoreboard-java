package com.example.scoreboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Settings {
    private String[] keys;
    private int[] values;

    public Settings(File file) throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        String line = "";
        while (reader.hasNextLine()){
            line += reader.nextLine();
        }
        if (line.isEmpty()){
            keys = new String[]{"size1", "size2", "size3", "size4", "size5", "size6"};
            values = new int[]{100,100,100,100,100,100};
        }
        String[] lineArr = line.split(";");
        //System.out.println(line);
        keys = new String[lineArr.length];
        values = new int[lineArr.length];
        for (int i = 0; i < lineArr.length; i++){
            keys[i] = lineArr[i].split("=")[0];
            values[i] = Integer.parseInt(lineArr[i].split("=")[1]);
        }
    }

    public int[] getValues() {
        return values;
    }

    public String[] getKeys() {
        return keys;
    }
    public int getValue(String key){
        for (int i = 0; i < keys.length; i++){
            if (Objects.equals(keys[i], key)){
                return values[i];
            }
        }
        return -1;
    }
    public void setValue(String key, int value){
        for (int i = 0; i < keys.length; i++){
            if (Objects.equals(keys[i], key)){
                values[i] = value;
            }
        }
    }
    public void saveSettings(String filepath) throws IOException {
        String line = "";
        for (int i = 0; i < keys.length; i++){
            line = line + keys[i] + "=" + String.valueOf(values[i]) + ";";
            if (i != keys.length -1){
                line += "\n";
            }
        }
        FileWriter myWriter = new FileWriter(filepath);
        myWriter.write(line);
        myWriter.close();
    }
}
