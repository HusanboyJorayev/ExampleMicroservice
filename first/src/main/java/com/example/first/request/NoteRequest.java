package com.example.first.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteRequest {
    private Integer wordId;
    private String title;
    private String description;
    private String source;
}
