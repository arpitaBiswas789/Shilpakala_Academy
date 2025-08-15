package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class U8G2FinancialReports {

    @FXML
    private ComboBox<String> reportPeriodCB;

    @FXML
    private Label notificationLabel;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField revenueTF;

    @FXML
    private TextField expensesTF;

    @FXML
    private TableView<FinancialReport> reportsTV;

    @FXML
    private TableColumn<FinancialReport, String> reportIdTC;

    @FXML
    private TableColumn<FinancialReport, String> reportPeriodTC;

    @FXML
    private TableColumn<FinancialReport, Double> totalRevenuetTC;

    @FXML
    private TableColumn<FinancialReport, Double> totalExpensesTC;

    @FXML
    private TableColumn<FinancialReport, Double> netProfitTC;

    private ObservableList<FinancialReport> availableReports;
    private int reportCounter = 1;

    @FXML
    public void initialize() {
        loadReportPeriods();
        setupTableColumns();
        availableReports = FXCollections.observableArrayList();
        reportsTV.setItems(availableReports);
    }

    private void setupTableColumns() {
        reportIdTC.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportPeriodTC.setCellValueFactory(new PropertyValueFactory<>("reportPeriod"));
        totalRevenuetTC.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));
        totalExpensesTC.setCellValueFactory(new PropertyValueFactory<>("totalExpenses"));
        netProfitTC.setCellValueFactory(new PropertyValueFactory<>("netProfit"));
    }

    private void loadReportPeriods() {
        ObservableList<String> periods = FXCollections.observableArrayList(
                "July 2024",
                "Q3 2024",
                "August 2024",
                "Year to Date 2024"
        );
        reportPeriodCB.setItems(periods);
    }

    @FXML
    private void addReportONA() {
        if (reportPeriodCB.getValue() != null) {
            try {
                String reportId = "REP-2024-" + String.format("%02d", reportCounter++);
                String reportPeriod = reportPeriodCB.getValue();

                double revenue = Double.parseDouble(revenueTF.getText());
                double expenses = Double.parseDouble(expensesTF.getText());

                FinancialReport newReport = new FinancialReport(reportId, reportPeriod, revenue, expenses);
                availableReports.add(newReport);

                notificationLabel.setText("Financial report added for: " + reportPeriod);

                // Clear input fields after adding
                revenueTF.clear();
                expensesTF.clear();
            } catch (NumberFormatException e) {
                notificationLabel.setText("Please enter valid numbers for revenue and expenses.");
            }
        } else {
            notificationLabel.setText("Please select a report period first.");
        }
    }

    @FXML
    private void downloadpdfONA() {
        FinancialReport selectedReport = reportsTV.getSelectionModel().getSelectedItem();
        if (selectedReport != null) {
            notificationLabel.setText("Downloaded report: " + selectedReport.getReportId());
            System.out.println("Downloaded report: " + selectedReport.getReportId());
        } else {
            notificationLabel.setText("Please select a report from the table first.");
        }
    }

    @FXML
    private void emailONA() {
        FinancialReport selectedReport = reportsTV.getSelectionModel().getSelectedItem();
        String email = emailTF.getText();

        if (selectedReport != null && email != null && !email.isEmpty()) {
            notificationLabel.setText("Emailed report: " + selectedReport.getReportId() + " to " + email);
            System.out.println("Emailed to " + email + ": " + selectedReport.getReportId());
        } else if (selectedReport == null) {
            notificationLabel.setText("Please select a report from the table first.");
        } else {
            notificationLabel.setText("Please enter an email address.");
        }
    }
}