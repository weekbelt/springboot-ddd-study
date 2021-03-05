package me.weekbelt.shop.common.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import me.weekbelt.shop.common.model.Money;

@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Money money) {
        if (money == null) {
            return null;
        } else {
            return money.getValue();
        }
    }

    @Override
    public Money convertToEntityAttribute(Integer value) {
        if (value == null) {
            return null;
        } else {
            return Money.builder()
                .value(value)
                .build();
        }
    }
}
