public class App {
    public static void main(String[] args) throws Exception {
        Configuracao config = Configuracao.getInstance();

        System.out.println("\n\nInstancia: " + config);

        try {
            config.carregarConfigs("src/ConfigFile.txt");
            config.printConfigs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
