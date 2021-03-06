package me.weekbelt.shop.catalog.domain.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image {

    @Override
    public String getUrl() {
        return "/images/original/" + getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return true;
    }

    @Override
    public String getThumbnailUrl() {
        return "/images/thumbnail/" + getPath();
    }
}
