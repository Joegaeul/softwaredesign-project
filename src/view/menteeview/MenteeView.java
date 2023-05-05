package view.menteeview;

import view.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenteeView extends JFrame implements ActionListener{
    private JLabel label;
    public MenteeView(){
        setTitle("Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 버튼 패널 생성
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        // 버튼 1
        JButton button1 = new JButton("내 멘토 보기");
        button1.addActionListener(this);
        buttonPanel.add(button1);

        // 버튼 2
        JButton button2 = new JButton("내 멘토에게 글 작성");
        button2.addActionListener(this);
        buttonPanel.add(button2);

        // 버튼 3
        JButton button3 = new JButton("전체 멘토 목록 보기");
        button3.addActionListener(this);
        buttonPanel.add(button3);

        // 버튼 4
        JButton button4 = new JButton("마이페이지");
        button4.addActionListener(this);
        buttonPanel.add(button4);

        // 버튼 5
        JButton button5 = new JButton("로그아웃");
        button5.addActionListener(this);
        buttonPanel.add(button5, BorderLayout.SOUTH);

        // 버튼 6
        JButton button6 = new JButton("답장 조회");
        button6.addActionListener(this);
        buttonPanel.add(button6, BorderLayout.SOUTH);

        // 라벨 생성
        label = new JLabel("Click a button");

        // 프레임에 컴포넌트 추가
        add(buttonPanel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        // 프레임 설정
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("내 멘토 보기")) {
            label.setText("내 멘토 보기 clicked");
            dispose();
            new MyMentorListFrame();
        } else if (e.getActionCommand().equals("내 멘토에게 글 작성")) {
            label.setText("내 멘토에게 글 작성 clicked");
            dispose();
            new BoardFrame();
        } else if (e.getActionCommand().equals("전체 멘토 목록 보기")) {
            label.setText("전체 멘토 목록 보기 clicked");
            dispose();
            AllMentorListFrame mentorListFrame = new AllMentorListFrame();
        }else if(e.getActionCommand().equals("마이페이지")){
            label.setText("마이페이지 clicked");
            dispose();
            new MenteeMyPageFrame();
        }else if(e.getActionCommand().equals("로그아웃")){
            label.setText("로그아웃 clicked");
            dispose();
            new LoginFrame();
            JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
        }else if(e.getActionCommand().equals("답장 조회")){
            label.setText("답장 조회 clicked");
            dispose();
            new MentorReplyFrame();
        }
    }
}

