package cleancode.nullobject;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cart cartWithDiscount = new Cart(
                Arrays.asList(
                        new CartItem(1),
                        new CartItem(2),
                        new CartItem(7)
                ),
                new RateDiscountCoupon(0.15)
        );
        System.out.println("Cart total with discount: " + cartWithDiscount.total()); // 8.5

        Cart cartWithoutDiscount = new Cart(
                Arrays.asList(
                        new CartItem(1),
                        new CartItem(2),
                        new CartItem(7)
                ),
                new NullDiscountCoupon()
        );
        System.out.println("Cart total without discount: " + cartWithoutDiscount.total()); // 10.0
    }
}
