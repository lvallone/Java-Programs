package fibonacci;

public class Fibonacci {
	
	public static void main(String[] args) {
		int previousNumber = 1;
		int sum = 1;
		int tempNumber;
		final int NUM_TRIES = 10;
		
		System.out.println (previousNumber);
		
		for (int i = 1; i <= NUM_TRIES; i++) {
			System.out.println (sum);
			tempNumber=sum;
			sum = sum + previousNumber;
			previousNumber = tempNumber;
		}
		
		// int age = 8;
		// System.out.println("Hi - I'm Haley");
		// System.out.println("I am " + age + " years old");
		
	}

}
