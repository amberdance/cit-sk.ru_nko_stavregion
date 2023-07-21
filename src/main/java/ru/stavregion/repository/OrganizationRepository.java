package ru.stavregion.repository;

import jakarta.annotation.Nonnull;
import org.springframework.data.repository.ListCrudRepository;
import ru.stavregion.model.Organization;

import java.util.List;

public interface OrganizationRepository extends ListCrudRepository<Organization, Integer> {

    @Nonnull
    List<Organization> findAll();
}
