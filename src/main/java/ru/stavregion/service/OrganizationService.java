package ru.stavregion.service;

import ru.stavregion.exception.ModelNotFoundException;
import ru.stavregion.model.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> findAllOrganizations();

    Organization findOrganization(int id) throws ModelNotFoundException;

    Organization findAnyOrganization() throws ModelNotFoundException;

    Organization saveOrganization(Organization organization);

    void deleteOrganization(int id);
}
