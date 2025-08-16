package com.example.project_by_pushon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class U8G5TicketRevenue {

    @FXML
    private ComboBox<String> eventCB;

    @FXML
    private DatePicker dateDP;

    @FXML
    private TextField quantityTF;

    @FXML
    private TextField priceTF;

    @FXML
    private TextField revenueTF;

    @FXML
    private Label notificationLabel;

    @FXML
    private TableView<TicketSale> revenueTV;

    @FXML
    private TableColumn<TicketSale, String> ticketTypeTC;

    @FXML
    private TableColumn<TicketSale, Integer> quantityTC;

    @FXML
    private TableColumn<TicketSale, Double> priceTC;

    @FXML
    private TableColumn<TicketSale, Double> revenueTC;

    @FXML
    private TableColumn<TicketSale, String> saleDateTC;

    private ObservableList<TicketSale> ticketSales;

    @FXML
    public void initialize() {
        ticketSales = FXCollections.observableArrayList();
        loadEvents();
        setupTable();

        revenueTV.setItems(ticketSales);
        revenueTF.setText("$0.00");
    }

    private void loadEvents() {
        ObservableList<String> events = FXCollections.observableArrayList(
                "Summer Music Festival 2024",
                "Corporate Annual Meeting",
                "Tech Conference 2024",
                "Sports Championship Finals",
                "Holiday Celebration Event"
        );
        eventCB.setItems(events);
    }

    private void setupTable() {
        ticketTypeTC.setCellValueFactory(new PropertyValueFactory<>("ticketType"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("pricePerTicket"));
        revenueTC.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));
        saleDateTC.setCellValueFactory(new PropertyValueFactory<>("saleDate"));
    }

    @FXML
    private void addRevenueONA() {
        String ticketType = eventCB.getValue();
        String quantityText = quantityTF.getText();
        String priceText = priceTF.getText();
        LocalDate selectedDate = dateDP.getValue();

        if (ticketType == null || quantityText.isEmpty() ||
            priceText.isEmpty() || selectedDate == null) {
            notificationLabel.setText("Please fill all fields");
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityText);
            double price = Double.parseDouble(priceText);
            String formattedDate = selectedDate.format(DateTimeFormatter.ISO_DATE);

            TicketSale newSale = new TicketSale(ticketType, quantity, price, formattedDate);
            ticketSales.add(newSale);

            quantityTF.clear();
            priceTF.clear();

            updateTotalRevenue();
            notificationLabel.setText("Revenue added successfully");
        } catch (NumberFormatException e) {
            notificationLabel.setText("Please enter valid quantity and price");
        }
    }

    private void updateTotalRevenue() {
        double totalRevenue = ticketSales.stream()
                .mapToDouble(TicketSale::getTotalRevenue)
                .sum();
        revenueTF.setText(String.format("$%.2f", totalRevenue));
    }
}