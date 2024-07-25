public abstract class ProcessadorTexto {
    final String converterTexto(String texto){
        char[] chars = extrairCaracteres(texto);
        char[] caracteresConvertidos = converterCaracteres(chars);
        String textoConvertido = juntarCaracteres(caracteresConvertidos);
        return textoConvertido;
    }

    private static char[] extrairCaracteres(String texto){
        return texto.toCharArray();
    }

    abstract char[] converterCaracteres(char[] chars);

    private static String juntarCaracteres(char[] chars){
        return new String(chars);
    }
}
