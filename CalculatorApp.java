import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
    private JFrame frame;
    private JTextField display;
    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";
    private boolean i-sOperatorClicked = false;

    public CalculatorApp() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Display panel
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setBackground(Color.BLACK); // Display background color
        display.setForeground(Color.WHITE); // Text color
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBackground(Color.DARK_GRAY); // Background color for buttons

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.setBackground(new Color(50, 50, 50)); // Dark gray button color
            button.setForeground(Color.WHITE); // Button text color
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("C")) {
                // Clear the display
                currentInput = "";
                display.setText(currentInput);
            } else if (command.equals("=")) {
                // Calculate the result
                double secondOperand = Double.parseDouble(currentInput);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    case "/":
                        if (secondOperand != 0) {
                            result = firstOperand / secondOperand;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }
                currentInput = String.valueOf(result);
                display.setText(currentInput);
                operator = "";
            } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                // Store the first operand and operator, and prepare for the second operand
                if (!currentInput.isEmpty()) {
                    firstOperand = Double.parseDouble(currentInput);
                    operator = command;
                    currentInput = "";
                }
            } else {
                // Number or decimal point clicked
                currentInput += command;
                display.setText(currentInput);
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}

             
