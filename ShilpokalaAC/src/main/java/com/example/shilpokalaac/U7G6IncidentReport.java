package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class U7G6IncidentReport {

    @FXML
    private TableView<IncidentReport> incidentTV;

    @FXML
    private TableColumn<IncidentReport, String> reportIdTC;

    @FXML
    private TableColumn<IncidentReport, String> eventTC;

    @FXML
    private TableColumn<IncidentReport, String> statusTC;

    @FXML
    private ComboBox<String> reportCB;

    @FXML
    private ComboBox<String> updateStatusCB;

    @FXML
    private ComboBox<String> eventCB;

    @FXML
    private Label confirmationLabel;

    private final ObservableList<IncidentReport> incidentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        reportIdTC.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        eventTC.setCellValueFactory(new PropertyValueFactory<>("location"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadSampleData();
        incidentTV.setItems(incidentList);

        reportCB.setItems(FXCollections.observableArrayList("Security", "Medical", "Technical", "Lost Item"));
        updateStatusCB.setItems(FXCollections.observableArrayList("Open", "In Progress", "Resolved", "Closed"));
        eventCB.setItems(FXCollections.observableArrayList("Main Gate", "Stage 1", "Stage 2", "Sound Booth"));
    }

    private void loadSampleData() {
        incidentList.addAll(
                new IncidentReport("Security", "Main Gate", "3:15 PM", "Unauthorized entry attempt.", "Resolved"),
                new IncidentReport("Medical", "Stage Right", "3:25 PM", "Guest fainted, medical team responded.", "Resolved"),
                new IncidentReport("Technical", "Sound Booth", "3:40 PM", "Audio feedback issue on main speakers.", "Open"),
                new IncidentReport("Lost Item", "Merch Booth", "3:50 PM", "Guest reported a lost wallet.", "Open")
        );
    }

    @FXML
    void assinForResolutionONA(ActionEvent event) {
        IncidentReport selectedItem = incidentTV.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            incidentList.remove(selectedItem);
            confirmationLabel.setText("Report " + selectedItem.getIncidentType() + " assigned for resolution and removed");
        } else {
            confirmationLabel.setText("Please select a report from the table.");
        }
    }

    @FXML
    void updateStatusONA(ActionEvent event) {
        String selectedStatus = updateStatusCB.getValue();
        IncidentReport selectedItem = incidentTV.getSelectionModel().getSelectedItem();

        if (selectedStatus != null && selectedItem != null) {
            selectedItem.setStatus(selectedStatus);
            incidentTV.refresh();
            confirmationLabel.setText("Status updated to: " + selectedStatus);
        } else {
            confirmationLabel.setText("Please select a report and a status to update.");
        }
    }

    @FXML
    void addReportONA(ActionEvent event) {
        String incidentType = reportCB.getValue();
        String location = eventCB.getValue();
        String status = updateStatusCB.getValue();

        if (incidentType != null && location != null && status != null) {
            // Current time as string
            String time = java.time.LocalTime.now().toString().substring(0, 5);
            // Default description
            String description = "New incident report";

            IncidentReport newReport = new IncidentReport(incidentType, location, time, description, status);
            incidentList.add(newReport);
            confirmationLabel.setText("New " + incidentType + " report added for " + location);
        } else {
            confirmationLabel.setText("Please select report type, event location and status.");
        }
    }
}