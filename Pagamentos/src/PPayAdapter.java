public class PPayAdapter implements MPay {
    PPay pPay;

    public PPayAdapter(PPay pPay) {
        this.pPay = pPay;
    }

    @Override
    public String getCreditCardNo() {
        return pPay.getCustCardNo();
    }

    @Override
    public String getCustomerName() {
        return pPay.getCardOwnerName();
    }

    @Override
    public String getCardExpMonth() {
        return pPay.getCardExpMonthDate();
    }

    @Override
    public String getCardExpYear() {
        return pPay.getCardExpMonthDate();
    }

    @Override
    public Short getCardCVVNo() {
        return pPay.getCVVNo().shortValue();
    }

    @Override
    public Double getAmount() {
        return pPay.getTotalAmount();
    }

    @Override
    public void setCreditCardNo(String creditCardNo) {
        this.pPay.setCustCardNo(creditCardNo);
    }
    @Override
    public void setCustomerName(String customerName) {
        this.pPay.setCardOwnerName(customerName);
    }

    @Override
    public void setCardExpMonth(String cardExpMonth) {
        this.pPay.setCardExpMonthDate(cardExpMonth);
    }

    @Override
    public void setCardExpYear(String cardExpYear) {
        this.pPay.setCardExpMonthDate(cardExpYear);
    }

    @Override
    public void setCardCVVNo(Short cardCVVNo) {
        this.pPay.setCVVNo(cardCVVNo.intValue());
    }

    @Override
    public void setAmount(Double amount) {
        this.pPay.setTotalAmount(amount);
    }

    
}
