package streams;

public class MediaTest {

	public static void main(String[] args) {

		// m1.adicionar(8.3);
		// m1.adicionar(6.7);
		Media m1 = new Media().adicionar(7.5).adicionar(7.5);
		System.out.println(m1.getValor());

		Media m2 = new Media().adicionar(6.5).adicionar(6.5);
		System.out.println(m2.getValor());

		System.out.println(Media.combinar(m1, m2).getValor());

	}
}
