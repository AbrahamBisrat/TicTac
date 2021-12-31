
public class fizBizz {
	public static void main(String[] args) {
		fizzyBizzy();
	}
	public static void fizzyBizzy() {
		for(int i = 1; i < 100; i++) {
			if((i % 3) == 0 && (i % 5) == 0)
				System.out.println("fizz Bizz");
			else if((i % 3) == 0)
				System.out.println("fizz");
			else if((i % 5) == 0)
				System.out.println("bizzy");
			else
				System.out.println(i);
		}
	}
}
