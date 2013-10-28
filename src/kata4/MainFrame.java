package kata4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

    private final static double SCREEN_SIZE = 0.8;
    private JButton button;
    private JButton button2;
    private JTextField field;
    private JComboBox comboBox;

    public MainFrame() {
        this.setTitle("Hola Mundo");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        this.setSize((int) (screenSize.width * SCREEN_SIZE), (int) (screenSize.height * SCREEN_SIZE));
        this.setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(200, 200));
        this.setMaximumSize(new Dimension(400, 400));
        this.setVisible(true);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(createPanel());
        this.add(createPanel2());
    }

    private JButton createButton() {
        button = new JButton("Click");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                button.setText("Clicked");
            }
        });
        return button;
    }

    private JButton createButton2() {
        button2 = new JButton("Click");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                button2.setText("Clicked");
            }
        });
        return button2;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.add(createLabel());
        panel.add(createTextField());
        panel.add(createComboBox());
        return panel;
    }

    private JPanel createPanel2() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.add(createButton2());
        return panel;
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("Name");
        return label;
    }

    private JTextField createTextField() {
        field = new JTextField("Insert your name", 40);
        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                refresh();
            }
        });
        return field;
    }

    private JComboBox createComboBox() {
        comboBox = new JComboBox(new String[]{"Euros", "Dollars"});
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    refresh();
            }
        });
        return comboBox;
    }

    private void refresh() {
        this.setTitle(field.getText() + " " + comboBox.getSelectedItem());
    }
}
