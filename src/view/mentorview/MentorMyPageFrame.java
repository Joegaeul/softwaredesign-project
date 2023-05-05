package view.mentorview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MentorMyPageFrame extends JFrame {

    private JTextField careerTextField;
    private JTextField phoneNumberTextField;
    private JTextField introductionTextField;
    private JButton saveButton;

    public MentorMyPageFrame() {
        setTitle("멘토 정보 수정"); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 종료

        // 운동경력 입력 필드 생성
        careerTextField = new JTextField();
        JLabel careerLabel = new JLabel("운동경력: ");
        careerLabel.setLabelFor(careerTextField);

        // 전화번호 입력 필드 생성
        phoneNumberTextField = new JTextField(20); // increased width to 20 columns
        JLabel phoneNumberLabel = new JLabel("전화번호: ");
        phoneNumberLabel.setLabelFor(phoneNumberTextField);

        // 한줄 소개 입력 필드 생성
        introductionTextField = new JTextField(20); // increased width to 20 columns
        JLabel introductionLabel = new JLabel("한줄 소개: ");
        introductionLabel.setLabelFor(introductionTextField);

        // 저장 버튼 생성
        saveButton = new JButton("저장");
        saveButton.addActionListener(e -> {
            // TODO: 입력된 내용을 저장하는 코드 작성
            JOptionPane.showMessageDialog(this, "저장되었습니다.");
            dispose();
            new MentorView();
        });

        // 컴포넌트들을 패널에 추가
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(careerLabel);
        panel.add(careerTextField);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberTextField);
        panel.add(introductionLabel);
        panel.add(introductionTextField);
        panel.add(new JLabel(""));
        panel.add(saveButton);

        add(panel);

        pack(); // 컴포넌트 크기에 맞게 창 크기 조절
        setLocationRelativeTo(null);
        setVisible(true); // 창 표시
    }
}




