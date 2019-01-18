import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMoveEx extends JFrame {

    private JLabel coords;
    private JLabel clickCoords;

    public MouseMoveEx(){
        initUI();
    }

    private void initUI() {

        coords = new JLabel("what");
        clickCoords = new JLabel("the");

        createLayout(coords, clickCoords);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX();
                int y = e.getY();
                String text = String.format("Click at x: %d, y: %d", x, y);
                clickCoords.setText(text);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                int x = e.getX();
                int y = e.getY();
                var text = String.format("x: %d, y: %d", x, y);
                coords.setText(text);
            }
        });

        setTitle("Mouse move events");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg){
        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        pack();
        setVisible(true);
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            var ex = new MouseMoveEx();
//            ex.setVisible(true);
//        });
//    }
}
