package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class U7G2ResourceManagement {

    @FXML
    private ComboBox<String> eventCB;

    @FXML
    private ComboBox<String> resourceCB;

    @FXML
    private Label availabilityLabel;

    @FXML
    private Label confirmationLabel;

    @FXML
    private TableView<Resource> resourceTableView;

    @FXML
    private TableColumn<Resource, String> eventTC;

    @FXML
    private TableColumn<Resource, String> resourceTC;

    private final ObservableList<Resource> resourceList = FXCollections.observableArrayList(
        new Resource("Projector", 5, "Available", null),
        new Resource("Chairs", 100, "Available", null),
        new Resource("Tables", 20, "Available", null),
        new Resource("Sound System", 2, "Available", null)
    );

    private final ObservableList<Resource> allocationList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setupComboBoxes();
        setupTableView();
    }

    private void setupComboBoxes() {
        eventCB.getItems().addAll("Conference 2024", "Music Festival", "Corporate Meeting", "Wedding Reception");

        for (Resource resource : resourceList) {
            resourceCB.getItems().add(resource.getResourceName());
        }
    }

    private void setupTableView() {
        eventTC.setCellValueFactory(new PropertyValueFactory<>("assignedTo"));
        resourceTC.setCellValueFactory(new PropertyValueFactory<>("resourceName"));
        resourceTableView.setItems(allocationList);
    }

    @FXML
    private void allocateResourceONA() {
        String selectedEvent = eventCB.getValue();
        String selectedResource = resourceCB.getValue();

        if (selectedEvent != null && selectedResource != null) {
            Resource allocation = new Resource(selectedResource, 1, "Allocated", selectedEvent);
            allocationList.add(allocation);
            // Force the table to update with the modified list
            resourceTableView.setItems(FXCollections.observableArrayList(allocationList));
            confirmationLabel.setText("Resource allocated successfully!");
            availabilityLabel.setText("Status: Allocated");
            eventCB.setValue(null);
            resourceCB.setValue(null);
        } else {
            confirmationLabel.setText("Please select both event and resource.");
        }
    }
}