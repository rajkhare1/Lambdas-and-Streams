import java.util.List;

public class FP01Traditional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
//		printAllNumbersInListTraditional(numbers);
		printEvenNumbersInListTraditional(numbers);
	}

	private static void printAllNumbersInListTraditional(List<Integer> numbers) {

		for (Integer number : numbers) {
			System.out.println(number);
			
		}
	}
	
	private static void printEvenNumbersInListTraditional(List<Integer> numbers) {

		for (Integer number : numbers) {
			if(number % 2 == 0)
				System.out.println(number);
			
		}
	}

}
