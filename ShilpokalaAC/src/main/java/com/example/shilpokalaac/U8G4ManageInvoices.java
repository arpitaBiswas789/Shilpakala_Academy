package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashMap;
import java.util.Map;

public class U8G4ManageInvoices {
    @FXML
    private TextField invoiceDetailsTF;

    @FXML
    private TextField amountTF;

    @FXML
    private ComboBox<String> pdfFilesCB;

    @FXML
    private Label confirmationLabel;

    @FXML
    private TableView<Invoice> invoicesTable;

    @FXML
    private TableColumn<Invoice, String> vendorNameColumn;

    @FXML
    private TableColumn<Invoice, Double> amountDueColumn;

    private ObservableList<Invoice> invoices;
    private Map<String, InvoicePreset> pdfPresets;

    @FXML
    public void initialize() {
        setupTable();
        setupPdfPresets();
        invoices = FXCollections.observableArrayList();
        invoicesTable.setItems(invoices);
    }

    private void setupTable() {
        vendorNameColumn.setCellValueFactory(new PropertyValueFactory<>("vendorName"));
        amountDueColumn.setCellValueFactory(new PropertyValueFactory<>("amountDue"));
    }

    private void setupPdfPresets() {
        pdfPresets = new HashMap<>();
        pdfPresets.put("invoice_sound_systems.pdf", new InvoicePreset("Sound Systems Inc.", 1500.00));
        pdfPresets.put("invoice_lighting_fx.pdf", new InvoicePreset("Lighting FX Co.", 900.50));
        pdfPresets.put("invoice_staging.pdf", new InvoicePreset("Staging Solutions", 2800.75));

        pdfFilesCB.getItems().addAll(pdfPresets.keySet());

        pdfFilesCB.setOnAction(event -> {
            String selectedPdf = pdfFilesCB.getValue();
            if (selectedPdf != null && pdfPresets.containsKey(selectedPdf)) {
                InvoicePreset preset = pdfPresets.get(selectedPdf);
                amountTF.setText(String.valueOf(preset.getAmount()));
                invoiceDetailsTF.setText("Invoice for services - " + preset.getVendorName());
                confirmationLabel.setText("PDF selected: " + selectedPdf);
            }
        });
    }

    @FXML
    private void savepdfONA() {
        if (!invoiceDetailsTF.getText().isEmpty() && !amountTF.getText().isEmpty()) {
            try {
                double amount = Double.parseDouble(amountTF.getText());
                String vendorName = getVendorNameFromDetails(invoiceDetailsTF.getText());
                String pdfName = pdfFilesCB.getValue() != null ? pdfFilesCB.getValue() : "No PDF";

                Invoice newInvoice = new Invoice("", vendorName, amount, "", "");
                invoices.add(newInvoice);

                invoiceDetailsTF.clear();
                amountTF.clear();
                pdfFilesCB.setValue(null);

                confirmationLabel.setText("Invoice saved for vendor: " + vendorName);
            } catch (NumberFormatException e) {
                confirmationLabel.setText("Please enter a valid amount.");
            }
        } else {
            confirmationLabel.setText("Please complete all required fields.");
        }
    }

    private String getVendorNameFromDetails(String details) {
        if (details.contains("- ")) {
            return details.substring(details.lastIndexOf("- ") + 2);
        }
        return "Unknown Vendor";
    }

    private static class InvoicePreset {
        private final String vendorName;
        private final double amount;

        public InvoicePreset(String vendorName, double amount) {
            this.vendorName = vendorName;
            this.amount = amount;
        }

        public String getVendorName() { return vendorName; }
        public double getAmount() { return amount; }
    }
}