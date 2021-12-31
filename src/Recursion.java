import java.util.Arrays;

public class Recursion {
	public static int sumOfElements(int[] x) {
		System.out.println(Arrays.toString(x));
		if(x.length == 1)
			return x[0];
		return x[0]+ sumOfElements(Arrays.copyOfRange(x, 1, x.length));
	}
	public static void main(String[] args) {
		int[] sumThis = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(sumOfElements(sumThis));
	}
}