package pkt;

//Program kullanıcı arayuzu sinifi. Text print etmek dışında bir fonsiyonelliği yoktur.
public class TextContents {

	/**
	 * Ana menu arayuzu.
	 */
	protected static void mainMenu() {

		System.out.println("=====YAZILIM TESTI 1.ODEV KONSOL UYGULAMASI=====");
		System.out.println("=====  IRFAN ASKIN KILIÇ       g181210376  =====");
		System.out.println("1.RASTGELE KARAKTER");
		System.out.println("2.RASTGELE KELIME");
		System.out.println("3.RASTGELE CUMLE");
		System.out.println("4.CIKIS");
	}

	/**
	 * Ana menu arayuzu.
	 */
	protected static void rastgeleKarakterMenu() {

		System.out.println("1.BIR TANE RASTGELE KARAKTER URET");
		System.out.println("2.VERILEN KARAKTER ARALIGINDA BIR KARAKTER URET");
		System.out.println("3.GERI DON");
		System.out.println("4.CIKIS");
	}
	protected static void rastgeleKelimeMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.BIR TANE RASTGELE KELIME URET");
		System.out.println("2.VERILEN KARAKTER ARALIGINDA BIR KELIME URET");
		System.out.println("3.GERI DON");
		System.out.println("4.CIKIS");
		
	}

	protected static void ilkKarakterInput() {
		System.out.print("Ilk karakter: ");
	}

	protected static void sonKarakterInput() {
		System.out.print("Son karakter: ");
	}

	protected static void output() {
		System.out.print("OUTPUT----> ");
	}

	
}
