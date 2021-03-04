package me.weekbelt.shop.order.command.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.shop.common.model.Address;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class ShippingInfo {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zip_code")),
        @AttributeOverride(name = "address1", column = @Column(name = "shipping_add1")),
        @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2")),
    })
    private Address address;

    @Column(name = "shipping_message")
    private String message;

    @Embedded
    private Receiver receiver;
}
