package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class U7G8ArchiveReports {

    @FXML
    private TableView<ArchivedReport> archiveTable;

    @FXML
    private TableColumn<ArchivedReport, String> reportNameColumn;

    @FXML
    private TableColumn<ArchivedReport, String> dateArchivedColumn;

    @FXML
    private TableColumn<ArchivedReport, String> sizeColumn;

    @FXML
    private ComboBox<String> eventCBox;

    @FXML
    private ComboBox<String> reportFileCBox;

    @FXML
    private Label confirmationLabel;

    @FXML
    public void initialize() {
        if (reportNameColumn != null) {
            reportNameColumn.setCellValueFactory(new PropertyValueFactory<>("reportName"));
            dateArchivedColumn.setCellValueFactory(new PropertyValueFactory<>("dateArchived"));
            sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        }

        eventCBox.setItems(FXCollections.observableArrayList("Event 1", "Event 2", "Event 3"));
        reportFileCBox.setItems(FXCollections.observableArrayList(
            "Financial Report.pdf", "Attendance List.xlsx", "Event Summary.docx", "Budget Overview.pdf"
        ));
    }


    @FXML
    private void uploadONA() {
        if (eventCBox.getValue() != null && reportFileCBox.getValue() != null) {
            String selectedFile = reportFileCBox.getValue();
            String currentDate = java.time.LocalDate.now().toString();
            String fileSize = getRandomFileSize();

            archiveTable.getItems().add(new ArchivedReport(selectedFile, currentDate, fileSize));
            confirmationLabel.setText("Report archived successfully!");
        } else {
            confirmationLabel.setText("Please select an event and choose a file.");
        }
    }

    private String getRandomFileSize() {
        double size = 0.5 + Math.random() * 9.5;
        return String.format("%.1f MB", size);
    }
}