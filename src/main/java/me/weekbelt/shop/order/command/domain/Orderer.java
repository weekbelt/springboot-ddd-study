package me.weekbelt.shop.order.command.domain;

import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.shop.member.domain.MemberId;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Orderer {

    @AttributeOverrides(
        @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

    public Orderer(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Orderer orderer = (Orderer) obj;
        return Objects.equals(memberId, orderer.memberId) &&
            Objects.equals(name, orderer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name);
    }

}
