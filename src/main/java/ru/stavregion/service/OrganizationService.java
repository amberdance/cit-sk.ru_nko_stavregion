package ru.stavregion.service;

import ru.stavregion.exception.ModelNotFoundException;
import ru.stavregion.model.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> getAllOrganizations();

    Organization getOrganization(int id) throws ModelNotFoundException;

    Organization saveOrganization(Organization organization);

    void deleteOrganization(int id);
}
