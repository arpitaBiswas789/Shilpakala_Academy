package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class U7G3VendorRequest {

    @FXML
    private TextField vendorNameField;
    @FXML
    private ComboBox<String> serviceTypeCombo;
    @FXML
    private TextField costField;
    @FXML
    private DatePicker requestDatePicker;

    @FXML
    private TableView<VendorRequest> vendorTV;
    @FXML
    private TableColumn<VendorRequest, String> vendorNameTC;
    @FXML
    private TableColumn<VendorRequest, String> requestDetailsTC;
    @FXML
    private TableColumn<VendorRequest, Double> costTC;
    @FXML
    private TableColumn<VendorRequest, LocalDate> dateTC;

    private final ObservableList<VendorRequest> vendorRequestList = FXCollections.observableArrayList();
    private int pendingNotifications = 0;

    @FXML
    public void initialize() {
        vendorNameTC.setCellValueFactory(new PropertyValueFactory<>("vendorName"));
        requestDetailsTC.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        costTC.setCellValueFactory(new PropertyValueFactory<>("cost"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("requestDate"));

        serviceTypeCombo.setItems(FXCollections.observableArrayList(
                "Catering", "Security", "Audio/Visual", "Cleaning", "Transportation", "Decoration"));

        loadSampleData();
        vendorTV.setItems(vendorRequestList);

        requestDatePicker.setValue(LocalDate.now());
    }

    private void loadSampleData() {
        vendorRequestList.add(new VendorRequest("City Catering Co.", "Catering", 5500.00, "Pending", LocalDate.of(2025, 7, 15)));
        vendorRequestList.add(new VendorRequest("SecureEvent Staffing", "Security", 3200.50, "Pending", LocalDate.of(2025, 7, 21)));
        pendingNotifications = 2;
    }

    @FXML
    private void submitRequestONA() {
        try {
            if (vendorNameField.getText().isEmpty() || serviceTypeCombo.getValue() == null || costField.getText().isEmpty()) {
                return;
            }

            double cost = Double.parseDouble(costField.getText());
            if (cost <= 0) {
                return;
            }

            VendorRequest newRequest = new VendorRequest(
                vendorNameField.getText(),
                serviceTypeCombo.getValue(),
                cost,
                "Pending",
                requestDatePicker.getValue()
            );

            vendorRequestList.add(newRequest);
            pendingNotifications++;

            vendorNameField.clear();
            serviceTypeCombo.setValue(null);
            costField.clear();
            requestDatePicker.setValue(LocalDate.now());

        } catch (NumberFormatException e) {
            // Silently handle the exception
        }
    }

    @FXML
    private void approveRequestONA() {
        VendorRequest selectedRequest = vendorTV.getSelectionModel().getSelectedItem();
        if (selectedRequest != null) {
            if ("Pending".equals(selectedRequest.getStatus())) {
                selectedRequest.setStatus("Approved");
                pendingNotifications--;
                vendorRequestList.remove(selectedRequest);
            }
        }
    }

    @FXML
    private void rejectRequest() {
        VendorRequest selectedRequest = vendorTV.getSelectionModel().getSelectedItem();
        if (selectedRequest != null) {
            if ("Pending".equals(selectedRequest.getStatus())) {
                selectedRequest.setStatus("Rejected");
                pendingNotifications--;
                vendorRequestList.remove(selectedRequest);
            }
        }
    }
}