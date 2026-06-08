package testPages;

public class BiggestPalindrome {

	public static void main(String[] args) {

		String palind = "abcbader";

		char[] chars = palind.toCharArray();

		String newPalind = "";

		for (int i = 0; i < chars.length; i++) {

//			newPalind = newPalind + palind.charAt(i);

			if (newPalind.indexOf(chars[i]) == -1) {

				newPalind = newPalind + palind.charAt(i);

			}

		}
		System.out.println(newPalind);

	}

}
