package view.mentorview;
import controller.MentorController;
import model.membermodel.Member;
import model.menteemodel.Mentee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PostDietProgramFrame extends JFrame implements ActionListener {

    private JTextField dateTextField;
    private JTextArea dietTextArea;
    private JButton saveButton;
    private JButton backButton;
    private JComboBox<String> menteeComboBox;
    private MentorController mentorController;

    public PostDietProgramFrame(MentorController mentorController) {
        this.mentorController = mentorController;

        setTitle("식단 방법");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1));

        JLabel menteeLabel = new JLabel("멘티 선택:");
        menteeComboBox = new JComboBox<>();
        menteeComboBox.setPreferredSize(new Dimension(200, 30));

        Set<Member> members = mentorController.readMyMentee();
        for(Member member : members){
            menteeComboBox.addItem(member.getName());
        }

        JLabel dateLabel = new JLabel("날짜 (YYYY-MM-DD):");
        dateTextField = new JTextField();
        dateTextField.setPreferredSize(new Dimension(200, 30));

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());

        JLabel exerciseLabel = new JLabel("식단:");
        dietTextArea = new JTextArea();
        dietTextArea.setLineWrap(true);
        dietTextArea.setWrapStyleWord(true);
        JScrollPane exerciseScrollPane = new JScrollPane(dietTextArea);
        exerciseScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        inputPanel.add(menteeLabel);
        inputPanel.add(menteeComboBox);
        inputPanel.add(dateLabel);
        inputPanel.add(dateTextField);

        outputPanel.add(exerciseLabel, BorderLayout.NORTH);
        outputPanel.add(exerciseScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(outputPanel, BorderLayout.CENTER);

        saveButton = new JButton("저장");
        saveButton.addActionListener(this);

        backButton = new JButton("뒤로가기");
        backButton.addActionListener(this);
        buttonPanel.add(saveButton, BorderLayout.EAST);
        buttonPanel.add(backButton, BorderLayout.WEST);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String mentee = (String) menteeComboBox.getSelectedItem();
            String date = dateTextField.getText();
            String exercise = dietTextArea.getText();

            if (!date.isEmpty() && !exercise.isEmpty()) {
                mentorController.postDiet(mentee, date, exercise);
                JOptionPane.showMessageDialog(this, "식단이 성공적으로 저장되었습니다.");
                dispose();
                mentorController.goMentorView();
            } else {
                JOptionPane.showMessageDialog(this, "날짜와 식단 둘다 입력하세요.");
            }
        } else if (e.getSource() == backButton) {
            dispose();
            mentorController.goMentorView();
        }
    }
}
