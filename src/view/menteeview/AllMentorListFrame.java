package view.menteeview;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllMentorListFrame extends JFrame {

    private DefaultTableModel tableModel;

    public AllMentorListFrame() {
        initGUI();
    }
    private void initGUI() {
        setTitle("멘토 목록");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 멘토 목록 테이블 생성
        String[] columns = {"이름", "나이","운동 경력" ,"한줄 소개"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable mentorTable = new JTable(tableModel);
        mentorTable.setRowHeight(30);

        // 테이블에 스크롤 바 적용
        JScrollPane scrollPane = new JScrollPane(mentorTable);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        add(scrollPane, BorderLayout.CENTER);

        // 목록 샘플 데이터 추가
        String[][] data = {
                {"홍길동", "25","4", "반갑습니다."},
                {"김철수", "23","3", "열심히 운동합시다"},
                {"이영희", "28","5", "득근"}
        };
        for (String[] row : data) {
            tableModel.addRow(row);
        }

        // 멘토 선택 버튼
        JButton selectBtn = new JButton("선택");
        selectBtn.setPreferredSize(new Dimension(50, 30));
        selectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = mentorTable.getSelectedRow();
                if (row != -1) {
                    String mentorName = (String) tableModel.getValueAt(row, 0);
                    JOptionPane.showMessageDialog(null, mentorName + " 멘토를 선택했습니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "멘토를 선택해주세요.");
                }
            }
        });
        add(selectBtn, BorderLayout.NORTH);

        // "뒤로가기" 버튼 생성
        JButton backButton = new JButton("뒤로가기");
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창을 닫고
                MenteeView menteeView = new MenteeView(); // 이전 창을 생성하여 보여줍니다.
            }
        });

        add(backButton, BorderLayout.SOUTH);

        // 프레임 설정
        setPreferredSize(new Dimension(640, 480));
        pack();
        setLocationRelativeTo(null);
    }
}
