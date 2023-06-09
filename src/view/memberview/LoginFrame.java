package view.memberview;

import controller.MemberController;
import model.membermodel.Member;
import model.membermodel.MemberService;
import model.membermodel.Usertype;
import view.menteeview.MenteeView;
import view.mentorview.MentorView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener{
    private JTextField idField;
    private JPasswordField pwField;
    private JButton loginBtn, registerBtn;
    private MemberController memberController;


    public LoginFrame(MemberController memberController) {
        this.memberController = memberController;

        setVisible(true);
        setTitle("로그인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 로그인 패널 생성
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        // 로고 이미지 라벨
        Font font = new Font("돋움", Font.BOLD, 30);
        JLabel logoLabel = new JLabel("헬스 길라잡이");
        logoLabel.setFont(font);
        logoLabel.setBounds(70, 20, 200, 100);
        loginPanel.add(logoLabel);

        // 로그인 라벨과 텍스트필드
        JLabel idLabel = new JLabel("아이디:");
        idLabel.setBounds(50, 140, 100, 25);
        loginPanel.add(idLabel);

        idField = new JTextField(20);
        idField.setBounds(160, 140, 150, 25);
        loginPanel.add(idField);

        JLabel pwLabel = new JLabel("비밀번호:");
        pwLabel.setBounds(50, 180, 100, 25);
        loginPanel.add(pwLabel);

        pwField = new JPasswordField(20);
        pwField.setBounds(160, 180, 150, 25);
        loginPanel.add(pwField);

        // 로그인 버튼
        loginBtn = new JButton("로그인");
        loginBtn.setBounds(50, 220, 100, 25);
        loginBtn.addActionListener(this);
        loginPanel.add(loginBtn);

        // 회원가입 버튼
        registerBtn = new JButton("회원가입");
        registerBtn.setBounds(210, 220, 100, 25);
        registerBtn.addActionListener(this);
        loginPanel.add(registerBtn);

        // 로그인 패널을 프레임에 추가
        add(loginPanel);
        setSize(350, 300);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("로그인")) {
            String id = idField.getText();
            String pw = String.valueOf(pwField.getPassword());

            dispose();
            memberController.loginMember(id, pw);
        } else if (e.getActionCommand().equals("회원가입")) {
            dispose();
            memberController.goJoinFrame();
        }
    }
}