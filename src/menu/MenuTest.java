package menu;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.awt.*;

public class MenuTest extends JFrame {
	JMenuBar mb;
	JMenu menuFile, menuEdit, menuHelp;
	JMenuItem miOpen, miSave, miClose;
	JMenuItem miColor, miFont, miText;
	JMenuItem miVersion;
	JFileChooser fc = new JFileChooser();
	JLabel lb;

	public MenuTest() {
		setTitle("Menu 만들기");
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		lb = new JLabel("Text");
		lb.setToolTipText("편집에 따라 변경할 영역입니다.");
		c.add(lb);
		setVisible(true);

	}

	void createMenu() {
		mb = new JMenuBar();

		// 파일
		menuFile = new JMenu("파일");
		miOpen = new JMenuItem("열기");
		miOpen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int r = fc.showOpenDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					String s = fc.getSelectedFile().getPath();
					lb.setText(s);
				}

			}

		});
		miSave = new JMenuItem("저장");
		miSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int r = fc.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					String s = fc.getSelectedFile().getPath();
					lb.setText(s);
				}

			}

		});
		miClose = new JMenuItem("종료");
		miClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);

				if (r == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}

		});

		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.addSeparator();
		menuFile.add(miClose);

		// 편집
		menuEdit = new JMenu("편집");
		miColor = new JMenuItem("색 선택");
		miColor.addActionListener(new ActionListener() {

			JColorChooser c = new JColorChooser();

			public void actionPerformed(ActionEvent e) {
				Color selectedColor = c.showDialog(null, "Color", Color.CYAN);
				if (selectedColor != null) {
					lb.setForeground(selectedColor);
				}
			}

		});
		miFont = new JMenuItem("폰트");

		class MyDialog extends JDialog {

			JCheckBox fontStyle[] = new JCheckBox[2];
			JTextField tf;
			JButton btn;
			JComboBox cb;
			JPanel p[] = new JPanel[8];
			String nn[] = { "굴림", "돋음", "고딕", "명조" };
			String sn[] = { "Bold", "italic" };
			String rs;
			int rs2, n, m;

			public MyDialog(JFrame frame, String title) {
				super(frame, title, true);
				setTitle("");
				setSize(250, 170);

				Container c = getContentPane();
				c.setLayout(new GridLayout(0, 1));
				for (int i = 0; i < p.length; i++) {
					p[i] = new JPanel();

				}

				p[0].setLayout(new GridLayout(0, 1));
				p[3].setLayout(new GridLayout(0, 1));

				// 1
				p[0].add(new JLabel("폰트 종류"));
				p[0].add(new JLabel("폰트 스타일"));
				p[0].add(new JLabel("폰트 크기"));

				// 2,3
				cb = new JComboBox(nn);
				cb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						n = cb.getSelectedIndex();
						rs = nn[n];
					}

				});

				for (int i = 0; i < fontStyle.length; i++) {
					fontStyle[i] = new JCheckBox(sn[i]);
					fontStyle[i].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (fontStyle[0].isSelected() && fontStyle[1].isSelected()) {

								rs2 = Font.BOLD + Font.ITALIC;

							} else if (fontStyle[1].isSelected()) {
								rs2 = Font.ITALIC;

							} else if (fontStyle[0].isSelected()) {
								rs2 = Font.BOLD;

							} else {

								rs2 = Font.PLAIN;

							}

						}

					});
					p[2].add(fontStyle[i]);
				}

				tf = new JTextField(7);

				p[3].add(cb);
				p[3].add(p[2]);
				p[3].add(tf);

				p[4].setLayout(new BorderLayout());
				p[4].add(p[0], BorderLayout.WEST);
				p[4].add(p[3]);

				btn = new JButton("설정");
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						lb.setFont(new Font(rs, rs2, Integer.parseInt(tf.getText())));
					}

				});
				p[5].add(btn);
				p[4].add(p[5], BorderLayout.SOUTH);

				c.add(p[4], BorderLayout.CENTER);

			}

		}
		miFont.addActionListener(new ActionListener() {

			MyDialog dialog = new MyDialog(null, "");

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				dialog.setVisible(true);

			}

		});
		miText = new JMenuItem("텍스트 변경");
		miText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = JOptionPane.showInputDialog("변경할텍스트를 입력하세요");
				lb.setText(name);

			}

		});
		menuEdit.add(miColor);
		menuEdit.add(miFont);
		menuEdit.addSeparator();
		menuEdit.add(miText);

		// 도움말
		menuHelp = new JMenu("도움말");
		miVersion = new JMenuItem("버전정보");
		miVersion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "테스트v1.0", "확인", JOptionPane.INFORMATION_MESSAGE);

			}

		});
		menuHelp.add(miVersion);

		this.setJMenuBar(mb);
		mb.add(menuFile);
		mb.add(menuEdit);
		mb.add(menuHelp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MenuTest();
	}

}
