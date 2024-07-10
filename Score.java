package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    Score(String name, int numQuestions, String[][] questionsList, String[][] userAnswers, String[][] answers) {
        setBounds(100, 50, 1000, 600); // Adjust window size to fit all questions
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Hello " + name + ", here is your score:");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        heading.setForeground(new Color(0,0,0));
        add(heading, BorderLayout.NORTH);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
        scorePanel.setBackground(Color.WHITE);

        int correctAnswers = 0;
        for (int i = 0; i < numQuestions; i++) {
            String question = questionsList[i][0];
            String correctAnswer = answers[i][0];
            String userAnswer = userAnswers[i][0];

            if (correctAnswer.equals(userAnswer)) {
                correctAnswers++;
            }

            JLabel questionLabel = new JLabel("Question " + (i + 1) + ": " + question);
            questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            scorePanel.add(questionLabel);

            JLabel correctAnswerLabel = new JLabel("Correct Answer: " + correctAnswer);
            correctAnswerLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            scorePanel.add(correctAnswerLabel);

            JLabel userAnswerLabel = new JLabel("Your Answer: " + userAnswer);
            userAnswerLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            scorePanel.add(userAnswerLabel);

            scorePanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space between questions
        }

        // Add score label to the score panel
        JLabel scoreLabel = new JLabel("Your Score: " + correctAnswers + "/" + numQuestions);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the score label
        scorePanel.add(scoreLabel);

        JScrollPane scrollPane = new JScrollPane(scorePanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton exit = new JButton("Exit");
        exit.setBackground(new Color(22, 99, 54));
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        exit.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel exitPanel = new JPanel();
        exitPanel.setBackground(Color.WHITE);
        exitPanel.add(exit);

        add(exitPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }

    public static void main(String[] args) {
        // Sample data for testing
        String name = "User";
        int numQuestions = 10;
        String[][] questionsList = {
                {"Question 1", "Option A1", "Option B1", "Option C1", "Option D1"},
                {"Question 2", "Option A2", "Option B2", "Option C2", "Option D2"},
                {"Question 3", "Option A3", "Option B3", "Option C3", "Option D3"},
                {"Question 4", "Option A4", "Option B4", "Option C4", "Option D4"},
                {"Question 5", "Option A5", "Option B5", "Option C5", "Option D5"},
                {"Question 6", "Option A6", "Option B6", "Option C6", "Option D6"},
                {"Question 7", "Option A7", "Option B7", "Option C7", "Option D7"},
                {"Question 8", "Option A8", "Option B8", "Option C8", "Option D8"},
                {"Question 9", "Option A9", "Option B9", "Option C9", "Option D9"},
                {"Question 10", "Option A10", "Option B10", "Option C10", "Option D10"}
        };
        String[][] userAnswers = {
                {"Option A1"}, {"Option B2"}, {"Option C3"}, {"Option D4"},
                {"Option A5"}, {"Option B6"}, {"Option C7"}, {"Option D8"},
                {"Option A9"}, {"Option B10"}
        };
        String[][] answers = {
                {"Option A1"}, {"Option B2"}, {"Option C3"}, {"Option D4"},
                {"Option A5"}, {"Option B6"}, {"Option C7"}, {"Option D8"},
                {"Option A9"}, {"Option B10"}
        };

        new Score(name, numQuestions, questionsList, userAnswers, answers);
    }
}
