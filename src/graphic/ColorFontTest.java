package graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorFontTest extends JFrame {
	public ColorFontTest() {

		setTitle("Color,Font ��� ����");
		setSize(700, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		MyPanel panel = new MyPanel();
		c.add(panel, BorderLayout.CENTER);

		setVisible(true);
	}

	class MyPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.setFont(new Font("�ü�ü", Font.BOLD, 30));
			g.drawString("����:���ѹα�(�ü� ��Ʈ)", 20, 40);

			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("�������üB", Font.BOLD + Font.ITALIC, 30));
			g.drawString("�ּ�:����� ������(�������üB ��Ʈ)", 20, 90);

			g.setColor(Color.YELLOW);
			g.setFont(new Font("�޸ո���ü", Font.BOLD + Font.ITALIC, 30));
			g.drawString("����: �躸��(�޸ո���ü ��Ʈ)", 20, 160);

			g.setColor(Color.GRAY);
			g.setFont(new Font("HY����", Font.BOLD, 15));
			g.drawString("�й�: 2016(HY����B ��Ʈ)", 15, 200);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ColorFontTest();
	}

}
