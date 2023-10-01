package com.griffinbjerke.util;

import com.griffinbjerke.model.Character;

import java.io.*;

public class FileHandler {

    public static void saveCharacter(Character character, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(character);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Character loadCharacter(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Character) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}