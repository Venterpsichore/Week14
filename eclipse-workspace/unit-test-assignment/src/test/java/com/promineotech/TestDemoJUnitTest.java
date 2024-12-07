package com.promineotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.Mockito.doReturn; // Allows for spying/mocking
import static org.mockito.Mockito.spy;
import java.util.stream.Stream; // Allows for streams to be set up through test case elements

class TestDemoJUnitTest {
	
	private TestDemo testDemo; // Instantiates testDemo for exception throwing 

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo(); // Necessary to make each test different
	}

	@ParameterizedTest // Comparing the value of expected to a and b passed through testDemo 
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); 
} else { // Exceptions throw the IllegalArgumentException
	assertThatThrownBy(() ->
	testDemo.addPositive(a,b))
	.isInstanceOf(IllegalArgumentException.class);
}
	}
	
	@Test
	 void assertThatPairsOfPositiveNumbersAreAddedCorrectly() { // Asserting examples of additions
		 assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		 assertThat(testDemo.addPositive(20, 30)).isEqualTo(50);
	}
		 
	 static Stream<Arguments> argumentsForAddPositive() {
		 return Stream.of( // Stream made test case elements
				 Arguments.arguments(-8, 9, 1, true),
				 Arguments.arguments(1, 1, 2, false),
				 Arguments.arguments(1, 0, 1, true),
				 Arguments.arguments(-8, 0, -8, true),
				 Arguments.arguments(-7, -7, -14, true),
				 Arguments.arguments(-7, 0, -7, true)
				 );
	 }
	 
	 @ParameterizedTest
	 @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddZero")
	 void assertThatZeroIsAddedCorrectly(int a, int b, int expected, boolean expectException) {
		 if(!expectException) {
			 assertThat(testDemo.addZero(a, b)).isEqualTo(expected);
		 } else {
			 assertThatThrownBy(() -> 
			 testDemo.addZero(a, b))
			 .isInstanceOf(IllegalArgumentException.class);
		 }
	 }
	 static Stream<Arguments> argumentsForAddZero() {
		 return Stream.of(
				 Arguments.arguments(0, 0, 0, false),
				 Arguments.arguments(0, 5, 5, false),
			     Arguments.arguments(6, 0, 6, false),
			     Arguments.arguments(3, 0, 3, false),
			     Arguments.arguments(-1, 0, -1, false)
				 );
	 }
	 
	 @Test
	 void assertThatSquarableSquaredCorrectly() {
		 TestDemo testDemo = new TestDemo();
		 TestDemo mockDemo = spy(testDemo); //Spy used to wrap specifications
		 
		 doReturn(5).when(mockDemo).getRandomInt(); // Supplying number 5 if getRandomInt() called
		 
		 int fiveSquared = mockDemo.randomNumberSquared();
		 
		 assertThat(fiveSquared).isEqualTo(25);
	 }
	}
