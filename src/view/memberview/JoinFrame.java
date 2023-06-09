package view.memberview;

import controller.MemberController;
import model.membermodel.Member;
import model.membermodel.MemberService;
import model.membermodel.Usertype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinFrame extends JFrame implements ActionListener{
    private JTextField idField, nameField, ageField, sportCarrerField;
    private JPasswordField pwdField;
    private JRadioButton mentorRadioButton, menteeRadioButton, femaleRadioButton,maleRadioButton;
    private JButton signupButton, backButton;
    private MemberController memberController;

    public JoinFrame(MemberController memberController) {
        this.memberController = memberController;

        setVisible(true);
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

        // 멘토/멘티 선택 라디오 버튼 생성
        JPanel radioButtonPanel1 = new JPanel(new GridLayout(1, 2));
        mentorRadioButton = new JRadioButton("mentor");
        menteeRadioButton = new JRadioButton("mentee");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(mentorRadioButton);
        group1.add(menteeRadioButton);
        radioButtonPanel1.add(mentorRadioButton);
        radioButtonPanel1.add(menteeRadioButton);

        // 나이 입력 필드 생성
        JPanel agePanel = new JPanel(new GridLayout(1, 2));
        JLabel ageLabel = new JLabel("나이: ");
        ageField = new JTextField(10);
        agePanel.add(ageLabel);
        agePanel.add(ageField);

        // 운동경력 입력 필드 생성
        JPanel sportCarrerPanel = new JPanel(new GridLayout(1, 2));
        JLabel sportCarrerLabel = new JLabel("운동경력: ");
        sportCarrerField = new JTextField(10);
        sportCarrerPanel.add(sportCarrerLabel);
        sportCarrerPanel.add(sportCarrerField);

        // 남성/여성 선택 라디오 버튼 생성
        JPanel radioButtonPanel2 = new JPanel(new GridLayout(1, 2));
        maleRadioButton = new JRadioButton("남성");
        femaleRadioButton = new JRadioButton("여성");
        ButtonGroup group2 = new ButtonGroup();
        group2.add(maleRadioButton);
        group2.add(femaleRadioButton);
        radioButtonPanel2.add(maleRadioButton);
        radioButtonPanel2.add(femaleRadioButton);

        // 회원가입 버튼 생성
        JPanel buttonPanel = new JPanel();
        signupButton = new JButton("회원가입");
        signupButton.addActionListener(this);

        // 뒤로가기 버튼 생성
        backButton = new JButton("뒤로가기");
        backButton.addActionListener(this);

        buttonPanel.add(signupButton);
        buttonPanel.add(backButton);

        // 컨테이너에 컴포넌트 추가
        Container container = getContentPane();
        container.setLayout(new GridLayout(4, 1));
        container.add(idPanel);
        container.add(pwdPanel);
        container.add(namePanel);
        container.add(agePanel);
        container.add(sportCarrerPanel);

        container.add(radioButtonPanel1);
        container.add(radioButtonPanel2);
        container.add(buttonPanel, BorderLayout.SOUTH);

        // 프레임 설정
        setSize(350, 300);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("회원가입")) {
            try {
                String id = idField.getText();
                String password = new String(pwdField.getPassword());
                String name = nameField.getText();
                Usertype userType = null;
                if (mentorRadioButton.isSelected())
                    userType = Usertype.Mentor;
                else if (menteeRadioButton.isSelected())
                    userType = Usertype.Mentee;
                else {
                    throw new IllegalStateException(); // 예외 발생
                }
                int age = Integer.parseInt(ageField.getText());
                String sportcarrer = sportCarrerField.getText();
                String sex = null;
                if (maleRadioButton.isSelected())
                    sex = "남성";
                else if (femaleRadioButton.isSelected())
                    sex = "여성";
                else{
                    throw new IllegalStateException(); // 예외 발생
                }
                memberController.registerMember(id, password, name, userType, age, sportcarrer,sex);
                dispose();
            }catch (NumberFormatException ex){
                dispose();
                JOptionPane.showMessageDialog(null, "정보를 잘못입력하였습니다. 다시 입력해주세요.");
                memberController.goJoinFrame();
            }catch (IllegalStateException ex) {
                dispose();
                JOptionPane.showMessageDialog(null, "정보를 잘못입력하였습니다. 다시 입력해주세요.");
                memberController.goJoinFrame();
            }
        }
        else if(e.getActionCommand().equals("뒤로가기")){
            dispose();
            memberController.goLoginFrame();
        }
    }
}