package com.example.first.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordTypeResponse {
    private Integer id;
    private Integer wordId;
    private Integer wordIds;
    private Integer typeId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
