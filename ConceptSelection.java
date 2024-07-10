package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConceptSelection extends JFrame implements ActionListener {

    JButton back, start;
    String name;
    JComboBox<String> conceptBox;
    JComboBox<Integer> numQuestionsBox;

    String[] concepts = {"Primitive Data Types", "Array Handling", "Inheritance", "Polymorphism", "Exception Handling"};

    ConceptSelection(String name) {
        this.name = name;

        JLabel heading = new JLabel("Select Concept and Number of Questions");
        heading.setBounds(150, 100, 500, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 20));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);

        JLabel conceptLabel = new JLabel("Select Concept:");
        conceptLabel.setBounds(100, 200, 200, 30);
        conceptLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        conceptLabel.setForeground(new Color(22, 99, 54));
        add(conceptLabel);

        conceptBox = new JComboBox<>(concepts);
        conceptBox.setBounds(300, 200, 300, 30);
        conceptBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(conceptBox);

        JLabel numQuestionsLabel = new JLabel("Number of Questions:");
        numQuestionsLabel.setBounds(100, 250, 200, 30);
        numQuestionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        numQuestionsLabel.setForeground(new Color(22, 99, 54));
        add(numQuestionsLabel);

        Integer[] numQuestions = {5,10};
        numQuestionsBox = new JComboBox<>(numQuestions);
        numQuestionsBox.setBounds(300, 250, 100, 30);
        numQuestionsBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(numQuestionsBox);

        back = new JButton("Back");
        back.setBounds(300, 350, 100, 30);
        back.setBackground(new Color(22, 99, 54));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(450, 350, 100, 30);
        start.setBackground(new Color(22, 99, 54));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(300, 10);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            String selectedConcept = (String) conceptBox.getSelectedItem();
            int numQuestions = (int) numQuestionsBox.getSelectedItem();

            setVisible(false);
            new Quiz(name, selectedConcept, numQuestions);
        } else if (e.getSource() == back) {
            setVisible(false);
            new Rules(name);
        }
    }

    public static void main(String[] args) {
        new ConceptSelection("User");
    }
}
