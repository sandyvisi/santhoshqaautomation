package testPages;

public class CharCount {
	public static void main(String[] args) {

		String word = "aabbbccccdd";

		String out = "";

		char[] ch = word.toCharArray();

		int count = 1;

		for (int i = 0; i < word.length(); i++) {

			if (i < word.length() - 1 && ch[i] == ch[i + 1]) {

				count++;

			} else {
				out = out + ch[i] + count;
				count = 1;
			}

		}

		System.out.println(out);
	}

}
