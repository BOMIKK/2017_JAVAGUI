package file;

import java.io.*;
import java.util.*;

public class PhoneBook {
	public static void main(String[] args) throws Exception {
		HashMap<String, String> hm = new HashMap<String, String>();

		int i = 0;

		FileReader fr = new FileReader(("c:\\Temp\\phone.txt"));
		Scanner s = new Scanner(fr);
		Scanner c = new Scanner(System.in);

		// ���� ����

		while (s.hasNext()) {

			String key = s.nextLine();

			String book[] = key.split(" ");

			hm.put(book[0], book[1]);

			i++;
		}

		System.out.println("�� " + i + "���� ��ȭ��ȣ�� �о����ϴ�.");

		while (true) {

			System.out.print("�̸�>> ");
			String name = c.nextLine();
			if (name.equals("�׸�"))
				break;

			if (hm.get(name) == null) {
				System.out.println("ã�� �̸��� �����ϴ�.");
			}
			else {
				System.out.println(hm.get(name));

			}

		}
		s.close();

	}

}
