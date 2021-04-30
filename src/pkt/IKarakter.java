package pkt;

import java.util.ArrayList;

public interface IKarakter {

	char getKarakter();

	/**
	 * rastgele bir karakter uretir
	 *
	 * @return uretilen karakteri dondurur
	 */
	char rastgeleKarakter();

	/**
	 * verilen harf sinirlari arasinda kelime uretir
	 * 
	 * @param ilkHarf İlk harf siniri.
	 * @param sonHarf Son harf siniri.
	 * @return uretilen karakteri dondurur
	 */
	char rastgeleKarakter(char ilkHarf, char sonHarf);

	char rastgeleKarakter(char... chars);

	/**
	 * verilen uzunlukta rastgele bir kelime uretir
	 *
	 * @param kelimeUzunlugu Uretilecek kelimenin uzunlugu.
	 * @return rastgele kelimeyi tutan bir karakter listesi
	 */
	ArrayList<Character> rastgeleKelime(int kelimeUzunlugu);

	/**
	 * verilen harf sinirlari arasinda kelime uretir
	 * 
	 * @param ilkHarf        İlk harf siniri.
	 * @param sonHarf        Son harf siniri.
	 * @param kelimeUzunlugu Uretilecek kelimenin uzunlugu.
	 * @return rastgele kelimeyi tutan bir karakter listesi
	 */
	ArrayList<Character> rastgeleKelime(char ilkHarf, char sonHarf, int kelimeUzunlugu);

	/**
	 * verilen harf havuzundan bir kelime uretir
	 * 
	 * @param kelimeUzunlugu İlk harf siniri.
	 * @param chars          değişken sayıda karakter
	 * @return rastgele kelimeyi tutan bir karakter listesi
	 */
	ArrayList<Character> rastgeleKelime(int kelimeUzunlugu, char... chars);

	/**
	 * rastgele bir cumle oluşturur.
	 * 
	 * @return rastgele cumleyi tutan bir string listesi
	 */
	ArrayList<String> rastgeleCumle();

	/**
	 * ArrayListCharacter in ekrana basılması daha kolay olan string versiyonu
	 * 
	 * @param list kullanılacak ArrayListCharacter
	 * @return dönüşen string
	 */
	String getStringRepresentation(ArrayList<Character> list);

}