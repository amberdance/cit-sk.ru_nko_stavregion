package ru.stavregion.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.stavregion.exception.ModelNotFoundException;
import ru.stavregion.model.Organization;
import ru.stavregion.model.SupportForm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class OrganizationServiceImplTest {

    @Autowired
    private OrganizationService organizationService;

    private static Organization getFakeOrganization() {
        var supportForm = SupportForm.builder()
                .name("any")
                .period("any")
                .size("any")
                .target("any")
                .build();

        return Organization.builder()
                .name("any")
                .address("any")
                .inn("any")
                .okvd("any")
                .ogrn("any")
                .supportForm(supportForm)
                .violationInformation("any")
                .build();
    }


    @Test
    void getAllOrganizations() {
        assertFalse(organizationService.getAllOrganizations().isEmpty());
    }

    @Test
    void createOrganization() {
        var sizeBefore = organizationService.getAllOrganizations().size();
        organizationService.saveOrganization(getFakeOrganization());

        var sizeAfter = organizationService.getAllOrganizations().size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    void updateOrganization() throws ModelNotFoundException {
        var existingOrganization = organizationService.getOrganization(1);
        var organizationToSave = Organization.builder()
                .id(existingOrganization.id())
                .name("newname")
                .address("newaddress")
                .ogrn("new")
                .inn("new")
                .okvd("new")
                .violationInformation("newinf")
                .supportForm(existingOrganization.supportForm())
                .build();

        var updatedOrganization = organizationService.saveOrganization(organizationToSave);

        assertEquals(existingOrganization.id(), updatedOrganization.id());
        assertEquals(existingOrganization.supportForm(), updatedOrganization.supportForm());
        assertNotEquals(existingOrganization.name(), updatedOrganization.name());
        assertNotEquals(existingOrganization.address(), updatedOrganization.address());
        assertNotEquals(existingOrganization.ogrn(), updatedOrganization.ogrn());
        assertNotEquals(existingOrganization.okvd(), updatedOrganization.okvd());
        assertNotEquals(existingOrganization.violationInformation(), updatedOrganization.violationInformation());
    }

    @Test
    void getOrganizationShouldThrowsExceptionIfModelDidNotExists() {
        assertThrows(ModelNotFoundException.class, () -> organizationService.getOrganization(999111));
    }

    @Test
    void getOrganizationShouldReturnModelIfExists() throws ModelNotFoundException {
        assertNotNull(organizationService.getOrganization(1));
    }

    @Test
    void deleteOrganization() {
        var organization = organizationService.saveOrganization(getFakeOrganization());
        var sizeBefore = organizationService.getAllOrganizations().size();

        organizationService.deleteOrganization(organization.id());

        var sizeAfter = organizationService.getAllOrganizations().size();
        assertEquals(sizeBefore - 1, sizeAfter);
    }
}
