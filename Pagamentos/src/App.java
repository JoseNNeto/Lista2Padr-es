public class App {
    public static void main(String[] args) throws Exception {
        PPay pp = new PPayImpl();
        pp.setCustCardNo("5522336699");
        pp.setCardOwnerName("Neto");
        pp.setCardExpMonthDate("12/22");
        pp.setCVVNo(235);
        pp.setTotalAmount(256.00);

        MPay mpayAdapter = new PPayAdapter(pp);
        testPPay(pp);
        testMPay(mpayAdapter);
    }

    public static void testPPay(PPay pp){
        System.out.println("Dono: " + pp.getCardOwnerName());
        System.out.println("Nmr do Cartão: " + pp.getCustCardNo());
        System.out.println("Data: " + pp.getCardExpMonthDate());
        System.out.println("CVV: " + pp.getCVVNo());
        System.out.println("Total na Conta: " + pp.getTotalAmount());
    }

    public static void testMPay(MPay mp){
        System.out.println("Dono: " + mp.getCustomerName());
        System.out.println("Nmr do Cartão: " + mp.getCreditCardNo());
        System.out.println("Data: " + mp.getCardExpMonth());
        System.out.println("CVV: " + mp.getCardCVVNo());
        System.out.println("Total na Conta: " + mp.getAmount());
    }
}
