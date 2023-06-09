package view.mentorview;

import controller.MentorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MentorMyPageFrame extends JFrame implements ActionListener{

    private JTextField phoneNumberTextField;
    private JTextField emailTextField;
    private JButton saveButton;
    private MentorController mentorController;

    public MentorMyPageFrame(MentorController mentorController) {
        this.mentorController = mentorController;

        setVisible(true);
        setTitle("멘토 정보 수정"); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 종료

        // 전화번호 입력 필드 생성
        phoneNumberTextField = new JTextField(20); // increased width to 20 columns
        JLabel phoneNumberLabel = new JLabel("전화번호: ");
        phoneNumberLabel.setLabelFor(phoneNumberTextField);

        // 한줄 소개 입력 필드 생성
        emailTextField = new JTextField(20); // increased width to 20 columns
        JLabel emailLabel = new JLabel("email: ");
        emailLabel.setLabelFor(emailTextField);

        // 저장 버튼 생성
        saveButton = new JButton("저장");
        saveButton.addActionListener(this);

        // 컴포넌트들을 패널에 추가
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(new JLabel(""));
        panel.add(saveButton);

        add(panel);
        pack(); // 컴포넌트 크기에 맞게 창 크기 조절
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("저장")) {
            String phoneNumber = phoneNumberTextField.getText();
            String email = emailTextField.getText();

            // 입려된 내용을 저장
            mentorController.MypageUpdateMentor(phoneNumber, email);
            dispose();
            mentorController.goMentorView();
        }
    }
}




