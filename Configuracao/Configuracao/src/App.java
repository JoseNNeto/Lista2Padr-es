public class App {
    public static void main(String[] args) throws Exception {
        Configuracao config = Configuracao.getInstance();

        try {
            config.carregarConfigs("src/ConfigFile.txt");
            config.printConfigs();

            System.out.println("\n\nInstancia: " + config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
