package ru.stavregion.model;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import org.springframework.data.annotation.Id;


@Builder(toBuilder = true)
public record Organization(@Id Integer id,
                           @Nonnull String name,
                           @Nonnull String address,
                           @Nonnull String ogrn,
                           @Nonnull String inn,
                           @Nonnull String okvd,
                           @Nonnull SupportForm supportForm,
                           String violationInformation) {
}
