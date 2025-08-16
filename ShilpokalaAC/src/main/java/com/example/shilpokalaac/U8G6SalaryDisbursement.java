package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class U8G6SalaryDisbursement {

    @FXML
    private Button addPayrollBtn;

    @FXML
    private TableView<SalaryDisbursement> payrollTV;

    @FXML
    private TableColumn<SalaryDisbursement, String> staffNameTC;

    @FXML
    private TableColumn<SalaryDisbursement, Double> amountTC;

    @FXML
    private TableColumn<SalaryDisbursement, String> statusTC;

    @FXML
    private Label notificationLabel;

    @FXML
    private TextField staffNameField;

    @FXML
    private ComboBox<Double> hourlyRateComboBox;

    @FXML
    private ComboBox<Integer> workHoursComboBox;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    public void initialize() {
        staffNameTC.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        hourlyRateComboBox.getItems().addAll(200.0, 400.0, 600.0);
        hourlyRateComboBox.setValue(200.0);

        for (int i = 1; i <= 10; i++) {
            workHoursComboBox.getItems().add(i);
        }
        workHoursComboBox.setValue(1);

        statusComboBox.getItems().addAll("Paid", "Not Paid");
        statusComboBox.setValue("Not Paid");

        addPayrollBtn.setOnAction(e -> addPayroll());
    }

    private void addPayroll() {
        String staffName = staffNameField.getText();
        if (staffName == null || staffName.trim().isEmpty()) {
            notificationLabel.setText("Please enter staff name");
            return;
        }

        double hourlyRate = hourlyRateComboBox.getValue();
        int workHours = workHoursComboBox.getValue();
        String status = statusComboBox.getValue();

        String employeeId = "EMP-" + (100 + (int)(Math.random() * 900));

        SalaryDisbursement newSalary = new SalaryDisbursement(employeeId, staffName, hourlyRate, workHours, status);
        payrollTV.getItems().add(newSalary);

        staffNameField.clear();
        notificationLabel.setText("Payroll data added successfully.");
    }
}