package tr.edu.medipol.yova;

public class PartiMain {

	public static void main(String[] args) {
		Parti.readResultsFromFile();
		Parti.partiOyArttir("A");
		Parti.partiOyArttir("B");
		Parti.partiOyArttir("C");
		Parti.partiListele();
		Parti.updateResultsFile();
	}
}
