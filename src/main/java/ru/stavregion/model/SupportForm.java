package ru.stavregion.model;

import lombok.Builder;
import lombok.NonNull;


@Builder(toBuilder = true)
public record SupportForm(@NonNull String name, @NonNull String size, @NonNull String period, String target) {
}
