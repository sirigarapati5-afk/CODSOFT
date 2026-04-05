import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalculatorGUI extends JFrame implements ActionListener {

    JLabel title, subjectsLabel, resultLabel;
    JTextField subjectsField;
    JTextArea marksArea;
    JButton calculateBtn;

    public GradeCalculatorGUI() {
        setTitle("Student Grade Calculator");
        setSize(400, 450);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        title = new JLabel("Grade Calculator");
        title.setBounds(120, 10, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        subjectsLabel = new JLabel("Number of Subjects:");
        subjectsLabel.setBounds(20, 60, 160, 25);
        add(subjectsLabel);

        subjectsField = new JTextField();
        subjectsField.setBounds(180, 60, 150, 25);
        add(subjectsField);

        marksArea = new JTextArea("Enter marks (comma separated)\nExample: 85,90,78");
        marksArea.setBounds(20, 100, 340, 80);
        add(marksArea);

        calculateBtn = new JButton("Calculate");
        calculateBtn.setBounds(120, 200, 140, 30);
        calculateBtn.addActionListener(this);
        add(calculateBtn);

        resultLabel = new JLabel("");
        resultLabel.setBounds(20, 250, 350, 100);
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(subjectsField.getText());
            String[] marksInput = marksArea.getText().split(",");

            if (marksInput.length != n) {
                JOptionPane.showMessageDialog(this, "❌ Number of marks doesn't match subjects!");
                return;
            }

            int total = 0;

            for (String mark : marksInput) {
                int m = Integer.parseInt(mark.trim());

                if (m < 0 || m > 100) {
                    JOptionPane.showMessageDialog(this, "❌ Marks must be between 0-100!");
                    return;
                }

                total += m;
            }

            double avg = (double) total / n;
            String grade;

            if (avg >= 90) grade = "A+";
            else if (avg >= 80) grade = "A";
            else if (avg >= 70) grade = "B";
            else if (avg >= 60) grade = "C";
            else if (avg >= 50) grade = "D";
            else grade = "F";

            resultLabel.setText("<html>Total: " + total +
                    "<br>Average: " + String.format("%.2f", avg) +
                    "<br>Grade: " + grade + "</html>");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Invalid Input!");
        }
    }

    public static void main(String[] args) {
        new GradeCalculatorGUI();
    }
}
