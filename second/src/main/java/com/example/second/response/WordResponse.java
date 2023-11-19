package com.example.second.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordResponse {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String transcript;
    private Integer categoryId;
    private Integer audioId;
    private int numView;
    private int numLike;
    private int numShare;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
