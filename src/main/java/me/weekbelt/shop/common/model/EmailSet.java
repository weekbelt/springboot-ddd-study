package me.weekbelt.shop.common.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.shop.common.jpa.EmailSetConverter;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailSet {

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private Set<Email> emails = new HashSet<>();
}
