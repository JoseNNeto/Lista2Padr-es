public class TudoMinusculo extends ProcessadorTexto{
    @Override
    char[] converterCaracteres(char[] chars) {
        char[] charsMaiusculo = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            charsMaiusculo[i] = Character.toLowerCase(chars[i]);
        }
        return charsMaiusculo;
    }
}
