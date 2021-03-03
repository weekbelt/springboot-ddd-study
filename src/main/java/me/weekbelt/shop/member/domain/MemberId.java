package me.weekbelt.shop.member.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class MemberId implements Serializable {

    @Column(name = "member_id")
    private String id;

    @Builder
    public MemberId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MemberId memberId = (MemberId) obj;
        return Objects.equals(id, memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
