public class PedidoFacade {
    ServicoEstoque estoque;
    ServicoPagamento pagamento;
    ServicoRemessa remessa;

    public PedidoFacade(ServicoEstoque estoque, ServicoPagamento pagamento, ServicoRemessa remessa){
        this.estoque = estoque;
        this.pagamento = pagamento;
        this.remessa = remessa;
    }

    public void processOrder(Produto produto){
        boolean isAvailable = ServicoEstoque.isAvailable(produto);
        if(isAvailable){
            boolean pagamentoFeito = ServicoPagamento.makePayment();
            if(pagamentoFeito){
                ServicoRemessa.shipProduct(produto);
            }
        }
    }
}
