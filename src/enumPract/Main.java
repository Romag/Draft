package enumPract;

enum Colour {
	RED,
	GREEN,
	BLUE;
	
	private Colour() {
		System.out.println("Constructor was called for: " + this.toString());
	}
}

public class Main {

	public static void main(String[] args) {
		Colour colour = Colour.valueOf("RED");
		System.out.println(colour);

	}

}
