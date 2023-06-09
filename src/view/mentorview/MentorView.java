package view.mentorview;

import controller.MentorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MentorView extends JFrame implements ActionListener {
    private JLabel label;
    private MentorController mentorController;

    public MentorView(MentorController mentorController){
        this.mentorController = mentorController;
        setVisible(true);
        setTitle("버튼 예시");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 버튼 패널 생성
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        // 버튼 1
        JButton button1 = new JButton("내 멘티 목록 보기");
        button1.addActionListener(this);
        buttonPanel.add(button1);

        // 버튼 2
        JButton button2 = new JButton("식단 작성 하기");
        button2.addActionListener(this);
        buttonPanel.add(button2);

        // 버튼 3
        JButton button3 = new JButton("운동법 작성 하기");
        button3.addActionListener(this);
        buttonPanel.add(button3);

        // 버튼 4
        JButton button4 = new JButton("마이페이지");
        button4.addActionListener(this);
        buttonPanel.add(button4);

        // 버튼 5
        JButton button5= new JButton("로그아웃");
        button5.addActionListener(this);
        buttonPanel.add(button5);

        // 라벨 생성
        label = new JLabel("버튼 클릭");

        // 프레임에 컴포넌트 추가
        add(buttonPanel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        // 프레임 설정
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("내 멘티 목록 보기")) {
            label.setText("내 멘티 목록 보기 clicked");
            dispose();
            mentorController.goMenteeListFrame();
        } else if (e.getActionCommand().equals("식단 작성 하기")) {
            label.setText("식단 작성 하기 clicked");
            dispose();
            mentorController.goPostDietProgramFrame();
        } else if(e.getActionCommand().equals("운동법 작성 하기")){
            label.setText("운동법 작성 하기 clicked");
            dispose();
            mentorController.goPostExerciseProgramFrame();
        } else if (e.getActionCommand().equals("마이페이지")) {
            label.setText("마이페이지 clicked");
            dispose();
            mentorController.goMentorMyPageFrame();
        } else if(e.getActionCommand().equals("로그아웃")){
            label.setText("로그아웃 clicked");
            dispose();
            JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
            mentorController.goLoginFrame();
        }
    }
}