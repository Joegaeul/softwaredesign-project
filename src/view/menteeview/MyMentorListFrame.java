package view.menteeview;

import controller.MenteeController;
import model.mentormodel.Mentor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class MyMentorListFrame extends JFrame{

    private DefaultTableModel tableModel;
    private MenteeController menteeController;

    public MyMentorListFrame(MenteeController menteeController) {
        this.menteeController = menteeController;

        setVisible(true);
        setTitle("멘토 목록 리스트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 멘토 목록 테이블 생성
        String[] columns = {"이름", "나이","성별", "전화번호", "이메일"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable menteeTable = new JTable(tableModel);
        menteeTable.setRowHeight(30);

        // 테이블에 스크롤 바 적용
        JScrollPane scrollPane = new JScrollPane(menteeTable);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        add(scrollPane, BorderLayout.CENTER);


        // 목록 샘플 데이터 추가
        Set<Mentor> members = menteeController.readMyMentorInfo();
        for(Mentor member:members){
            Object[] row = {member.getName(), member.getAge(), member.getSex(), member.getPhoneNumber(),member.getEmail()};
            tableModel.addRow(row);
        }

        // "뒤로가기" 버튼 생성
        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창을 닫고
                menteeController.goMenteeView();
            }
        });

        add(backButton, BorderLayout.SOUTH);

        // 프레임 설정
        setPreferredSize(new Dimension(800, 600));
        pack();
        setLocationRelativeTo(null);
    }
}
