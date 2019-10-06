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
		System.out.println("가장 큰 파일은 "+list[max].getPath()+" "
				+list[max].length()+"바이트");

	}

}
