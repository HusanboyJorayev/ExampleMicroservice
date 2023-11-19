package com.example.first.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordTypeRequest {

    private Integer wordId;
    private Integer wordIds;
}
