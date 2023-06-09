package view.menteeview;
import controller.MenteeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenteeMyPageFrame extends JFrame implements ActionListener {

    private JTextField heightField, weightField, muscleField;
    private MenteeController menteeController;

    public MenteeMyPageFrame(MenteeController menteeController) {
        this.menteeController = menteeController;

        // 인바디 정보 입력 패널
        JPanel bodyInfoPanel = new JPanel(new GridLayout(4, 2));
        bodyInfoPanel.setBorder(BorderFactory.createTitledBorder("인바디 정보"));

        JLabel heightLabel = new JLabel("키(cm): ");
        heightField = new JTextField(10);
        bodyInfoPanel.add(heightLabel);
        bodyInfoPanel.add(heightField);

        JLabel weightLabel = new JLabel("몸무게(kg): ");
        weightField = new JTextField(10);
        bodyInfoPanel.add(weightLabel);
        bodyInfoPanel.add(weightField);

        JLabel muscleLabel = new JLabel("근육량(kg): ");
        muscleField = new JTextField(10);
        bodyInfoPanel.add(muscleLabel);
        bodyInfoPanel.add(muscleField);

        add(bodyInfoPanel, BorderLayout.CENTER);

        // 인바디 정보 수정 버튼
        JButton updateButton = new JButton("수정");
        updateButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("수정")) {
            try {
                Double height = Double.parseDouble(heightField.getText());
                Double weight = Double.parseDouble(weightField.getText());
                Double muscle = Double.parseDouble(muscleField.getText());

                // 입력된 인바디 정보 저장
                menteeController.updateMyPage(height, weight, muscle);
                JOptionPane.showMessageDialog(null, "인바디 정보가 수정되었습니다.");
                dispose();
                menteeController.goMenteeView();
            }catch(NumberFormatException a){
                JOptionPane.showMessageDialog(null, "정보를 잘못 입력했습니다.");
            }
        }
    }
}
