package ru.stavregion.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.data.annotation.Id;


@Builder(toBuilder = true)
public record Organization(@Id Integer id, @NonNull String name,
                           @NonNull String address,
                           @NonNull String ogrn,
                           @NonNull String inn,
                           @NonNull String okvd,
                           @NotNull SupportForm supportForm, String violationInformation) {
}
