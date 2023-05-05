package view.menteeview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MentorReplyFrame extends JFrame {
    private JComboBox<String> mentorComboBox;
    private JLabel replyLabel;

    private final String[] MENTOR_LIST = {"멘토1", "멘토2", "멘토3"};
    private final String[] MENTOR_REPLY = {"멘토1의 답변", "멘토2의 답변", "멘토3의 답변"};

    public MentorReplyFrame() {
        initGUI();
    }

    private void initGUI() {
        setTitle("멘토의 답변 조회");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mentorComboBox = new JComboBox<>(MENTOR_LIST);

        JButton viewButton = new JButton("조회");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = mentorComboBox.getSelectedIndex();
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(null, "멘토를 선택해주세요.");
                } else {
                    String mentorName = MENTOR_LIST[selectedIndex];
                    String mentorReply = MENTOR_REPLY[selectedIndex];

                    replyLabel.setText("<html><body><h2>" + mentorName + "의 답변</h2><p>" + mentorReply + "</p></body></html>");
                }
            }
        });

        replyLabel = new JLabel();
        replyLabel.setVerticalAlignment(JLabel.TOP);
        replyLabel.setPreferredSize(new Dimension(400, 300));
        JScrollPane scrollPane = new JScrollPane(replyLabel);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("멘토 선택:"));
        topPanel.add(mentorComboBox);
        topPanel.add(viewButton);

        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창 닫기
                new MenteeView();
            }
        });
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(backButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}