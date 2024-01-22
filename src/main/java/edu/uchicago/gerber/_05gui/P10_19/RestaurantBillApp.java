package edu.uchicago.gerber._05gui.P10_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantBillApp {

    private JFrame frame;
    private JTextArea billArea;
    private JTextField customItemField;
    private JTextField customPriceField;
    private double total = 0;
    private String billDetail="";

    private static final double TAX_RATE = 0.07; // 7% tax
    private static final double TIP_RATE = 0.15; // 15% tip

    public RestaurantBillApp() {
        frame = new JFrame("Restaurant Bill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        String[] popularItems = {
                "Pizza", "Burger", "Pasta", "Salad", "Soda",
                "Coffee", "Tea", "Ice Cream", "Pie", "Steak"
        };

        final double[] popularPrices = {
                10.00, 6.50, 9.00, 5.00, 2.00,
                3.00, 2.50, 4.00, 3.50, 14.00
        };

        for (int i = 0; i < popularItems.length; i++) {
            final String item = popularItems[i];
            final double price = popularPrices[i];
            JButton button = new JButton(item + " - $" + price);
            button.addActionListener(e -> addItem(item, price));
            panel.add(button);
        }

        customItemField = new JTextField(10);
        customPriceField = new JTextField(5);
        JButton customButton = new JButton("Add Custom Item");
        customButton.addActionListener(e -> {
            try {
                String item = customItemField.getText();
                double price = Double.parseDouble(customPriceField.getText());
                addItem(item, price);
                customItemField.setText("");
                customPriceField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid price.");
            }
        });

        billArea = new JTextArea(30, 30);
        billArea.setEditable(false);

        panel.add(new JLabel("Item:"));
        panel.add(customItemField);
        panel.add(new JLabel("Price:"));
        panel.add(customPriceField);
        panel.add(customButton);
        panel.add(new JScrollPane(billArea));

        frame.add(panel);
        frame.setVisible(true);
    }

    private void addItem(String item, double price) {
        total += price;
        billDetail = item + " - $" + String.format("%.2f", price) + "\n" + billDetail;
        double tax = total * TAX_RATE;
        double tip = total * TIP_RATE;
        double grandTotal = total + tax + tip;

        String billSummary = billDetail
                + "---------------------------\n"
                + "Subtotal: $" + String.format("%.2f", total) + "\n"
                + "Tax (7%): $" + String.format("%.2f", tax) + "\n"
                + "Tip (15%): $" + String.format("%.2f", tip) + "\n"
                + "Total: $" + String.format("%.2f", grandTotal);

        billArea.setText(billSummary);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RestaurantBillApp());
    }
}

