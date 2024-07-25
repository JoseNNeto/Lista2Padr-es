import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Configuracao {
    // Configura para que seja uma única instancia e criar uma somente se não existir
    private static Configuracao instance; 

    private Configuracao() {
        configs = new HashMap<>();
    }

    public static Configuracao getInstance() {
        if (instance == null) {
            instance = new Configuracao();
        }
        return instance;
    }

    //Map grava os dados como chave e valor
    private Map<String, String> configs;

    public void carregarConfigs(String caminho) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("=");
                if (partes.length == 2) {
                    configs.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printConfigs() {
        for (String chave : configs.keySet()) {
            System.out.println(chave + " = " + configs.get(chave));
        }
    }
}

//Para Threads
//private static Configuracao instance = new Configuracao();