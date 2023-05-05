package view.menteeview;
import javax.swing.*;
import java.awt.*;

public class MenteeMyPageFrame extends JFrame {

    private JTextField heightField, weightField, fatField, muscleField;

    public MenteeMyPageFrame() {
        initGUI();
    }

    private void initGUI() {

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

        JLabel fatLabel = new JLabel("체지방률(%): ");
        fatField = new JTextField(10);
        bodyInfoPanel.add(fatLabel);
        bodyInfoPanel.add(fatField);

        JLabel muscleLabel = new JLabel("근육량(kg): ");
        muscleField = new JTextField(10);
        bodyInfoPanel.add(muscleLabel);
        bodyInfoPanel.add(muscleField);

        add(bodyInfoPanel, BorderLayout.CENTER);

        // 인바디 정보 수정 버튼
        JButton updateButton = new JButton("수정");
        updateButton.addActionListener(e -> {
            String height = heightField.getText();
            String weight = weightField.getText();
            String fat = fatField.getText();
            String muscle = muscleField.getText();

            // TODO: 입력된 인바디 정보를 서버에 전송하여 저장하는 코드 작성
            JOptionPane.showMessageDialog(null, "인바디 정보가 수정되었습니다.");
            dispose();
            new MenteeView();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
