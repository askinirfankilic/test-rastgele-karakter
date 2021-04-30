package pkt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

class KarakterTest {

	private static IKarakter karakterYoneticisi;
	private static Faker faker;

	@BeforeEach
	public void setUp() {
		karakterYoneticisi = new Karakter();
		faker = new Faker();
	}

	@DisplayName("Rastgele KARAKTER boundary testi")
	@RepeatedTest(10)
	void rastgeleKarakterBoundaryTest() {
		int a = karakterYoneticisi.rastgeleKarakter();

		boolean buyukHarf = (a >= 65 && a <= 90);
		boolean kucukHarf = (a >= 97 && a <= 122);

		assertTrue(kucukHarf || buyukHarf);
	}

	@DisplayName("Karakter havuzlu rastgele KARAKTER boundary testi")
	@RepeatedTest(10)
	void karakterHavuzluRastgeleKarakterBoundaryTest() {
		int a = karakterYoneticisi.rastgeleKarakter('c', 'i', 'b');

		boolean buyukHarf = (a >= 65 && a <= 90);
		boolean kucukHarf = (a >= 97 && a <= 122);

		assertTrue(kucukHarf || buyukHarf);
	}

	@DisplayName("Boundaryli rastgele KARAKTER boundary testi")
	@RepeatedTest(10)
	void boundaryliRastgeleKarakterBoundaryTest() {
		int a = karakterYoneticisi.rastgeleKarakter('a', 'i');

		boolean buyukHarf = (a >= 65 && a <= 90);
		boolean kucukHarf = (a >= 97 && a <= 122);

		assertTrue(kucukHarf || buyukHarf);
	}

	@DisplayName("KELIME uzunlugu testi")
	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 3, 2, 10, 1000 })
	void kelimeUzunlukTest(int uzunluk) {

		assertEquals(uzunluk, karakterYoneticisi.rastgeleKelime(uzunluk).size());
	}

	@DisplayName("KELIME uzunlugu testi FAKER")
	@Test
	void kelimeUzunlukFakerTest() {
		int uzunluk = Integer.parseInt(faker.number().digit());
		assertEquals(uzunluk, karakterYoneticisi.rastgeleKelime(uzunluk).size());
	}

	// TODO: BURADA JAVAFAKER KULLANILABILIR.
	@DisplayName("Rastgele KARAKTER, karakter havuzundan mi testi")
	@Test
	void rastgeleKarakterHavuzTest() {
		Character karakter = karakterYoneticisi.rastgeleKarakter('c', 'i', 'b');
		if (karakter.equals('c') || karakter.equals('i') || karakter.equals('b')) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

	@DisplayName("Boundaryli KELIME uzunlugu testi")
	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 3, 2, 10, 1000 })
	void boundaryliKelimeUzunlukTest(int uzunluk) {
		assertEquals(uzunluk, karakterYoneticisi.rastgeleKelime('c', 'i', uzunluk).size());
	}

	@DisplayName("Boundaryli KELIME uzunlugu testi FAKER")
	@Test
	void boundaryliKelimeUzunlukFakerTest() {
		int uzunluk = Integer.parseInt(faker.number().digit());
		assertEquals(uzunluk, karakterYoneticisi.rastgeleKelime('c', 'i', uzunluk).size());
	}

	// TODO: BURADA JAVAFAKER KULLANILABILIR.
	@DisplayName("Rastgele KELIME, karakter havuzundan mi testi")
	@Test
	void rastgeleKelimeHavuzTest() {
		final int kelimeUzunlugu = 10;
		ArrayList<Character> kelime = karakterYoneticisi.rastgeleKelime(kelimeUzunlugu, 'c', 'i', 'b');

		for (Iterator<Character> it = kelime.listIterator(); it.hasNext();) {

			Character karakter = it.next();
			boolean karakterlerdenBirimi = (karakter.equals('c') || karakter.equals('i') || karakter.equals('b'));
			assertTrue(karakterlerdenBirimi);
		}

	}

	@DisplayName("Rastgele CUMLE, max kelime sayisi testi")
	@RepeatedTest(10)
	void rastgeleCumleMAXKelimeSayisiTest() {
		ArrayList<String> testCumle = karakterYoneticisi.rastgeleCumle();
		int kelimeSayisi = testCumle.size() / 2; // algoritmada aralara bosluklar ve nokta da bir liste elemani olarak
		int maxKelimeSayisi = 10; // dahil ediliyor.
		if (kelimeSayisi <= maxKelimeSayisi) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@DisplayName("Rastgele CUMLE, min kelime sayisi testi")
	@RepeatedTest(10)
	void rastgeleCumleMINKelimeSayisiTest() {
		ArrayList<String> testCumle = karakterYoneticisi.rastgeleCumle();
		int kelimeSayisi = testCumle.size() / 2; // algoritmada aralara bosluklar ve nokta da bir liste elemani olarak
		int minKelimeSayisi = 3; // dahil ediliyor.
		if (kelimeSayisi >= minKelimeSayisi) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@DisplayName("Rastgele CUMLE, max kelime uzunlugu testi")
	@RepeatedTest(10)
	void rastgeleCumleMAXKelimeUzunluguTest() {
		ArrayList<String> testCumle = karakterYoneticisi.rastgeleCumle();

		for (ListIterator<String> iterator = testCumle.listIterator(); iterator.hasNext();) {

			String kelime = iterator.next();
			if (kelime.equals("") || kelime.equals(" ")) {
				continue;
			} else {
				if (kelime.length() <= 10) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}

		}

	}

	@DisplayName("Rastgele CUMLE, min kelime uzunlugu testi")
	@RepeatedTest(10)
	void rastgeleCumleMINKelimeUzunluguTest() {
		ArrayList<String> testCumle = karakterYoneticisi.rastgeleCumle();

		for (ListIterator<String> iterator = testCumle.listIterator(); iterator.hasNext();) {

			String kelime = iterator.next();
			if (kelime.equals("") || kelime.equals(" ")) {
				continue;
			} else {
				if (kelime.equals(".")) {
					break;
				}
				if (kelime.length() >= 2) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}

		}
	}

	@DisplayName("Karakter bazinda getStringRepresentation metodunun input/output esitligi testi")
	@RepeatedTest(10)
	void getStringRepresentationCharacterValidationTest() {
		ArrayList<Character> inputArr = new ArrayList<Character>();
		char[] list = faker.name().firstName().toCharArray();
		for (char ch : list) {
			inputArr.add(ch);
		}

		String kelime = karakterYoneticisi.getStringRepresentation(inputArr);
		for (int i = 0; i < inputArr.size(); i++) {
			if (kelime.charAt(i) == inputArr.get(i)) {
				assertTrue(true);
			}
		}
	}

	@DisplayName("Karakter bazinda getStringRepresentation metodunun null input testi FAKER")
	@RepeatedTest(10)
	void getStringRepresentationNullInputTest() {
		ArrayList<Character> inputArr = null;

		String kelime = karakterYoneticisi.getStringRepresentation(inputArr);
		assertNull(kelime);
	}

}
