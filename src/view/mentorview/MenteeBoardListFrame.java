package view.mentorview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenteeBoardListFrame extends JFrame {

    private JComboBox<String> menteeComboBox;
    private JTextArea contentTextArea;
    private JButton backButton;

    public MenteeBoardListFrame() {
        setTitle("멘티가 작성한 글 보기"); // 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 종료

        // 멘티 선택 콤보 박스 생성
        String[] mentees = {"멘티1", "멘티2", "멘티3", "멘티4", "멘티5"};
        menteeComboBox = new JComboBox<>(mentees);

        // 내용을 보여줄 텍스트 영역 생성
        contentTextArea = new JTextArea();
        contentTextArea.setColumns(30); // 컬럼 수 지정
        contentTextArea.setRows(10); // 행 수 지정
        contentTextArea.setEditable(false); // 수정 불가능하도록 설정

        // 스크롤바 추가
        JScrollPane scrollPane = new JScrollPane(contentTextArea);

        backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 프레임 닫기
                new MentorView();
            }
        });

        // 멘토 선택 콤보 박스 선택 이벤트 처리
        menteeComboBox.addActionListener(e -> {
            String menteeName = (String) menteeComboBox.getSelectedItem();
            String content = getContentByMentee(menteeName);
            contentTextArea.setText(content);
        });

        // 컴포넌트들을 패널에 추가
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(menteeComboBox, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);

        pack(); // 컴포넌트 크기에 맞게 창 크기 조절
        setLocationRelativeTo(null);
        setVisible(true); // 창 표시
    }

    // 멘티 이름에 해당하는 글의 내용을 반환하는 메소드
    private String getContentByMentee(String menteeName) {
        // TODO: 멘티 이름에 해당하는 글의 내용을 반환하는 코드 작성
        return "";
    }
}
