package List;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class FontTest extends JFrame {
	// 폰트
	String strfont[] = { "굴림", "돋움", "궁서" };
	JRadioButton font[] = new JRadioButton[3];

	// 스타일
	String strstyle[] = { "BOLD", "ITALIC" };
	JCheckBox style[] = new JCheckBox[2];

	// 사이즈
	String strsize[] = { "5", "10", "15", "20", "25", "30" };
	JComboBox<String> size = new JComboBox(strsize);
	JPanel[] p = new JPanel[7];
	JTextField tf;
	JLabel result1, result2;

	String rs1;// font
	int n, rs2;// size,style

	public FontTest() {
		setTitle("Font 설정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(0, 1, 5, 5));

		MyFontListener cl = new MyFontListener();

		for (int i = 0; i < p.length; i++) {
			p[i] = new JPanel();
			c.add(p[i]);
		}

		// Font 설정 p[0]
		p[0].setLayout(new GridLayout(0, 1));
		p[0].add(new JLabel("Font 설정"));
		ButtonGroup gfont = new ButtonGroup();
		for (int i = 0; i < font.length; i++) {
			font[i] = new JRadioButton(strfont[i]);
			gfont.add(font[i]);
			font[i].addActionListener(new MyFontListener());
			p[1].add(font[i]);
		}
		font[0].setSelected(true);
		p[3].setLayout(new GridLayout(0, 1));
		p[3].add(p[1]);

		// Style 설정 p[1]
		p[0].add(new JLabel("Style 설정"));
		for (int i = 0; i < style.length; i++) {
			style[i] = new JCheckBox(strstyle[i]);
			style[i].addItemListener(new MyFontListener());
			p[2].add(style[i]);
		}
		p[3].add(p[2]);

		// Size 설정 p[2]
		p[0].add(new JLabel("Size 설정"));
		size.addActionListener(new MyFontListener());
		p[3].add(size);

		// Text 내용 p[3]
		p[0].add(new JLabel("Text 내용"));
		tf = new JTextField(10);
		tf.addActionListener(new MyFontListener());
		p[3].add(tf);

		// Font 설정결과 p[5]
		p[4].setLayout(new BorderLayout());
		p[4].add(p[0], BorderLayout.WEST);
		p[4].add(p[3], BorderLayout.CENTER);

		Border resultBorder = BorderFactory.createTitledBorder("Font 설정 결과");
		p[5].setBorder(resultBorder);
		result1 = new JLabel();
		p[5].add(result1);

		p[6].setLayout(new BorderLayout());
		p[6].add(p[4]);
		p[6].add(p[5], BorderLayout.SOUTH);

		setSize(300, 250);
		setVisible(true);

	}

	class MyFontListener implements ActionListener, ItemListener {

		public void actionPerformed(ActionEvent e) {

			// 폰트
			if (font[0].isSelected()) {
				rs1 = strfont[0];
			} else if (font[1].isSelected()) {
				rs1 = strfont[1];
			} else {
				rs1 = strfont[2];
			}

			// 사이즈
			n = Integer.parseInt(strsize[size.getSelectedIndex()]);

			result1.setText(tf.getText());
			result1.getFont().getStyle();
			result1.setFont(new Font(rs1, rs2, n));

		}

		public void itemStateChanged(ItemEvent e) {

			result1.setText(tf.getText());
			if (style[0].isSelected() && style[1].isSelected()) {

				rs2 = Font.BOLD + Font.ITALIC;

			} else if (style[1].isSelected()) {
				rs2 = Font.ITALIC;

			} else if (style[0].isSelected()) {
				rs2 = Font.BOLD;

			} else {

				rs2 = Font.PLAIN;

			}
			result1.setText(tf.getText());
			result1.getFont().getStyle();
			result1.setFont(new Font(rs1, rs2, n));

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FontTest();
	}

}
