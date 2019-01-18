import javax.swing.*;
import java.awt.*;

public class ButtonExample extends JFrame {

    public ButtonExample(){
        initUI();
    }

    private void initUI(){
        JButton button = new JButton("Quit");
        button.addActionListener((event) -> System.exit(0));

        JLabel label = new JLabel("Hello World!");

        createLayout(label, button);

        setTitle("Quit Button");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {
        var pane = getContentPane();
        //GroupLayout
        var layout = new GroupLayout(pane);
        pane.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1]));
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1]));
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            var ex = new ButtonExample();
            ex.setVisible(true);
        });
    }
}
