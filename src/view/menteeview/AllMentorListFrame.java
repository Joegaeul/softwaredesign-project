package view.menteeview;

import controller.MenteeController;
import model.membermodel.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AllMentorListFrame extends JFrame implements  ActionListener{
    private DefaultTableModel tableModel;
    private MenteeController menteeController;
    private JTable mentorTable;

    public AllMentorListFrame(MenteeController menteeController) {
        this.menteeController = menteeController;

        setVisible(true);
        setTitle("멘토 목록");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 멘토 목록 테이블 생성
        String[] columns = {"이름", "나이", "운동 경력", "성별"};
        tableModel = new DefaultTableModel(columns, 0);
        mentorTable = new JTable(tableModel);
        mentorTable.setRowHeight(30);

        // 테이블에 스크롤 바 적용
        JScrollPane scrollPane = new JScrollPane(mentorTable);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        add(scrollPane, BorderLayout.CENTER);

        ArrayList<Member> members = menteeController.readAllMentor();
        for(Member member : members){
            Object[] row = {member.getName(), member.getAge(), member.getSportCareer(), member.getSex()};
            tableModel.addRow(row);
        }

        // 멘토 선택 버튼
        JButton selectBtn = new JButton("선택");
        selectBtn.setPreferredSize(new Dimension(100, 30));
        selectBtn.addActionListener(this);

        // "뒤로가기" 버튼 생성
        JButton backButton = new JButton("뒤로가기");
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(selectBtn);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
        // 프레임 설정
        setPreferredSize(new Dimension(640, 480));
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("선택")){
            int row = mentorTable.getSelectedRow();
            if (row != -1) {
                String mentorName = (String) tableModel.getValueAt(row, 0);
                menteeController.selectMentor(mentorName);
                JOptionPane.showMessageDialog(null,  mentorName + " 멘토를 선택했습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "멘토를 선택해주세요.");
            }
        }
        else if(e.getActionCommand().equals("뒤로가기")){
            dispose();
            menteeController.goMenteeView();
        }
    }
}
