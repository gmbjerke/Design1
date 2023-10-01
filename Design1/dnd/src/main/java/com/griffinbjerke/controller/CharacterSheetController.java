package com.griffinbjerke.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.griffinbjerke.model.Character;
import com.griffinbjerke.util.FileHandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterSheetController {

    @FXML
    private TextField characterNameField;

    @FXML
    private TextField playerNameField;

    @FXML
    private ComboBox<String> classComboBox;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField hpField;

    @FXML
    private TextField tempHpField;

    @FXML
    private TextField initiativeField;

    @FXML
    private TextArea attacksArea;

    @FXML
    private TextArea spellsArea;

    @FXML
    private TextArea inventoryArea;

    @FXML
    private TextArea notesArea;

    private Character character;

    

    @FXML
    private void initialize() {
        // Load character class options from JSON file
        loadClassOptions();

        // Initialize character model
        character = new Character();

        // Bind UI elements to character model
        characterNameField.textProperty().bindBidirectional(character.characterNameProperty());
        playerNameField.textProperty().bindBidirectional(character.playerNameProperty());
        hpField.textProperty().bindBidirectional(character.hpProperty(), integerStringConverter());
        tempHpField.textProperty().bindBidirectional(character.tempHpProperty(), integerStringConverter());
        initiativeField.textProperty().bindBidirectional(character.initiativeProperty(), integerStringConverter());
        attacksArea.textProperty().bindBidirectional(character.attacksProperty());
        spellsArea.textProperty().bindBidirectional(character.spellsProperty());
        inventoryArea.textProperty().bindBidirectional(character.inventoryProperty());
        notesArea.textProperty().bindBidirectional(character.notesProperty());
        classComboBox.valueProperty().bindBidirectional(character.characterClassProperty());
    }

    @FXML
    private void saveCharacter() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Character Files", "*.char"));
        Stage stage = (Stage) gridPane.getScene().getWindow();
        java.io.File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            String filePath = file.getAbsolutePath();
            FileHandler.saveCharacter(character, filePath);
            showAlert("Character Saved", "Character saved successfully to " + filePath, AlertType.INFORMATION);
        }
    }

    @FXML
    private void loadCharacter() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Character Files", "*.char"));
        Stage stage = (Stage) gridPane.getScene().getWindow();
        java.io.File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            String filePath = file.getAbsolutePath();
            Character loadedCharacter = FileHandler.loadCharacter(filePath);

            if (loadedCharacter != null) {
                character.copyFrom(loadedCharacter);
                showAlert("Character Loaded", "Character loaded successfully from " + filePath, AlertType.INFORMATION);
            } else {
                showAlert("Error", "Failed to load character from " + filePath, AlertType.ERROR);
            }
        }
    }

    private void showAlert(String title, String content, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void loadClassOptions() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray classArray = (JSONArray) parser.parse(new FileReader("src/main/resources/config/character_options.json"));

            for (Object obj : classArray) {
                String className = (String) obj;
                classComboBox.getItems().add(className);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private StringConverter<Integer> integerStringConverter() {
        return new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object.toString();
            }

            @Override
            public Integer fromString(String string) {
                try {
                    return Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        };
    }
}