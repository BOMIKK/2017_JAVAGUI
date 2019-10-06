package move;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MouseWheelFrame extends JFrame {

	JPanel p1;
	JLabel l1;

	public MouseWheelFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LEFT 키로 문자열 이동");

		setLayout(new FlowLayout());
		setSize(300, 100);

		
		p1 = new JPanel();
		setContentPane(p1);

		l1 = new JLabel("Love Java");
		l1.addMouseWheelListener(new MyMouseWheelListener());

		p1.add(l1);
		setVisible(true);

		l1.setFocusable(true);
		l1.requestFocus();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MouseWheelFrame();
	}

	class MyMouseWheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			JLabel b=(JLabel)e.getSource();
			Font f = b.getFont();
			int size = f.getSize();
			int a =e.getWheelRotation();
			
			if (a==-1) {
				b.setFont(new Font("TimesRoman", Font.PLAIN, size + 5));

			} else if (a == 1 && !(f.getSize() - 5 <= 5)) {

				b.setFont(new Font("TimesRoman", Font.PLAIN, size - 5));

			}
			
		}

		
		}

	}

