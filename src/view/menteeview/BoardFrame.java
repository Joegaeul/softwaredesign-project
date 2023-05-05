package view.menteeview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardFrame extends JFrame{
    private JComboBox<String> mentorComboBox;
    private JTextField titleTextField;
    private JTextArea contentTextArea;

    private JTextField postNumTextField;


    public BoardFrame() {
        initGUI();
    }

    private void initGUI() {
        setTitle("글 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 멘토 선택을 위한 콤보 박스 생성
        mentorComboBox = new JComboBox<>(new String[]{"멘토1", "멘토2", "멘토3"});
        titleTextField = new JTextField(20);

        // 글 내용 입력을 위한 텍스트 에리어 생성
        contentTextArea = new JTextArea(10, 30);
        contentTextArea.setLineWrap(true);
        contentTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(contentTextArea);

        // 글 작성 버튼 생성
        JButton writeButton = new JButton("글 작성");
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("글 작성")) {
                    String mentor = (String) mentorComboBox.getSelectedItem();
                    String title = titleTextField.getText();
                    String content = contentTextArea.getText();

                    JOptionPane.showMessageDialog(null, "글이 작성되었습니다.");
                    dispose();
                    new MenteeView();
                    // TODO: 멘토에게 글 작성하는 코드 작성
                }
            }
        });


        // "뒤로가기" 버튼 생성
        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창을 닫고
                MenteeView menteeView = new MenteeView(); // 이전 창을 생성하여 보여줍니다.
                menteeView.setVisible(true);
            }
        });

        // 패널들을 그리드 형태로 배치
        setLayout(new GridLayout(3, 1));
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        JPanel mentorPanel = new JPanel(new BorderLayout());
        mentorPanel.setBorder(BorderFactory.createTitledBorder("멘토 선택"));
        mentorPanel.add(mentorComboBox, BorderLayout.CENTER);
        topPanel.add(mentorPanel);
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createTitledBorder("제목"));
        titlePanel.add(titleTextField, BorderLayout.CENTER);
        topPanel.add(titlePanel);
        add(topPanel);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createTitledBorder("내용"));
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(backButton);
        bottomPanel.add(writeButton);
        add(contentPanel);
        add(bottomPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}