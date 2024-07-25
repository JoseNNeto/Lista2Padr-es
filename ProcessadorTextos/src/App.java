public class App {
    public static void main(String[] args) throws Exception {
        ProcessadorTexto processadorMaiuscula = new TudoMaisucula();
        ProcessadorTexto processadorMinuscula = new TudoMinusculo();

        String texto = "Mereço uma nota boa?";

        String textoMaiusculo = processadorMaiuscula.converterTexto(texto);
        String textoMinusculo = processadorMinuscula.converterTexto(texto);

        System.out.println("Texto em maiúsculo: " + textoMaiusculo);
        System.out.println("Texto em minúsculo: " + textoMinusculo);
    }
}
