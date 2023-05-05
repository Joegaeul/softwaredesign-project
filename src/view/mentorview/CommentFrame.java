package view.mentorview;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentFrame extends JFrame {

    private JComboBox<String> menteeComboBox;
    private JTextField replyTextField;

    public CommentFrame() {
        setTitle("멘티에게 답장하기"); // 제목 설정
        setSize(400, 300); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 종료
        setLocationRelativeTo(null);

        // 멘티 선택 콤보 박스 생성
        String[] mentees = {"멘티1", "멘티2", "멘티3", "멘티4", "멘티5"};
        menteeComboBox = new JComboBox<>(mentees);
        menteeComboBox.setBounds(10, 10, 100, 30);

        // 답장을 입력할 텍스트 필드 생성
        replyTextField = new JTextField();
        replyTextField.setBounds(10, 50, 350, 200);

        // 전송 버튼 생성
        JButton sendButton = new JButton("전송");
        sendButton.setBounds(300, 10, 60, 30);

        // 뒤로 가기 버튼 생성
        JButton backButton = new JButton("뒤로 가기");
        backButton.setBounds(220, 10, 80, 30);

        // 컴포넌트들을 프레임에 추가
        add(menteeComboBox);
        add(replyTextField);
        add(sendButton);
        add(backButton);

        // 전송 버튼 클릭 이벤트 처리
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 선택된 멘티 이름과 입력된 답장 내용을 가져옴
                String menteeName = (String) menteeComboBox.getSelectedItem();
                String replyContent = replyTextField.getText();

                // 선택된 멘티에게 답장을 보냄
                sendReplyToMentee(menteeName, replyContent);

                dispose(); // 현재 창을 닫고
                new MentorView();
            }
        });

        // 뒤로 가기 버튼 클릭 이벤트 처리
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창을 닫고
                new MentorView();
            }
        });

        setLayout(null); // 레이아웃 매니저 설정 안 함
        setVisible(true); // 창 표시
    }

    // 선택된 멘티에게 답장을 보내는 메소드
    private void sendReplyToMentee(String menteeName, String replyContent) {
        // TODO: 선택된 멘티에게 답장을 보내는 코드 작성
    }
}