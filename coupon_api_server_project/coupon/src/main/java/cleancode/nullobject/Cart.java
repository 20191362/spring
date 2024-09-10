package cleancode.nullobject;

import java.util.List;

public class Cart {
    private List<CartItem> items;
    private DiscountCoupon discountCoupon;

    public Cart(List<CartItem> items, DiscountCoupon discountCoupon) {
        this.items = items;
        this.discountCoupon = discountCoupon;
    }

    public double subtotal() {
        return items.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

    public double total() {
        return discountCoupon.discount(subtotal());
    }
}
