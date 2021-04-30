package pkt;

public interface IRastgele {

	int getRastgeleSayi() throws Exception;

	/**
	    * Rastgele bir tamsayı değer üret. 
	    *
	    * @param	low 			alt tamsayı değeri eşiği
	    * @param 	lettersBound	tamsayı aralığı
	    * @return        			kurucu metoddan gelen parametre değerleri ile sınırlanmış rastgele değer
	    */
	int rastgeleIntUret(int low, int lettersBound);

	/**
	    * Rastgele bir tamsayı değer üret. 
	    *
	    * @param	bound 			sayi esigi
	    * @return        			kurucu metoddan gelen parametre değerleri ile sınırlanmış rastgele değer
	    */
	int rastgeleIntUret(int bound);

	/**
	    * %50 olasilikla iki integerdan birini dondur 
	    *
	    * @param	num1	ilk integer
	    * @param	num2	ikinci integer
	    * @return   		iki integerdan biri
	    */
	int chooseOneNum(int num1, int num2);

}