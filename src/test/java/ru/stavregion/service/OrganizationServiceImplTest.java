package ru.stavregion.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.stavregion.exception.ModelNotFoundException;
import ru.stavregion.utils.OrganizationFakeFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class OrganizationServiceImplTest {

    @Autowired
    private OrganizationService organizationService;


    @Test
    void getAllOrganizations() {
        assertFalse(organizationService.findAllOrganizations().isEmpty());
    }

    @Test
    void createOrganization() {
        var sizeBefore = organizationService.findAllOrganizations().size();
        var fakeOrganization = OrganizationFakeFactory.getOrganization();
        organizationService.saveOrganization(fakeOrganization);

        var sizeAfter = organizationService.findAllOrganizations().size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    void updateOrganization() throws ModelNotFoundException {
        var existingOrganization = organizationService.findOrganization(1);
        var organizationToSave = OrganizationFakeFactory.getOrganizationWithId(existingOrganization.id());
        var updatedOrganization = organizationService.saveOrganization(organizationToSave);

        assertEquals(existingOrganization.id(), updatedOrganization.id());
        assertNotEquals(existingOrganization.supportForm(), updatedOrganization.supportForm());
        assertNotEquals(existingOrganization.name(), updatedOrganization.name());
        assertNotEquals(existingOrganization.address(), updatedOrganization.address());
        assertNotEquals(existingOrganization.ogrn(), updatedOrganization.ogrn());
        assertNotEquals(existingOrganization.okvd(), updatedOrganization.okvd());
        assertNotEquals(existingOrganization.violationInformation(), updatedOrganization.violationInformation());
    }

    @Test
    void getOrganizationShouldThrowsExceptionIfModelDidNotExists() {
        assertThrows(ModelNotFoundException.class, () -> organizationService.findOrganization(999111));
    }

    @Test
    void getOrganizationShouldReturnModelIfExists() throws ModelNotFoundException {
        assertNotNull(organizationService.findOrganization(1));
    }

    @Test
    void deleteOrganization() {
        var organization = organizationService.saveOrganization(OrganizationFakeFactory.getOrganization());
        var sizeBefore = organizationService.findAllOrganizations().size();

        organizationService.deleteOrganization(organization.id());

        var sizeAfter = organizationService.findAllOrganizations().size();
        assertEquals(sizeBefore - 1, sizeAfter);
    }
}
