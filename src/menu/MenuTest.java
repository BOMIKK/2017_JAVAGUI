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
		setTitle("Menu �����");
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		lb = new JLabel("Text");
		lb.setToolTipText("������ ���� ������ �����Դϴ�.");
		c.add(lb);
		setVisible(true);

	}

	void createMenu() {
		mb = new JMenuBar();

		// ����
		menuFile = new JMenu("����");
		miOpen = new JMenuItem("����");
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
		miSave = new JMenuItem("����");
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
		miClose = new JMenuItem("����");
		miClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "���� Ȯ��", JOptionPane.YES_NO_OPTION);

				if (r == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}

		});

		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.addSeparator();
		menuFile.add(miClose);

		// ����
		menuEdit = new JMenu("����");
		miColor = new JMenuItem("�� ����");
		miColor.addActionListener(new ActionListener() {

			JColorChooser c = new JColorChooser();

			public void actionPerformed(ActionEvent e) {
				Color selectedColor = c.showDialog(null, "Color", Color.CYAN);
				if (selectedColor != null) {
					lb.setForeground(selectedColor);
				}
			}

		});
		miFont = new JMenuItem("��Ʈ");

		class MyDialog extends JDialog {

			JCheckBox fontStyle[] = new JCheckBox[2];
			JTextField tf;
			JButton btn;
			JComboBox cb;
			JPanel p[] = new JPanel[8];
			String nn[] = { "����", "����", "���", "����" };
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
				p[0].add(new JLabel("��Ʈ ����"));
				p[0].add(new JLabel("��Ʈ ��Ÿ��"));
				p[0].add(new JLabel("��Ʈ ũ��"));

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

				btn = new JButton("����");
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
		miText = new JMenuItem("�ؽ�Ʈ ����");
		miText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = JOptionPane.showInputDialog("�������ؽ�Ʈ�� �Է��ϼ���");
				lb.setText(name);

			}

		});
		menuEdit.add(miColor);
		menuEdit.add(miFont);
		menuEdit.addSeparator();
		menuEdit.add(miText);

		// ����
		menuHelp = new JMenu("����");
		miVersion = new JMenuItem("��������");
		miVersion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "�׽�Ʈv1.0", "Ȯ��", JOptionPane.INFORMATION_MESSAGE);

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
