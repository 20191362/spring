package cleancode.nullobject;

public class RateDiscountCoupon implements DiscountCoupon {
    private double rate;

    public RateDiscountCoupon(double rate) {
        this.rate = rate;
    }

    @Override
    public double discount(double subtotal) {
        return subtotal * (1 - rate);
    }
}
