package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class U7G1ScheduleRehearsal {

    @FXML
    private ComboBox<String> eventCB;

    @FXML
    private ComboBox<String> slotCB;

    @FXML
    private DatePicker rehearsalDP;

    @FXML
    private TableView<Rehearsal> slotsTV;

    @FXML
    private TableColumn<Rehearsal, String> slotTC;

    @FXML
    private TableColumn<Rehearsal, String> availabilityTC;

    @FXML
    private TableColumn<Rehearsal, String> venueTC;

    @FXML
    private TextArea notesArea;

    private final ObservableList<Rehearsal> rehearsalList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setupComboBoxes();
        setupTableView();
    }

    private void setupComboBoxes() {
        eventCB.getItems().addAll("Conference 2024", "Music Festival", "Corporate Meeting", "Wedding Reception");
        slotCB.getItems().addAll("10:00 AM - 12:00 PM", "2:00 PM - 4:00 PM", "6:00 PM - 8:00 PM");
    }

    private void setupTableView() {
        slotTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTime()));
        availabilityTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRehearsalName()));
        venueTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocation()));

        slotsTV.setItems(rehearsalList);
    }

    @FXML
    private void scheduleONA() {
        String selectedEvent = eventCB.getValue();
        String selectedSlot = slotCB.getValue();
        LocalDate selectedDate = rehearsalDP.getValue();
        String notes = notesArea.getText();

        if (selectedEvent != null && selectedSlot != null && selectedDate != null) {
            // Create and add the new rehearsal
            Rehearsal newRehearsal = new Rehearsal(selectedEvent, selectedDate, selectedSlot, "Main Venue");
            rehearsalList.add(newRehearsal);
            System.out.println("Rehearsal scheduled for: " + selectedEvent + " on " + selectedDate + " at " + selectedSlot);
        }
    }
}