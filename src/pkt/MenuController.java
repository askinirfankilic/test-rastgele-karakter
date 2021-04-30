package pkt;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuController extends TextContents {
	static IKarakter karakterYoneticisi = new Karakter();
	static Scanner scn = new Scanner(System.in);

	public static void mainMenuController() {

		TextContents.mainMenu();
		int input = scn.nextInt();
		switch (input) {
		case 1: {
			TextContents.rastgeleKarakterMenu();
			branchToRastgeleKarakter();

			break;
		}
		case 2: {
			TextContents.rastgeleKelimeMenu();
			branchToRastgeleKelime();
			break;
		}
		case 3: {
			TextContents.output();
			branchToRastgeleCumle();
			mainMenuController();
			break;
		}
		case 4: {
			System.exit(0);
			scn.close();
			break;
		}
		default:
			throw new IllegalArgumentException("Beklenmeyen deger: " + input);
		}
	}

	public static void rastgeleKarakterMenuController() {

		int input = scn.nextInt();
		switch (input) {
		case 1: {
			TextContents.output();
			char karakter = karakterYoneticisi.rastgeleKarakter();

			System.out.print(karakter);
			System.out.println();
			System.out.println();
			System.out.println();

			TextContents.rastgeleKarakterMenu();
			rastgeleKarakterMenuController();
			input = scn.nextInt();
			break;
		}
		case 2: {
			TextContents.ilkKarakterInput();
			char ilk = scn.next().charAt(0);
			TextContents.sonKarakterInput();
			char son = scn.next().charAt(0);

			TextContents.output();
			char karakter = karakterYoneticisi.rastgeleKarakter(ilk, son);

			System.out.print(karakter);
			System.out.println();
			System.out.println();
			System.out.println();

			TextContents.rastgeleKarakterMenu();
			rastgeleKarakterMenuController();
			input = scn.nextInt();
			break;
		}
		case 3: {
			branchToMainMenu();
			break;
		}
		case 4: {
			System.exit(0);
			scn.close();
			break;
		}
		default:
			throw new IllegalArgumentException("Beklenmeyen deger: " + input);
		}
	}

	public static void rastgeleKelimeMenuController() {

		int input = scn.nextInt();
		switch (input) {
		case 1: {
			int kelimeUzunlugu = 5;
			TextContents.output();
			String kelime = karakterYoneticisi
					.getStringRepresentation(karakterYoneticisi.rastgeleKelime(kelimeUzunlugu));

			System.out.print(kelime);
			System.out.println();
			System.out.println();
			System.out.println();

			TextContents.rastgeleKelimeMenu();
			rastgeleKelimeMenuController();
			break;
		}
		case 2: {
			int kelimeUzunlugu = 5;
			TextContents.ilkKarakterInput();
			char ilk = scn.next().charAt(0);
			TextContents.sonKarakterInput();
			char son = scn.next().charAt(0);

			TextContents.output();
			String kelime = karakterYoneticisi
					.getStringRepresentation(karakterYoneticisi.rastgeleKelime(ilk, son, kelimeUzunlugu));
			System.out.print(kelime);
			System.out.println();
			System.out.println();
			System.out.println();

			TextContents.rastgeleKelimeMenu();
			rastgeleKelimeMenuController();
			
			break;
		}
		case 3: {
			branchToMainMenu();
			break;
		}

		case 4: {
			System.exit(0);
			scn.close();
			break;
		}
		default:
			throw new IllegalArgumentException("Beklenmeyen deger: " + input);
		}
	}

	private static void branchToRastgeleKarakter() {

		rastgeleKarakterMenuController();

	}

	private static void branchToRastgeleKelime() {
		
		rastgeleKelimeMenuController();
	}

	private static void branchToRastgeleCumle() {

		ArrayList<String> cumle = karakterYoneticisi.rastgeleCumle();
		for (String kelime : cumle) {
			System.out.print(kelime);
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}

	private static void branchToMainMenu() {
		
		mainMenuController();

	}

}
