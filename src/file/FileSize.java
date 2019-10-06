package file;

import java.io.*;
import java.util.*;

public class FileSize {

	public static void main(String[] args) throws Exception {

		File f = new File("c:\\");
		File[] list = f.listFiles();

		int max = 0;

		for (int i = 1; i < list.length; i++) {
			if (list[max].length() < list[i].length())
				max = i;
			
		}
		System.out.println("���� ū ������ "+list[max].getPath()+" "
				+list[max].length()+"����Ʈ");

	}

}
