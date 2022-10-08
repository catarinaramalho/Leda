package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		Vetor<Aluno> vetor = new Vetor<Aluno>(20);
		ComparadorMaximo compMax = new ComparadorMaximo();
		vetor.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetor.setComparadorMinimo(compMin);
	
	}
}
