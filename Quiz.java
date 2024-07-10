package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Quiz extends JFrame implements ActionListener {

    private String name;
    private String selectedConcept;
    private int numQuestions;
    private int count = 0;
    private int timer = 15;

    private JLabel questionLabel;
    private JRadioButton opt1, opt2, opt3, opt4;
    private ButtonGroup group;
    private JButton next, submit;

    private ArrayList<String[]> questionsList;
    private String[][] userAnswers;

    private Timer questionTimer;

    Quiz(String name, String selectedConcept, int numQuestions) {
        this.name = name;
        this.selectedConcept = selectedConcept;
        this.numQuestions = numQuestions;

        setTitle("Quiz - " + selectedConcept);
        setSize(1100, 650);
        setLocation(100, 10);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        questionsList = new ArrayList<>();
        userAnswers = new String[numQuestions][1];

        setQuestions(selectedConcept);
        shuffleQuestions();

        questionLabel = new JLabel("Question 1: " + questionsList.get(count)[0]);
        questionLabel.setBounds(100, 100, 1000, 30);
        questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(questionLabel);

        opt1 = new JRadioButton(questionsList.get(count)[1]);
        opt1.setBounds(100, 150, 500, 30);
        opt1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(opt1);

        opt2 = new JRadioButton(questionsList.get(count)[2]);
        opt2.setBounds(100, 200, 500, 30);
        opt2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(opt2);

        opt3 = new JRadioButton(questionsList.get(count)[3]);
        opt3.setBounds(100, 250, 500, 30);
        opt3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(opt3);

        opt4 = new JRadioButton(questionsList.get(count)[4]);
        opt4.setBounds(100, 300, 500, 30);
        opt4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        next = new JButton("Next");
        next.setBounds(300, 400, 100, 30);
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(450, 400, 100, 30);
        submit.setBackground(new Color(22, 99, 54));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        startTimer();

        setVisible(true);
    }

    private void setQuestions(String selectedConcept) {
        Map<String, ArrayList<String[]>> questionBank = new HashMap<>();

        // Sample questions for each concept
        ArrayList<String[]> primitiveDataTypes = new ArrayList<>();
        primitiveDataTypes.add(new String[]{"Number of primitive data types in Java are.?", "6", "7", "8", "9"});
        primitiveDataTypes.add(new String[]{"What is the size of float and double in java.?", "32 and 64", "32 and 32", "64 and 64", "64 and 32"});
        primitiveDataTypes.add(new String[]{"Default value of boolean variable is.?", "true", "false", "0", "1"});
        primitiveDataTypes.add(new String[]{"What is the size of byte variable?", "8 bit", "16 bit", "32 bit", "64 bit"});
        primitiveDataTypes.add(new String[]{"What is the default value of char variable?", "'\\u0000'", "'0'", "'\\u0020'", "'\\u0001'"});
        primitiveDataTypes.add(new String[]{"Which datatype is used to store a single character in java?", "char", "string", "letter", "ch"});
        primitiveDataTypes.add(new String[]{"Which is not a primitive data type?", "Boolean", "Character", "Arrays", "Integer"});
        primitiveDataTypes.add(new String[]{" What is the default value of long ?", "0.00", "0I", "0L", "0B"});
        primitiveDataTypes.add(new String[]{"What is the default value of int ?", "0.0f", "0i", "0I", "0"});
        primitiveDataTypes.add(new String[]{"Which of the following can be a valid value for a char data type?", "7", "'A'", "8", "Both a and c"});

        questionBank.put("Primitive Data Types", primitiveDataTypes);

        ArrayList<String[]> arrayHandling = new ArrayList<>();
        arrayHandling.add(new String[]{"When an array is passed to a method, what does the method receive?", "The reference of the array", "A copy of the array", "Length of the array", "Copy of first element"});
        arrayHandling.add(new String[]{"Arrays in java are.?", "Object References", "Objects", "Primitive data type", "None"});
        arrayHandling.add(new String[]{"What is the default value of an array?", "null", "0", "Depends on type of array", "None"});
        arrayHandling.add(new String[]{"Which of these is necessary to specify at the time of array initialization?", "Size of array", "Number of elements", "Data type of array", "None"});
        arrayHandling.add(new String[]{"Which of these is an incorrect array declaration?", "int arr[] = new int[5]", "int [] arr = new int[5]", "int arr[] = new int[5] {1, 2, 3, 4, 5}", "int arr[] = {1, 2, 3, 4, 5}"});
        arrayHandling.add(new String[]{" Which of these operators is used to allocate memory to array variable in Java?", "malloc", "alloc", "new", "new malloc"});
        arrayHandling.add(new String[]{"Which of these is necessary to specify at time of array initialization?", "Row", "Column", "Both", "None"});
        arrayHandling.add(new String[]{"What is the index range for the elements of an array in Java?", "0 to length - 1", "1 to length", "-1 to length - 1", "0 to length"});
        arrayHandling.add(new String[]{"Which method is used to copy one array into another in Java?", "copy()", "clone()", "System.arraycopy()", "Arrays.copy()"});
        arrayHandling.add(new String[]{"Which of this method is used to make all elements of an equal to specified value?", "add()", "fill()", "set()", "all()"});
        questionBank.put("Array Handling", arrayHandling);

        ArrayList<String[]> inheritance = new ArrayList<>();
        inheritance.add(new String[]{"Which keyword is used for inheritance in Java?", "extends", "implements", "inherit", "super"});
        inheritance.add(new String[]{"A subclass inherits all the members of its superclass except.", "constructors", "methods", "fields", "All of the above"});
        inheritance.add(new String[]{"Which of the following is not a type of inheritance?", "Hybrid", "Single", "Double", "Multiple"});
        inheritance.add(new String[]{"Can a class be both a superclass and a subclass?", "Yes", "No", "Depends on the implementation", "None"});
        inheritance.add(new String[]{"What is true about a final class?", "It cannot be inherited", "It can be inherited", "It is a superclass", "None of the above"});
        inheritance.add(new String[]{"A class member declared protected becomes a member of subclass of which type?", "private", "public", "protected", "static"});
        inheritance.add(new String[]{"What is the parent class of all classes in Java? ", "object", "string", "class", "system"});
        inheritance.add(new String[]{"What is the purpose of the 'super' keyword in Java?", "To call the constructor of the parent class ", "To call a method of the child class ", " To create a new instance of a class", "To define a static method"});
        inheritance.add(new String[]{"What is a multilevel inheritance in Java? ", "A class extends two or more classes", "Two or more classes extend the same class ", "A class extends another class which also extends another class", "All of the above "});
        inheritance.add(new String[]{"Which of the following is NOT a benefit of using inheritance in Java?", "Code reuse", " Polymorphism", "Encapsulation", "Method Overloading"});
        questionBank.put("Inheritance", inheritance);

        ArrayList<String[]> polymorphism = new ArrayList<>();
        polymorphism.add(new String[]{"Which of the following is true about method overloading?", "Methods must have the same name", "Methods must have different names", "Methods must have the same number of parameters", "None of the above"});
        polymorphism.add(new String[]{"What is runtime polymorphism?", "Method overriding", "Method overloading", "Both", "None"});
        polymorphism.add(new String[]{"Which of the following is not a type of polymorphism?", "Static", "Dynamic", "Compile-time", "Execution-time"});
        polymorphism.add(new String[]{"Can a static method be overridden?", "No", "Yes", "Depends on the access modifier", "None"});
        polymorphism.add(new String[]{"What is the other name for method overriding?", "Runtime polymorphism", "Compile-time polymorphism", "Static binding", "None"});
        polymorphism.add(new String[]{"What does the word 'Polymorphism' mean in Greek?", "Many forms", "Single forms", "No form", "Final form"});
        polymorphism.add(new String[]{"Which of these allows compile-time polymorphism?", "Method overriding", "Method overloading", "Both", "None"});
        polymorphism.add(new String[]{"Can we override static methods in Java?", "Yes", "No", "Sometimes", "only in abstract class"});
        polymorphism.add(new String[]{"In polymorphism, a reference variable of the superclass can refer to the object of which classes?", "Only the superclass", "Only the subclass", "Any class", "The superclass or any of its subclasses"});
        polymorphism.add(new String[]{"Which among the following is the language which supports classes but not polymorphism?", "Java", "C", "C++", "Ada"});
        questionBank.put("Polymorphism", polymorphism);

        ArrayList<String[]> exceptionHandling = new ArrayList<>();
        exceptionHandling.add(new String[]{"Which of these keywords is used to handle exceptions?", "try", "catch", "throw", "all of the above"});
        exceptionHandling.add(new String[]{"Which of these is a superclass of all exceptions?", "Throwable", "Exception", "RuntimeException", "Error"});
        exceptionHandling.add(new String[]{"Which of these is used to throw an exception manually?", "throw", "throws", "try", "catch"});
        exceptionHandling.add(new String[]{"Which of these blocks will be executed regardless of whether an exception is handled or not?", "finally", "catch", "throw", "none"});
        exceptionHandling.add(new String[]{"What is the return type of the method that handles exceptions?", "void", "int", "boolean", "None"});
        exceptionHandling.add(new String[]{"When does Exceptions in Java arises in code sequence?", "Run time", "Compile time", "Can occur anytime", "None"});
        exceptionHandling.add(new String[]{"Which of these keywords is not a part of exception handling?", "throw", "throws", "try", "catch"});
        exceptionHandling.add(new String[]{"Which of these keywords must be used to monitor for exceptions?", "throw", "throws", "try", "catch"});
        exceptionHandling.add(new String[]{"Exception is a class/interface/abstract class/other?", "class", "interface", "abstract", "other"});
        exceptionHandling.add(new String[]{"Exception is found in which package in java?", "java.lang", "java.util", "java.io", "java"});
        questionBank.put("Exception Handling", exceptionHandling);

        // Fetch questions based on selected concept
        ArrayList<String[]> selectedQuestions = questionBank.get(selectedConcept);
        if (selectedQuestions != null) {
            for (int i = 0; i < numQuestions; i++) {
                questionsList.add(selectedQuestions.get(i % selectedQuestions.size())); // Loop through questions if fewer than numQuestions available
            }
        }
    }

    private void shuffleQuestions() {
        Collections.shuffle(questionsList);
    }

    private void startTimer() {
        questionTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer--;
                if (timer >= 0) {
                    next.setText("Next (" + timer + ")");
                }
                if (timer == 0) {
                    next.doClick();
                }
            }
        });
        questionTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            String userAnswer = "";

            if (opt1.isSelected()) {
                userAnswer = opt1.getText();
            } else if (opt2.isSelected()) {
                userAnswer = opt2.getText();
            } else if (opt3.isSelected()) {
                userAnswer = opt3.getText();
            } else if (opt4.isSelected()) {
                userAnswer = opt4.getText();
            }

            userAnswers[count][0] = userAnswer;
            count++;
            timer = 15; // Reset timer for next question

            if (count == numQuestions - 1) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == numQuestions) {
                submit.doClick(); // Automatically trigger submit action
            } else {
                questionLabel.setText("Question " + (count + 1) + ": " + questionsList.get(count)[0]);
                opt1.setText(questionsList.get(count)[1]);
                opt2.setText(questionsList.get(count)[2]);
                opt3.setText(questionsList.get(count)[3]);
                opt4.setText(questionsList.get(count)[4]);

                group.clearSelection();
            }
        } else if (e.getSource() == submit) {
            questionTimer.stop(); // Stop the timer

            // Prepare answers array for Score class
            String[][] answers = new String[numQuestions][1];
            for (int i = 0; i < numQuestions; i++) {
                answers[i][0] = questionsList.get(i)[1]; // Assuming index 1 is correct answer
            }

            // Open Score window
            Score score;
            score = new Score(name, numQuestions, questionsList.<String[]>toArray(new String[0][0]), userAnswers, answers);
            dispose(); // Close the Quiz window
        }
    }
}
