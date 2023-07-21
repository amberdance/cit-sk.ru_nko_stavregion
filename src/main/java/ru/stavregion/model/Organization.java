package ru.stavregion.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.data.annotation.Id;


@Builder(toBuilder = true)
public record Organization(@Id Integer id, @NonNull String name,
                           @NonNull String address,
                           @NonNull @Size(min = 13, max = 15) String ogrn,
                           @NonNull @Size(min = 12, max = 12) String inn,
                           @NonNull @Pattern(regexp = "([\\d]{1,3})+(\\.[\\d]{1,3}|){1,}") String okvd,
                           @Valid @NotNull SupportForm supportForm, String violationInformation) {
}
