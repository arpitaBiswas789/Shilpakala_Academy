package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class U8G1ProcessPayments {

    @FXML
    private TableView<Payment> paymentsTV;

    @FXML
    private TableColumn<Payment, String> paymentIdTC;

    @FXML
    private TableColumn<Payment, String> vendorNameTC;

    @FXML
    private TableColumn<Payment, Double> amountTC;

    @FXML
    private TableColumn<Payment, String> statusTC;

    @FXML
    private TextField newPaymentIdF;

    @FXML
    private TextField newVendorNameFi;

    @FXML
    private TextField newAmountF;

    @FXML
    private Label notificationLabel;

    private ObservableList<Payment> pendingPayments;

    @FXML
    public void initialize() {
        paymentIdTC.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        vendorNameTC.setCellValueFactory(new PropertyValueFactory<>("vendorName"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadPendingRequests();
    }

    private void loadPendingRequests() {
        pendingPayments = FXCollections.observableArrayList();
        paymentsTV.setItems(pendingPayments);
    }

    @FXML
    private void addPaymentONA() {
        try {
            String paymentId = newPaymentIdF.getText().trim();
            String vendorName = newVendorNameFi.getText().trim();
            String amountText = newAmountF.getText().trim();

            if (paymentId.isEmpty() || vendorName.isEmpty() || amountText.isEmpty()) {
                notificationLabel.setText("Please fill in all fields");
                return;
            }

            double amount = Double.parseDouble(amountText);
            LocalDate today = LocalDate.now();
            String paymentDate = today.format(DateTimeFormatter.ISO_DATE);

            Payment newPayment = new Payment(paymentId, vendorName, amount, paymentDate, "Pending");
            pendingPayments.add(newPayment);

            newPaymentIdF.clear();
            newVendorNameFi.clear();
            newAmountF.clear();

            notificationLabel.setText("Payment request added: " + paymentId);
        } catch (NumberFormatException e) {
            notificationLabel.setText("Please enter a valid amount");
        }
    }

    @FXML
    private void markCompleteIONA() {
        Payment selectedPayment = paymentsTV.getSelectionModel().getSelectedItem();
        if (selectedPayment != null) {
            pendingPayments.remove(selectedPayment);
            notificationLabel.setText("Payment marked as complete: " + selectedPayment.getPaymentId() + " - " + selectedPayment.getVendorName());
        } else {
            notificationLabel.setText("Please select a payment request first.");
        }
    }
}