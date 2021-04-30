package pkt;


import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.github.javafaker.Faker;

import org.junit.jupiter.params.provider.*;

class RastgeleTest {

	private static IRastgele rastgele;
	private static Faker faker = new Faker();
	
	@BeforeEach
	public void setUp() {
		rastgele = new Rastgele(1);
		
	}
	
	@DisplayName("Rastgele Int uret low boundary testi")
	@ParameterizedTest
	@ValueSource(ints = {1, 4, 7, 8, 10, 50})
	void rastgeleIntUretLowBoundaryTest(int low) {
		assertTrue(low <= rastgele.rastgeleIntUret(low, 1));
	}
	
	@DisplayName("Rastgele Int bound degerinden kucuk mu testi")
	@ParameterizedTest
	@ValueSource(ints = {1, 4, 7, 8, 10, 50})
	void rastgeleIntUretHighBoundaryTest(int high) {
		assertTrue(high >= rastgele.rastgeleIntUret(high));
	}

	@ParameterizedTest
	@MethodSource("loadDualInputArguments")
	void chooseOneNumOlasilikDagilimTest(int first, int sec) {
		int chosen = rastgele.chooseOneNum(first, sec);
		
		assertTrue((chosen== first) || (chosen == sec));
	}
	
	
	private static Stream<Arguments> loadDualInputArguments() {
	    return Stream.of(
	      Arguments.of(fakerDigit(), fakerDigit()),
	      Arguments.of(fakerDigit(), fakerDigit()),
	      Arguments.of(fakerDigit(), fakerDigit()),
	      Arguments.of(fakerDigit(), fakerDigit())
	    );
	}
	private static int fakerDigit() {
		
		String digit = faker.number().digit();
		return Integer.parseInt(digit);
	}
}
