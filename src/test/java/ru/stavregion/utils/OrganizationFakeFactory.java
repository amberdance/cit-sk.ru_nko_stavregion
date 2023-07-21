package ru.stavregion.utils;


import org.apache.commons.lang3.RandomStringUtils;
import ru.stavregion.model.Organization;
import ru.stavregion.model.SupportForm;

public final class OrganizationFakeFactory {

    private OrganizationFakeFactory() {
    }

    public static Organization getOrganization() {
        var randomString = getRandomString(16);
        var supportForm = getSupportForm();

        return Organization.builder()
                .name(randomString)
                .address(randomString)
                .inn("123456789012")
                .okvd("12.12")
                .ogrn("1234567890123")
                .supportForm(supportForm)
                .violationInformation(randomString)
                .build();
    }

    public static Organization getOrganizationWithId(int id) {
        var random = getRandomString(16);
        var supportForm = getSupportForm();

        return Organization.builder()
                .id(id)
                .name(random)
                .address(random)
                .inn("123456789012")
                .okvd("12.12")
                .ogrn("1234567890123")
                .supportForm(supportForm)
                .violationInformation(random)
                .build();
    }

    public static SupportForm getSupportForm() {
        var randomString = getRandomString(16);

        return SupportForm.builder()
                .name(randomString)
                .period(randomString)
                .size("123123123")
                .target(randomString)
                .build();
    }

    private static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
