// U8G3ApproveExpenses.java
package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class U8G3ApproveExpenses {

    @FXML
    private TableView<Expense> expenseTable;

    @FXML
    private TableColumn<Expense, String> idColumn;

    @FXML
    private TableColumn<Expense, String> submitterColumn;

    @FXML
    private TableColumn<Expense, String> descriptionColumn;

    @FXML
    private TableColumn<Expense, Double> amountColumn;

    @FXML
    private TableColumn<Expense, Void> actionsColumn;

    @FXML
    private Label notificationLabel;

    @FXML
    private TextField idField;

    @FXML
    private TextField submitterField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField amountField;

    private ObservableList<Expense> pendingExpenses;

    @FXML
    public void initialize() {
        loadPendingRequests();
        setupTableColumns();
    }

    private void loadPendingRequests() {
        pendingExpenses = FXCollections.observableArrayList();
        expenseTable.setItems(pendingExpenses);
    }

    private void setupTableColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("expenseId"));
        submitterColumn.setCellValueFactory(new PropertyValueFactory<>("submittedBy"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Configure action column with buttons
        actionsColumn.setCellFactory(column -> new TableCell<>() {
            private final Button approveButton = new Button("Approve");
            private final Button rejectButton = new Button("Reject");
            private final HBox buttonsBox = new HBox(5, approveButton, rejectButton);

            {
                buttonsBox.setAlignment(Pos.CENTER);

                approveButton.setOnAction(event -> {
                    Expense expense = getTableView().getItems().get(getIndex());
                    approveExpense(expense);
                });

                rejectButton.setOnAction(event -> {
                    Expense expense = getTableView().getItems().get(getIndex());
                    rejectExpense(expense);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : buttonsBox);
            }
        });
    }

    @FXML
    private void addExpenseONA() {
        try {
            // Validate input fields
            String id = idField.getText().trim();
            String submitter = submitterField.getText().trim();
            String description = descriptionField.getText().trim();
            String amountText = amountField.getText().trim();

            if (id.isEmpty() || submitter.isEmpty() || description.isEmpty() || amountText.isEmpty()) {
                notificationLabel.setText("Please fill in all fields");
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException e) {
                notificationLabel.setText("Amount must be a valid number");
                return;
            }

            // Get current date
            String today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

            // Create and add new expense
            Expense newExpense = new Expense(id, submitter, description, amount, today, "Pending");
            pendingExpenses.add(newExpense);

            // Clear input fields
            idField.clear();
            submitterField.clear();
            descriptionField.clear();
            amountField.clear();

            notificationLabel.setText("New expense request added: " + id);

        } catch (Exception e) {
            notificationLabel.setText("Error adding expense: " + e.getMessage());
        }
    }

    @FXML
    private void viewBillONA() {
        Expense selectedExpense = expenseTable.getSelectionModel().getSelectedItem();
        if (selectedExpense != null) {
            notificationLabel.setText("Bill/Invoice opened for: " + selectedExpense.getExpenseId());
        } else {
            notificationLabel.setText("Please select a pending request first.");
        }
    }

    private void approveExpense(Expense expense) {
        notificationLabel.setText("Expense approved: " + expense.getExpenseId() + " - " + expense.getSubmittedBy());
        pendingExpenses.remove(expense);
    }

    private void rejectExpense(Expense expense) {
        notificationLabel.setText("Expense rejected: " + expense.getExpenseId() + " - " + expense.getSubmittedBy());
        pendingExpenses.remove(expense);
    }
}