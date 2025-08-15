package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class U7G7SecurityNotes {

    @FXML
    private ComboBox<String> securityLevelComboBox;

    @FXML
    private ComboBox<String> securityAssignmentComboBox;

    @FXML
    private TableView<SecurityNote> securityRequestsTable;

    @FXML
    private TableColumn<SecurityNote, String> noteColumn;

    @FXML
    private TableColumn<SecurityNote, String> priorityColumn;

    private ObservableList<SecurityNote> securityRequests = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        securityLevelComboBox.getItems().addAll("High Security", "Medium Security", "Low Security");
        securityAssignmentComboBox.getItems().addAll("Main Stage", "Stage 1", "Stage 2", "Sound Booth");

        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));

        securityRequestsTable.setItems(securityRequests);
    }

    @FXML
    void sendToSecurityTeamONA(ActionEvent event) {
        String securityLevel = securityLevelComboBox.getValue();
        String securityAssignment = securityAssignmentComboBox.getValue();

        if (securityLevel != null && securityAssignment != null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String note = "Request for " + securityAssignment;

            SecurityNote securityNote = new SecurityNote(timestamp, "System", note, securityLevel);
            securityRequests.add(securityNote);
        }
    }
}