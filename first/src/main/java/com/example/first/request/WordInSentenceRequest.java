package com.example.first.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordInSentenceRequest {
    private Integer wordId;
    private Integer sentenceId;
    private Integer orders;
}
