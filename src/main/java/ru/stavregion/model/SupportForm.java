package ru.stavregion.model;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.NonNull;


@Builder(toBuilder = true)
public record SupportForm(@NonNull String name, @NonNull String period, @Pattern(regexp = "^\\d+$") String size,
                          String target) {
}
