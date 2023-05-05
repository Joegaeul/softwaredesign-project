package view.menteeview;

import view.mentorview.MentorView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMentorListFrame extends JFrame{

    private DefaultTableModel tableModel;

    public MyMentorListFrame() {
        initGUI();
    }

    private void initGUI() {
        setTitle("멘티 목록 리스트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 멘티 목록 테이블 생성
        String[] columns = {"이름", "나이","전화번호","운동 경력"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable menteeTable = new JTable(tableModel);
        menteeTable.setRowHeight(30);

        // 테이블에 스크롤 바 적용
        JScrollPane scrollPane = new JScrollPane(menteeTable);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        add(scrollPane, BorderLayout.CENTER);

        // 목록 샘플 데이터 추가
        String[][] data = {
                {"홍길동", "25", "010-1234-1324","4"},
                {"김철수", "23", "010-1234-1325","3"},
                {"이영희", "28", "010-1234-1326","5"}
        };
        for (String[] row : data) {
            tableModel.addRow(row);
        }

        // "뒤로가기" 버튼 생성
        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창을 닫고
                new MenteeView(); // 이전 창을 생성하여 보여줍니다.
            }
        });

        add(backButton, BorderLayout.SOUTH);

        // 프레임 설정
        setPreferredSize(new Dimension(800, 600));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
