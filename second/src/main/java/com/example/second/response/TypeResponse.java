package com.example.second.response;

import com.example.second.client.WordTypeResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeResponse {
    private Integer id;
    @NotBlank(message = "name cannot be null or empty")
    private String name;
    @NotNull(message = "order cannot be null")
    private int orders;

    private List<WordTypeResponse>wordTypeResponse;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
