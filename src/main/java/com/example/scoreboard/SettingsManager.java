package com.example.scoreboard;

import java.io.File;
import java.io.IOException;

public class SettingsManager {
    private File file;
    private Settings settings;

    public SettingsManager(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.exists()){
            f.createNewFile();
        }
        file = f;
        settings = new Settings(file);
    }

    public String[] loadKeys() throws IOException {
        return settings.getKeys();
    }

    public void saveSettings(int[] toSave, String filepath) throws IOException {
        String[] keys = settings.getKeys();
        for (int i = 0; i < keys.length; i++){
            settings.setValue(keys[i], toSave[i]);
        }
        settings.saveSettings(filepath);
    }

    public int getSetting(String key) {
        return settings.getValue(key);
    }

    public void setSetting(String key, String value) {
        settings.setValue(key, Integer.parseInt(value));
    }
}