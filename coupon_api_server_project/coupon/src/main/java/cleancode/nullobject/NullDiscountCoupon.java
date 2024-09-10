package cleancode.nullobject;

public class NullDiscountCoupon implements DiscountCoupon {

    @Override
    public double discount(double subtotal) {
        return subtotal;
    }
}
