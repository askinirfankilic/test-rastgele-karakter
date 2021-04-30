package pkt;

import java.util.ArrayList;

public class Karakter implements IKarakter {

	final int buyukHarfLow = 65;
	final int kucukHarfLow = 97;
	final int exclusiveBound = 1;
	final int lettersBound = 25;

	private char karakter;

	@Override
	public char getKarakter() {
		return karakter;
	}

	private ArrayList<Character> kelime;

	private ArrayList<String> cumle;
	IRastgele rastgeleSayi = new Rastgele(exclusiveBound);

	public Karakter() {
		kelime = new ArrayList<Character>();
		cumle = new ArrayList<String>();
	}

	/**
	 * rastgele bir karakter uretir
	 *
	 * @return uretilen karakteri dondurur
	 */
	@Override
	public char rastgeleKarakter() {
		int kucuk = rastgeleSayi.rastgeleIntUret(kucukHarfLow, lettersBound);
		int buyuk = rastgeleSayi.rastgeleIntUret(buyukHarfLow, lettersBound);
		karakter = intToCharConvert(rastgeleSayi.chooseOneNum(kucuk, buyuk));
		return karakter;
	}

	/**
	 * verilen harf sinirlari arasinda karakter uretir
	 * 
	 * @param ilkHarf İlk harf siniri.
	 * @param sonHarf Son harf siniri.
	 * @return uretilen karakteri dondurur
	 */
	@Override
	public char rastgeleKarakter(char ilkHarf, char sonHarf) {
		int ilkHarfInt = findKucukHarfInt(charToIntConvert(ilkHarf));
		int sonHarfInt = findKucukHarfInt(charToIntConvert(sonHarf));

		// TODO: buyuk harf kucuk harf karisikligini coz.

		int localLettersBound = sonHarfInt - ilkHarfInt;

		int kucukNum = rastgeleSayi.rastgeleIntUret(ilkHarfInt, localLettersBound);
		int buyukNum = rastgeleSayi.rastgeleIntUret(findKucukHarfInt(ilkHarfInt), localLettersBound);
		int num = rastgeleSayi.chooseOneNum(kucukNum, buyukNum);

		karakter = intToCharConvert(num);
		return karakter;

	}

	@Override
	public char rastgeleKarakter(char... chars) {
		ArrayList<Character> karakterHavuzu = havuzOlustur(chars);
		int num = rastgeleSayi.rastgeleIntUret(karakterHavuzu.size());
		karakter = intToCharConvert(karakterHavuzu.get(num));
		return karakter;
	}

	/**
	 * verilen uzunlukta rastgele bir kelime uretir
	 *
	 * @param kelimeUzunlugu Uretilecek kelimenin uzunlugu.
	 * @return rastgele kelimeyi tutan bir karakter listesi
	 */
	@Override
	public ArrayList<Character> rastgeleKelime(int kelimeUzunlugu) {
		for (int i = 0; i < kelimeUzunlugu; i++) {
			int kucukHarfNum = rastgeleSayi.rastgeleIntUret(kucukHarfLow, lettersBound);
			int buyukHarfNum = rastgeleSayi.rastgeleIntUret(buyukHarfLow, lettersBound);
			int num = rastgeleSayi.chooseOneNum(kucukHarfNum, buyukHarfNum);
			karakter = intToCharConvert(num);
			kelime.add(karakter);
		}

		ArrayList<Character> kelimeKopya = kelimeKopyala(kelime);

		kelime.clear();
		return kelimeKopya;
	}

	/**
	 * verilen harf sinirlari arasinda kelime uretir
	 * 
	 * @param ilkHarf        İlk harf siniri.
	 * @param sonHarf        Son harf siniri.
	 * @param kelimeUzunlugu Uretilecek kelimenin uzunlugu.
	 * @return rastgele kelimeyi tutan bir karakter listesi
	 */
	@Override
	public ArrayList<Character> rastgeleKelime(char ilkHarf, char sonHarf, int kelimeUzunlugu) {
		int ilkHarfInt = charToIntConvert(ilkHarf);
		int sonHarfInt = charToIntConvert(sonHarf);
		int localLettersBound = sonHarfInt - ilkHarfInt;

		for (int i = 0; i < kelimeUzunlugu; i++) {

			int kucukNum = rastgeleSayi.rastgeleIntUret(ilkHarfInt, localLettersBound);
			int buyukNum = rastgeleSayi.rastgeleIntUret(findKucukHarfInt(ilkHarfInt), localLettersBound);
			int num = rastgeleSayi.chooseOneNum(kucukNum, buyukNum);
			karakter = intToCharConvert(num);
			kelime.add(karakter);
		}

		ArrayList<Character> kelimeKopya = kelimeKopyala(kelime);
		kelime.clear();

		return kelimeKopya;
	}

