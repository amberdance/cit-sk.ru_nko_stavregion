package ru.stavregion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.NonNull;

import java.util.Date;


@Builder(toBuilder = true)
public record SupportForm(@NonNull String name,
                          @NonNull @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.mm.YY") Date supportDate,
                          @NonNull String period,
                          @Pattern(regexp = "^\\d+$") String size,
                          String target) {
}
