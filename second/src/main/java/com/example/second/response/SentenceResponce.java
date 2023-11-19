package com.example.second.response;

import com.example.second.client.WordInSentenceResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SentenceResponce {
    private Integer id;
    @NotBlank
    private String content;

    private List<WordInSentenceResponse>wordInSentenceResponse;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
