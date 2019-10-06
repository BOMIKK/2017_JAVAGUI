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

		// 문자 저장

		while (s.hasNext()) {

			String key = s.nextLine();

			String book[] = key.split(" ");

			hm.put(book[0], book[1]);

			i++;
		}

		System.out.println("총 " + i + "개의 전화번호를 읽었습니다.");

		while (true) {

			System.out.print("이름>> ");
			String name = c.nextLine();
			if (name.equals("그만"))
				break;

			if (hm.get(name) == null) {
				System.out.println("찾는 이름이 없습니다.");
			}
			else {
				System.out.println(hm.get(name));

			}

		}
		s.close();

	}

}
