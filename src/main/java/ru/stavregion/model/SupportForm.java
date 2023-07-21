package ru.stavregion.model;

import jakarta.annotation.Nonnull;
import lombok.Builder;


@Builder(toBuilder = true)
public record SupportForm(@Nonnull String name,
                          @Nonnull String size,
                          @Nonnull String period,
                          @Nonnull String target) {
}
