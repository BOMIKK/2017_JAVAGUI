package graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorFontTest extends JFrame {
	public ColorFontTest() {

		setTitle("Color,Font 사용 예제");
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
			g.setFont(new Font("궁서체", Font.BOLD, 30));
			g.drawString("국적:대한민국(궁서 폰트)", 20, 40);

			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("양재깨비체B", Font.BOLD + Font.ITALIC, 30));
			g.drawString("주소:서울시 마포구(양재깨비체B 폰트)", 20, 90);

			g.setColor(Color.YELLOW);
			g.setFont(new Font("휴먼매직체", Font.BOLD + Font.ITALIC, 30));
			g.drawString("성명: 김보미(휴먼매직체 폰트)", 20, 160);

			g.setColor(Color.GRAY);
			g.setFont(new Font("HY나무", Font.BOLD, 15));
			g.drawString("학번: 2016(HY나무B 폰트)", 15, 200);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ColorFontTest();
	}

}
