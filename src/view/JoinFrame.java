package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinFrame extends JFrame implements ActionListener {
    private JTextField idField, nameField, ageField;
    private JPasswordField pwdField;
    private JRadioButton mentorRadioButton;
    private JRadioButton menteeRadioButton;

    public JoinFrame() {
        setTitle("회원가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 아이디 입력 필드 생성
        JPanel idPanel = new JPanel(new GridLayout(1, 2));
        JLabel idLabel = new JLabel("아이디: ");
        idField = new JTextField(10);
        idPanel.add(idLabel);
        idPanel.add(idField);

        // 비밀번호 입력 필드 생성
        JPanel pwdPanel = new JPanel(new GridLayout(1, 2));
        JLabel pwdLabel = new JLabel("비밀번호: ");
        pwdField = new JPasswordField(10);
        pwdPanel.add(pwdLabel);
        pwdPanel.add(pwdField);

        // 이름 입력 필드 생성
        JPanel namePanel = new JPanel(new GridLayout(1, 2));
        JLabel nameLabel = new JLabel("이름: ");
        nameField = new JTextField(10);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // 나이 입력 필드 생성
        JPanel agePanel = new JPanel(new GridLayout(1, 2));
        JLabel ageLabel = new JLabel("나이: ");
        ageField = new JTextField(10);
        agePanel.add(ageLabel);
        agePanel.add(ageField);

        // 멘토/멘티 선택 라디오 버튼 생성
        JPanel radioButtonPanel = new JPanel(new GridLayout(1, 2));
        mentorRadioButton = new JRadioButton("멘토");
        menteeRadioButton = new JRadioButton("멘티");
        ButtonGroup group = new ButtonGroup();
        group.add(mentorRadioButton);
        group.add(menteeRadioButton);
        radioButtonPanel.add(mentorRadioButton);
        radioButtonPanel.add(menteeRadioButton);

        // 회원가입 버튼 생성
        JButton signupButton = new JButton("회원가입");
        signupButton.addActionListener(this);

        // 컨테이너에 컴포넌트 추가
        Container container = getContentPane();
        container.setLayout(new GridLayout(4, 1));
        container.add(idPanel);
        container.add(pwdPanel);
        container.add(namePanel);
        container.add(agePanel);
        container.add(radioButtonPanel);
        container.add(signupButton);

        // 프레임 설정
        setSize(350, 300);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("회원가입")) {
            String name = nameField.getText();
            String age = ageField.getText();
            String userType = "";
            if (mentorRadioButton.isSelected()) {
                userType = "멘토";
            } else if (menteeRadioButton.isSelected()) {
                userType = "멘티";
            }
            // TODO: 입력받은 정보로 회원가입 처리하기
            System.out.println("이름: " + name + ", 나이: " + age + ", 회원 유형: " + userType);

            // 회원가입 완료 후 이전 화면으로 돌아가기
            dispose(); // 현재 창 닫기
            new LoginFrame();
            // TODO: 이전 화면을 띄우는 코드 작성
        }
    }
}
