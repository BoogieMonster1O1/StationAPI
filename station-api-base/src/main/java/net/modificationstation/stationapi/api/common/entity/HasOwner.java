package net.modificationstation.stationapi.api.common.entity;

import net.minecraft.entity.EntityBase;

public interface HasOwner {

    EntityBase getOwner();

    void setOwner(EntityBase entityBase);
}
