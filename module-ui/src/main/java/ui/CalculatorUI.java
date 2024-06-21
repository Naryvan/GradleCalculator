package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class CalculatorUI {

    public JFrame window;
    public JPanel panel;
    public JTextField firstNumber;
    public JTextField secondNumber;
    public JComboBox<String> operation;
    public JTextField result;

    public CalculatorUI() {
        window = new JFrame(getAppName());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400,100);
        window.setLocationRelativeTo(null);
        window.setLayout(new FlowLayout());
        panel = new JPanel();

        NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        firstNumber = new JTextField(10);
        secondNumber = new JTextField(10);
        operation = new JComboBox<>(new String[]{"+", "*"});
        result = new JTextField();
        result.setColumns(10);
        result.setEditable(false);

        panel.add(firstNumber);
        panel.add(operation);
        panel.add(secondNumber);
        panel.add(result);
        panel.setBackground(null);
        panel.setOpaque(false);
        window.add(panel);
        window.setVisible(true);

        firstNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    private String getAppName() {
        String file ="module-ui/src/main/resources/build_config.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();
            reader.close();
            return currentLine;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
