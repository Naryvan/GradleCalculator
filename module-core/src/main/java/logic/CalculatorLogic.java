import math.MathOperations;
import ui.CalculatorUI;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorLogic {

    CalculatorUI ui;

    public CalculatorLogic() {
        ui = new CalculatorUI();
        ui.firstNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculate();
            }
        });
        ui.secondNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculate();
            }
        });
        ui.operation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
    }

    private void calculate() {
        Integer firstNumber;
        Integer secondNumber;
        try {
            firstNumber = Integer.parseInt(ui.firstNumber.getText());
            secondNumber = Integer.parseInt(ui.secondNumber.getText());
        } catch (NumberFormatException e) {
            ui.result.setText("");
            return;
        }
        if(ui.operation.getSelectedItem().toString().equals("+")) {
            ui.result.setText(String.valueOf(MathOperations.add(firstNumber, secondNumber)));
        } else if(ui.operation.getSelectedItem().toString().equals("*")) {
            ui.result.setText(String.valueOf(MathOperations.multiply(firstNumber, secondNumber)));
        }
    }

    public static void main(String[] args) {
        new CalculatorLogic();
    }

}
