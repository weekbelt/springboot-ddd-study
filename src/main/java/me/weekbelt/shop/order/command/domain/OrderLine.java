package me.weekbelt.shop.order.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.weekbelt.shop.catalog.domain.product.ProductId;
import me.weekbelt.shop.common.model.Money;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class OrderLine {

    @Embedded
    private ProductId productId;

    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amounts")
    private Money amounts;

    public OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
