package file;

import java.io.*;
import java.util.*;

public class PhoneSave {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("��ȭ��ȣ �Է� ���α׷��Դϴ�.");

		FileWriter fw = new FileWriter(("c:\\Temp\\phone.txt"));
		while (true) {
			System.out.print("�̸� ��ȭ��ȣ>>: ");
			String name = s.nextLine();

			if (name.equals("�׸�"))

				break;

			fw.write(name);
			fw.write("\r\n");
		}
		System.out.println("c:\\Temp\\phone.txt�� �����Ͽ����ϴ�.");
		fw.close();

	}

}
