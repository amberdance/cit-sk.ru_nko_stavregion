package ru.stavregion.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stavregion.exception.ModelNotFoundException;
import ru.stavregion.model.Organization;
import ru.stavregion.repository.OrganizationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {


    private final OrganizationRepository organizationRepository;


    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganization(int id) throws ModelNotFoundException {
        return organizationRepository.findById(id).orElseThrow(ModelNotFoundException::new);
    }

    @Override
    public Organization saveOrganization(Organization organization) {
        var result = organizationRepository.save(organization);
        log.info("Organization saved: {}", result);
        return result;
    }

    @Override
    public void deleteOrganization(int id) {
        organizationRepository.deleteById(id);
        log.info("Organization with id {} deleted", id);
    }
}
