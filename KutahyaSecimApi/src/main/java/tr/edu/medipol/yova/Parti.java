package tr.edu.medipol.yova;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Parti {
	private static int partiAOy = 0;
    private static int partiBOy = 0;
    private static int partiCOy = 0;

    public static void partiOyArttir(String partiAdi) {
        if (partiAdi.equals("A")) {partiAOy++;}
        else if (partiAdi.equals("B")) {partiBOy++;}
        else if (partiAdi.equals("C")) {partiCOy++;}
        else return;
    }
    
    public static void partiOyAzalt(String partiAdi) {
    	if (partiAdi.equals("A")) {
    		if(partiAOy == 0) return;
    		else partiAOy--;
    	}
    	else if (partiAdi.equals("B")) {
    		if(partiBOy == 0) return;
    		else partiBOy--;
    	}
        else if (partiAdi.equals("C")) {
        	if(partiCOy == 0) return;
        	else partiCOy--;
        }
    }
    public static void partiListele(){
    	System.out.println("Kutahya Il Milletvekili sonuclari\nA Partisi: "+partiAOy+"\nB Partisi: "+partiBOy+"\nC Partisi: "+partiCOy+"\n");
    }
    protected static void updateResultsFile() {
        try (FileWriter sonuclar = new FileWriter("Sonuclar.txt"); BufferedWriter writer = new BufferedWriter(sonuclar)) {
            writer.write("A Partisi: " + partiAOy + "\n");
            writer.write("B Partisi: " + partiBOy + "\n");
            writer.write("C Partisi: " + partiCOy + "\n");
            System.out.println("Sonuclar Sonuclar.txt dosyasina guncellendi.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void readResultsFromFile() {
        try (FileReader sonuclar = new FileReader("Sonuclar.txt"); 
        	BufferedReader reader = new BufferedReader(sonuclar)){
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("A Partisi:")) {
                    partiAOy = parseVoteCount(line);
                } else if (line.contains("B Partisi:")) {
                    partiBOy = parseVoteCount(line);
                } else if (line.contains("C Partisi:")) {
                    partiCOy = parseVoteCount(line);
                }
            }
            System.out.println("Sonuclar.txt dosyasi okundu.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static int parseVoteCount(String line) {
        String[] parts = line.split(":");
        return Integer.parseInt(parts[1].trim());
    }

	public static int getPartiAOy() {
		return partiAOy;
	}

	public static int getPartiBOy() {
		return partiBOy;
	}

	public static int getPartiCOy() {
		return partiCOy;
	}

	public static void setPartiAOy(int partiAOy) {
		Parti.partiAOy = partiAOy;
	}

	public static void setPartiBOy(int partiBOy) {
		Parti.partiBOy = partiBOy;
	}

	public static void setPartiCOy(int partiCOy) {
		Parti.partiCOy = partiCOy;
	}
}
