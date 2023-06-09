package view.menteeview;

import controller.MenteeController;
import model.membermodel.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class ReadDietProgramFrame extends JFrame implements ActionListener {
    private JTextField dateTextField;
    private JButton backButton, showButton;
    private JTextArea dietTextArea;
    private JComboBox<String> mentorComboBox;
    private MenteeController menteeController;

    public ReadDietProgramFrame(MenteeController menteeController) {
        this.menteeController = menteeController;

        setTitle("식단 방법");
        setVisible(true);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1));

        JLabel menteeLabel = new JLabel("멘토 선택:");
        mentorComboBox = new JComboBox<>();
        mentorComboBox.setPreferredSize(new Dimension(200, 30));

        Set<Member> members = menteeController.readMyMentor();
        for (Member member : members) {
            mentorComboBox.addItem(member.getName());
        }

        JLabel dateLabel = new JLabel("날짜 (YYYY-MM-DD):");
        dateTextField = new JTextField();
        dateTextField.setPreferredSize(new Dimension(200, 30));

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());

        JLabel exerciseLabel = new JLabel("식단:");
        dietTextArea = new JTextArea();
        dietTextArea.setEditable(false);
        JScrollPane exerciseScrollPane = new JScrollPane(dietTextArea);
        exerciseScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        inputPanel.add(menteeLabel);
        inputPanel.add(mentorComboBox);
        inputPanel.add(dateLabel);
        inputPanel.add(dateTextField);

        outputPanel.add(exerciseLabel, BorderLayout.NORTH);
        outputPanel.add(exerciseScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(outputPanel, BorderLayout.CENTER);

        showButton = new JButton("식단 조회");
        showButton.addActionListener(this);

        backButton = new JButton("뒤로 가기");
        backButton.addActionListener(this);
        buttonPanel.add(showButton, BorderLayout.EAST);
        buttonPanel.add(backButton, BorderLayout.WEST);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showButton) {
            String mentor = (String) mentorComboBox.getSelectedItem();
            String date = dateTextField.getText();

            if (mentor != null && date !=null) {
                String exercise = menteeController.readDiet(mentor, date);
                dietTextArea.setText(exercise);
            } else {
                dietTextArea.setText("선택된 날짜에 식단을 발견할 수 없습니다.");
            }
        }
        else if(e.getSource() == backButton){
            dispose();
            menteeController.goMenteeView();
        }
    }
}


