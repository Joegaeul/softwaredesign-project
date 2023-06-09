package view.mentorview;

import controller.MentorController;
import model.menteemodel.Mentee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenteeListFrame extends JFrame{

    private DefaultTableModel tableModel;
    private MentorController mentorController;

    public MenteeListFrame(MentorController menteeController) {
        this.mentorController = menteeController;

        setTitle("멘티 목록 리스트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 멘티 목록 테이블 생성
        String[] columns = {"이름", "나이", "성별", "키", "몸무게", "근육량","운동경력"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable menteeTable = new JTable(tableModel);
        menteeTable.setRowHeight(30);


        // 테이블에 스크롤 바 적용
        JScrollPane scrollPane = new JScrollPane(menteeTable);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        add(scrollPane, BorderLayout.CENTER);

        // 목록 샘플 데이터 추가
        ArrayList<Mentee> members = mentorController.readMyMenteeInfo();
        for(Mentee member:members){
            Object[] row = {member.getName(), member.getAge(), member.getSex() ,member.getHeight() , member.getWeight(), member.getMuscleMass(),member.getSportCareer()};
            tableModel.addRow(row);
        }


        // "뒤로가기" 버튼 생성
        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창을 닫고
                menteeController.goMentorView();
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




