package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class U7G5GroundEventStatus {

    @FXML
    private Label confirmationLabel;

    @FXML
    private ComboBox<String> eventCB;

    @FXML
    private TableColumn<GroundStatus, String> eventNameTC;

    @FXML
    private TableView<GroundStatus> eventStatusTV;

    @FXML
    private TableColumn<GroundStatus, String> progressTC;

    @FXML
    private TextField progressTF;

    private final ObservableList<GroundStatus> groundStatusList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        eventNameTC.setCellValueFactory(new PropertyValueFactory<>("area"));
        progressTC.setCellValueFactory(new PropertyValueFactory<>("staffCount"));

        eventStatusTV.setItems(groundStatusList);

        eventCB.setItems(FXCollections.observableArrayList("Main Entrance", "Stage Area", "Food Court", "Parking Lot", "Exhibition Hall"));
    }

    @FXML
    void updateStatusONA(ActionEvent event) {
        String selectedEvent = eventCB.getValue();
        String progress = progressTF.getText();

        if (selectedEvent != null && !progress.isEmpty()) {
            try {
                int staffCount = Integer.parseInt(progress);
                groundStatusList.add(new GroundStatus(selectedEvent, staffCount));
                confirmationLabel.setText("Added " + selectedEvent + " with progress: " + progress);
                progressTF.clear();
            } catch (NumberFormatException e) {
                confirmationLabel.setText("Please enter a valid number for progress.");
            }
        } else {
            confirmationLabel.setText("Please select an event and enter progress.");
        }
    }
}