	/**
	 * verilen harf havuzundan bir kelime uretir
	 * 
	 * @param kelimeUzunlugu İlk harf siniri.
	 * @param chars          değişken sayıda karakter
	 * @return rastgele kelimeyi tutan bir karakter listesi
	 */
	@Override
	public ArrayList<Character> rastgeleKelime(int kelimeUzunlugu, char... chars) {
		ArrayList<Character> karakterHavuzu = havuzOlustur(chars);

		for (int i = 0; i < kelimeUzunlugu; i++) {
			int num = rastgeleSayi.rastgeleIntUret(karakterHavuzu.size());
			karakter = intToCharConvert(karakterHavuzu.get(num));
			kelime.add(karakter);
		}

		ArrayList<Character> kelimeKopya = kelimeKopyala(kelime);
		kelime.clear();
		return kelimeKopya;
	}

	/**
	 * rastgele bir cumle oluşturur.
	 * 
	 * @return rastgele cumleyi tutan bir string listesi
	 */
	@Override
	public ArrayList<String> rastgeleCumle() {

		// kelime ve harf sınırları
		int minKelime = 3, maxKelime = 10;
		int minHarf = 2, maxHarf = 10;

		String nokta = ".";
		String bosluk = " ";

		int kelimeSayisi = rastgeleSayi.rastgeleIntUret(minKelime, maxKelime - minKelime);
		for (int i = 0; i < kelimeSayisi; i++) {
			int kelimeUzunlugu = rastgeleSayi.rastgeleIntUret(minHarf, maxHarf - minHarf);
			kelime = rastgeleKelime(kelimeUzunlugu);
			cumle.add(getStringRepresentation(kelime)); // arraylist character yapısının köşeli parantez gibi
														// parçalarından kurtulmak için
			if (kelimeSayisi == (i + 1)) {
				cumle.add(nokta);
				kelime.clear();
				continue;
			}
			cumle.add(bosluk);
			kelime.clear();

		}
		ArrayList<String> cumleKopya = cumleKopyala(cumle);
		cumle.clear();
		return cumleKopya;
	}

	private int findKucukHarfInt(int harfInt) {
		boolean kucukmu = buyukHarfLow <= harfInt && harfInt <= buyukHarfLow + lettersBound;
		if (kucukmu) {
			int buyukHarfInt = buyukHarfeCevir(harfInt);
			return buyukHarfInt;
		} else {
			return harfInt;
		}
	}

	private int buyukHarfeCevir(int kucukHarfInt) {

		char kucukHarf = intToCharConvert(kucukHarfInt);
		char buyukHarf = Character.toLowerCase(kucukHarf);

		return charToIntConvert(buyukHarf);
	}

	/**
	 * Shallow copy dondurur.
	 * 
	 * @param kelime kopyalanacak kelime
	 * @return kopya kelimeyi dondurur.
	 */
	private ArrayList<Character> kelimeKopyala(ArrayList<Character> kelime) {
		ArrayList<Character> kelimeKopya = new ArrayList<Character>(kelime);
		return kelimeKopya;
	}

	/**
	 * Shallow copy dondurur.
	 * 
	 * @param cumle kopyalanacak cumle
	 * @return kopya cumleyi dondurur.
	 */
	private ArrayList<String> cumleKopyala(ArrayList<String> cumle) {
		ArrayList<String> kelimeKopya = new ArrayList<String>(cumle);
		return kelimeKopya;
	}

	private int charToIntConvert(char ch) {
		return (int) ch;
	}

	/**
	 * int tipini ascii tablosuna gore char tipine cevir
	 *
	 * @param num cevirilecek
	 * @return verilen int in char tipindeki hali
	 */
	private char intToCharConvert(int num) {
		return (char) num;
	}

	private ArrayList<Character> havuzOlustur(char... chars) {
		ArrayList<Character> charPool = new ArrayList<>(chars.length);
		for (char ch : chars) {
			charPool.add(ch);
		}
		return charPool;
	}

	/**
	 * ArrayListCharacter in ekrana basılması daha kolay olan string versiyonu
	 * 
	 * @param list kullanılacak ArrayListCharacter
	 * @return dönüşen string
	 */
	public String getStringRepresentation(ArrayList<Character> list) {
	
		if(list == null) {
			return null;
		}
		StringBuilder builder = new StringBuilder(list.size());
		for (Character ch : list) {
			builder.append(ch);
		}
		return builder.toString();
	}

}
