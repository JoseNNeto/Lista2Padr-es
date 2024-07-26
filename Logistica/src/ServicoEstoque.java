public class ServicoEstoque {
    public static boolean isAvailable(Produto product){
        if(product.name == "Celular" || product.name == "Computador"){
            System.out.println("Produto disponível no estoque");
            return true;
        }
        System.out.println("Produto não disponível no estoque");
        return false;
    }
}