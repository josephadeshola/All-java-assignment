import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guicalculator extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel panel;
    private StringBuilder input;
    private String operator;
    private double num1, num2, result;

    public Guicalculator() {
        input = new StringBuilder();
        operator = "";
        
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        addButtonsToPanel();
        add(panel, BorderLayout.CENTER);
        
        setTitle("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addButtonsToPanel() {
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(this);
            panel.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]") || command.equals(".")) {
            input.append(command);
            display.setText(input.toString());
        } else if (command.matches("[/*+-]")) {
            num1 = Double.parseDouble(input.toString());
            operator = command;
            input.setLength(0);
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(input.toString());
            calculateResult();
            display.setText(String.valueOf(result));
            input.setLength(0);
        }
    }

    private void calculateResult() {
        switch (operator) {
            case "/":
                result = num1 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Guicalculator().setVisible(true);
        });
    }
}
