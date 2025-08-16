package com.example.project_by_pushon;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class U7G4EventChecklist {

    @FXML
    private TableView<CheckListItem> checklistTV;

    @FXML
    private TableColumn<CheckListItem, String> idTC;

    @FXML
    private TableColumn<CheckListItem, String> eventTC;

    @FXML
    private TableColumn<CheckListItem, String> taskTC;

    @FXML
    private TableColumn<CheckListItem, String> statusTC;

    @FXML
    private TableColumn<CheckListItem, Void> deleteTC;

    @FXML
    private TextField newTF;

    @FXML
    private ComboBox<String> eventComboBox;

    @FXML
    private ComboBox<String> statusCB;

    @FXML
    private Label confirmationLabel;

    private final ObservableList<CheckListItem> checklist = FXCollections.observableArrayList();
    private final ObservableList<String> events = FXCollections.observableArrayList(
            "Annual Conference", "Team Building", "Product Launch", "Training Workshop", "Networking Event"
    );
    private final ObservableList<String> statuses = FXCollections.observableArrayList(
            "Pending", "In Progress", "Completed"
    );

    @FXML
    public void initialize() {
        idTC.setCellValueFactory(cellData ->
            new SimpleStringProperty(String.valueOf(checklist.indexOf(cellData.getValue()) + 1)));

        eventTC.setCellValueFactory(new PropertyValueFactory<>("event"));
        taskTC.setCellValueFactory(new PropertyValueFactory<>("task"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        deleteTC.setCellFactory(param -> new TableCell<>() {
            private final Button deleteButton = new Button("Delete");

            {
                deleteButton.setOnAction(event -> {
                    CheckListItem item = getTableRow().getItem();
                    if (item != null) {
                        checklist.remove(item);
                        confirmationLabel.setText("Task deleted successfully!");
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });

        eventComboBox.setItems(events);
        eventComboBox.getSelectionModel().selectFirst();

        statusCB.setItems(statuses);
        statusCB.getSelectionModel().selectFirst();

        checklistTV.setItems(checklist);
    }

    @FXML
    private void addTaskONA() {
        String newTask = newTF.getText();
        String selectedEvent = eventComboBox.getValue();
        String selectedStatus = statusCB.getValue();

        if (!newTask.isEmpty() && selectedEvent != null && selectedStatus != null) {
            checklist.add(new CheckListItem(newTask, selectedStatus, LocalDate.now(), "Unassigned", selectedEvent));
            newTF.clear();
            confirmationLabel.setText("Task added successfully!");
        }
    }
}