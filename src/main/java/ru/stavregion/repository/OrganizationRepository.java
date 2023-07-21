package ru.stavregion.repository;

import jakarta.annotation.Nonnull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.stavregion.model.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends ListCrudRepository<Organization, Integer> {

    @Nonnull
    List<Organization> findAll(Sort sort);

    @Nonnull
    @Query("select * from organization order by id desc limit 1")
    Optional<Organization> findAnyOrganization();

}
