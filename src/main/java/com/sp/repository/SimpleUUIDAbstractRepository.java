package com.sp.repository;

import com.sp.model.Card;
import com.sp.model.OwnerUUID;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class SimpleUUIDAbstractRepository<T extends OwnerUUID> implements CrudRepository<OwnerUUID, UUID> {

    HashMap<UUID, OwnerUUID> owners = new HashMap<UUID, OwnerUUID>();

    @Override
    public <S extends OwnerUUID> S save(S s) {
        return null;
    }

    @Override
    public <S extends OwnerUUID> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<OwnerUUID> findById(UUID uuid) {
        OwnerUUID owner = owners.getOrDefault(uuid, null);
        return Optional.ofNullable(owner);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return this.findById(uuid).isPresent();
    }

    @Override
    public Iterable<OwnerUUID> findAll() {
        return owners.values();
    }

    @Override
    public Iterable<OwnerUUID> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return owners.size();
    }

    @Override
    public void deleteById(UUID uuid) {
        owners.remove(uuid);
    }

    @Override
    public void delete(OwnerUUID owner) {
        this.deleteById(owner.getUUID());
    }

    @Override
    public void deleteAll(Iterable<? extends OwnerUUID> iterable) {
        iterable.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        owners.clear();
    }
}
