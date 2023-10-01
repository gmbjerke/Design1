package com.griffinbjerke.model;

import javafx.beans.property.*;

import java.io.Serializable;

public class Character implements Serializable {
    private StringProperty characterName = new SimpleStringProperty("");
    private StringProperty playerName = new SimpleStringProperty("");
    private StringProperty characterClass = new SimpleStringProperty("");
    private IntegerProperty hp = new SimpleIntegerProperty(0);
    private IntegerProperty tempHp = new SimpleIntegerProperty(0);
    private IntegerProperty initiative = new SimpleIntegerProperty(0);
    private StringProperty attacks = new SimpleStringProperty("");
    private StringProperty spells = new SimpleStringProperty("");
    private StringProperty inventory = new SimpleStringProperty("");
    private StringProperty notes = new SimpleStringProperty("");

    // Constructors
    public Character() {
        // Default constructor
    }

    // Getter and Setter methods for each attribute
    public String getCharacterName() {
        return characterName.get();
    }

    public StringProperty characterNameProperty() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName.set(characterName);
    }

    public String getPlayerName() {
        return playerName.get();
    }

    public StringProperty playerNameProperty() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName.set(playerName);
    }

    public String getCharacterClass() {
        return characterClass.get();
    }

    public StringProperty characterClassProperty() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass.set(characterClass);
    }

    public int getHp() {
        return hp.get();
    }

    public IntegerProperty hpProperty() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp.set(hp);
    }

    public int getTempHp() {
        return tempHp.get();
    }

    public IntegerProperty tempHpProperty() {
        return tempHp;
    }

    public void setTempHp(int tempHp) {
        this.tempHp.set(tempHp);
    }

    public int getInitiative() {
        return initiative.get();
    }

    public IntegerProperty initiativeProperty() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative.set(initiative);
    }

    public String getAttacks() {
        return attacks.get();
    }

    public StringProperty attacksProperty() {
        return attacks;
    }

    public void setAttacks(String attacks) {
        this.attacks.set(attacks);
    }

    public String getSpells() {
        return spells.get();
    }

    public StringProperty spellsProperty() {
        return spells;
    }

    public void setSpells(String spells) {
        this.spells.set(spells);
    }

    public String getInventory() {
        return inventory.get();
    }

    public StringProperty inventoryProperty() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory.set(inventory);
    }

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterName='" + characterName.get() + '\'' +
                ", playerName='" + playerName.get() + '\'' +
                ", characterClass='" + characterClass.get() + '\'' +
                ", hp=" + hp.get() +
                ", tempHp=" + tempHp.get() +
                ", initiative=" + initiative.get() +
                ", attacks='" + attacks.get() + '\'' +
                ", spells='" + spells.get() + '\'' +
                ", inventory='" + inventory.get() + '\'' +
                ", notes='" + notes.get() + '\'' +
                '}';
    }

    // Other utility methods can be added as needed
}
