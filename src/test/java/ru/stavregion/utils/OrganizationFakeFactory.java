package ru.stavregion.utils;


import org.apache.commons.lang3.RandomStringUtils;
import ru.stavregion.model.Organization;
import ru.stavregion.model.SupportForm;

public final class OrganizationFakeFactory {

    private OrganizationFakeFactory() {
    }

    public static Organization getOrganization() {
        var random = getRandomString(16);
        var supportForm = SupportForm.builder()
                .name(random)
                .period(random)
                .size(random)
                .target(random)
                .build();

        return Organization.builder()
                .name(random)
                .address(random)
                .inn(random)
                .okvd(random)
                .ogrn(random)
                .supportForm(supportForm)
                .violationInformation(random)
                .build();
    }

    public static Organization getOrganizationWithId(int id) {
        var random = getRandomString(16);
        var supportForm = SupportForm.builder()
                .name(random)
                .period(random)
                .size(random)
                .target(random)
                .build();

        return Organization.builder()
                .id(id)
                .name(random)
                .address(random)
                .inn(random)
                .okvd(random)
                .ogrn(random)
                .supportForm(supportForm)
                .violationInformation(random)
                .build();
    }

    private static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
