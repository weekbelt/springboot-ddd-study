package me.weekbelt.shop.common.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money {

    private int value;

    public Money multiply(int multiplier) {
        return Money.builder().value(value * multiplier).build();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
