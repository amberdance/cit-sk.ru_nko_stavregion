package ru.stavregion.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.stavregion.exception.ModelNotFoundException;
import ru.stavregion.model.Organization;
import ru.stavregion.service.OrganizationService;
import ru.stavregion.utils.OrganizationFakeFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrganizationControllerTest extends AbstractRestControllerConfig {

    private static final String API_PATH = "/api/organizations";

    @Autowired
    private OrganizationService organizationService;

    @Test
    void getAll() throws Exception {
        var organizations = organizationService.findAllOrganizations();

        mockHttpGet(API_PATH)
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(organizations)));
    }

    @Test
    void deleteOrganization() throws Exception {
        var organization = organizationService.findAnyOrganization();
        // Ensure that organization exists in storage before delete
        assertNotNull(organization);

        var id = organization.id();
        mockHttpDelete(API_PATH + "/{id}", id).andExpect(status().isNoContent());
        assertThrows(ModelNotFoundException.class, () -> organizationService.findOrganization(id));
    }

    @Test
    void createOrganization() throws Exception {
        var organization = OrganizationFakeFactory.getOrganization();
        var response = mockHttpPost(API_PATH, organization).andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        var responseOrganization = objectMapper.readValue(response, Organization.class);

        assertNotNull(responseOrganization.id());
        assertEquals(organization.supportForm(), responseOrganization.supportForm());
        assertEquals(organization.violationInformation(), responseOrganization.violationInformation());
        assertEquals(organization.okvd(), responseOrganization.okvd());
        assertEquals(organization.inn(), responseOrganization.inn());
        assertEquals(organization.name(), responseOrganization.name());
        assertEquals(organization.address(), responseOrganization.address());
        assertEquals(organization.ogrn(), responseOrganization.ogrn());
    }
}
