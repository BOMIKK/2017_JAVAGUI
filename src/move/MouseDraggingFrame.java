package move;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
package move;

import javax.swing.JPanel;

public class MouseDraggingFrame extends JFrame {

	JPanel J1;

	public MouseDraggingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("µå·¡±ëµ¿¾È YELLOW");

		J1 = new JPanel();
		setContentPane(J1);
		J1.addMouseMotionListener(new MyMotionListener());

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MouseDraggingFrame();
	}

	class MyMotionListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			JPanel b = (JPanel) e.getSource();
			b.setBackground(Color.YELLOW);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			JPanel b = (JPanel) e.getSource();
			b.setBackground(Color.GREEN);
		}

	}

}
