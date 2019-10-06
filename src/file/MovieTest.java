package file;

import java.util.*;
import java.io.*;

class Movie implements Serializable {
	String title;
	String director;
	String genre;
	int year;

	public Movie(String t, String d, String g, int y) {
		title = t;
		director = d;
		genre = g;
		year = y;
	}

	public String toString() {
		return "[����:" + title + ", ����:" + director + ", �帣:" + genre + ", �����⵵:" + year + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}

public class MovieTest {

	public static void main(String[] args) throws Exception {
		Vector<Movie> b = new Vector<Movie>();
		Scanner s = new Scanner(System.in);
		int menu = 0;
		while (true) {
			System.out.println("1.��ȭ �Է�/2.��ȭ ���/3.��ȭ �˻�/4.���� ����/5.���� ����/6.����");
			System.out.print("�޴��Է�>>");
			menu = s.nextInt();
			s.nextLine();
			if (menu == 6)
				break;
			switch (menu) {
			case 1:// ��ȭ �Է�
				System.out.print("����:");
				String t = s.nextLine();
				System.out.print("����:");
				String d = s.nextLine();
				System.out.print("�帣:");
				String g = s.nextLine();
				System.out.print("�⵵:");
				int y = s.nextInt();

				b.add(new Movie(t, d, g, y));

				break;
			case 2:// ��ȭ ���
				for (int i = 0; i < b.size(); i++) {
					System.out.println(b.get(i));
				}
				break;
			case 3:// ��ȭ �˻�
				System.out.print("�˻��� ��ȭ ���� �Է�:");
				String search = s.nextLine();

				for (int i = 0; i < b.size(); i++) {
					if (search.equals(b.get(i).getTitle()))

						System.out.println(b.get(i));

				}
				break;
			case 4:// ���� ����
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat"));
				System.out.println("movie.dat�� ����Ǿ����ϴ�.");
				oos.writeObject(b);

				oos.close();

				break;
			case 5:// ���� ����
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movie.dat"));
				System.out.println("movie.dat�� ���� ������ �ҷ��Խ��ϴ�.");
				b = (Vector<Movie>) ois.readObject();

				ois.close();
				break;

			}

		}

	}

}
