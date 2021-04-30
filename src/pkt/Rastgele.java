package pkt;

import java.util.Random;

public class Rastgele implements IRastgele {

	private int low; // random int değeri için alt limit VARSAYILAN
	private int exclusiveBound = 1; // nextInt metodu için exclusive büyük parametreyi dahil et
	private int lettersBound = 25; // karakter sınırları tum alfabe VARSAYILAN
	private Random rnd;
	
	
	/**
	    * üretilen rastgele sayı
	    */
	private int rastgeleSayi;
	@Override
	public int getRastgeleSayi() throws Exception {
		if(rastgeleSayi != 0) {
			return rastgeleSayi;
		}
		else {
			throw new Exception("Rastgele sayi uretilmemis. Rastgele sayi okunamiyor.");
		}
		
	}
	
	/**
	    * Rastgele kurucu metod. 
	    *
	    * @param	exclusiveBound 	  dahil edilecek en buyuk deger esigi
	    * 
	    */
	public Rastgele(int exclusiveBound) {
		
		this.exclusiveBound = exclusiveBound;
		rnd = new Random();
	}
	
	
	/**
	    * Rastgele bir tamsayı değer üret. 
	    *
	    * @param	low 			alt tamsayı değeri eşiği
	    * @param 	lettersBound	tamsayı aralığı
	    * @return        			kurucu metoddan gelen parametre değerleri ile sınırlanmış rastgele değer
	    */
	@Override
	public int rastgeleIntUret(int low, int lettersBound) {
		this.low = low;
		this.lettersBound = lettersBound;
		
		rastgeleSayi = rnd.nextInt(lettersBound  + exclusiveBound) + low;
		return rastgeleSayi;
	}
	
	/**
	    * Rastgele bir tamsayı değer üret. 
	    *
	    * @param	bound 			sayi esigi
	    * @return        			kurucu metoddan gelen parametre değerleri ile sınırlanmış rastgele değer
	    */
	@Override
	public int rastgeleIntUret(int bound) {
		rastgeleSayi = rnd.nextInt(bound);
		return rastgeleSayi;
	}
	
	
	/**
	    * %50 olasilikla iki integerdan birini dondur 
	    *
	    * @param	num1	ilk integer
	    * @param	num2	ikinci integer
	    * @return   		iki integerdan biri
	    */
	@Override
	public int chooseOneNum (int num1, int num2) {
		if(rnd.nextBoolean()) {
			return num1;
		}else {
			return num2;
		}
	}
	
	
	
}
