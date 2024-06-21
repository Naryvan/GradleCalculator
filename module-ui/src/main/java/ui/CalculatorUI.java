import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
        window = new JFrame("Calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400,100);
        window.setLocationRelativeTo(null);
        setBackground();
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

    private void setBackground() {
        BufferedImage background = null;
        try {
            background = ImageIO.read(new File("module-ui/src/main/resources/background.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel backgroundLabel = new JLabel(new ImageIcon(background.getScaledInstance(400,100, Image.SCALE_SMOOTH)));
        backgroundLabel.setSize(400,100);
        backgroundLabel.setLocation(0, 0);
        window.setLayout(new BorderLayout());
        window.setContentPane(backgroundLabel);
    }

}
