package com.example.second.response;

import com.example.second.client.DayWordResponse;
import com.example.second.client.NoteResponse;
import com.example.second.client.WordInSentenceResponse;
import com.example.second.client.WordTypeResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    private List<DayWordResponse>dayWordResponse;
    private List<NoteResponse>noteResponse;
    private List<WordInSentenceResponse>wordInSentenceResponse;
    private List<WordTypeResponse>wordTypeResponse;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
