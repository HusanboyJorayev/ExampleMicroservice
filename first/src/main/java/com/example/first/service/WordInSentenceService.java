package com.example.first.service;


import com.example.first.dto.ErrorDto;
import com.example.first.dto.ResponseDto;
import com.example.first.entity.WordInSentence;
import com.example.first.repository.WordInSentenceRepository;
import com.example.first.request.WordInSentenceRequest;
import com.example.first.response.WordInSentenceResponse;
import com.example.first.service.mapper.WordInSentenceMapper;
import com.example.first.service.validation.WordInSentenceValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WordInSentenceService {
    private final WordInSentenceRepository wordInSentenceRepository;
    private final WordInSentenceMapper wordInSentenceMapper;
    private final WordInSentenceValidation wordInSentenceValidation;

    public ResponseDto<WordInSentenceResponse> create(WordInSentenceRequest request) {
        List<ErrorDto> errors = this.wordInSentenceValidation.validation(request);
        if (!errors.isEmpty()) {
            return ResponseDto.<WordInSentenceResponse>builder()
                    .code(-3)
                    .message("Validation error")
                    .build();
        }
        try {
            WordInSentence type = this.wordInSentenceMapper.toEntity(request);
            type.setCreatedAt(LocalDateTime.now());
            this.wordInSentenceRepository.save(type);

            return ResponseDto.<WordInSentenceResponse>builder()
                    .success(true)
                    .message("Ok")
                    .data(this.wordInSentenceMapper.toDto(type))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<WordInSentenceResponse>builder()
                    .code(-1)
                    .message("Type while saving error")
                    .build();
        }
    }

    public ResponseDto<WordInSentenceResponse> get(Integer id) {
        try {
            return this.wordInSentenceRepository.findByIdAndDeletedAtIsNull(id)
                    .map(type -> ResponseDto.<WordInSentenceResponse>builder()
                            .success(true)
                            .message("Ok")
                            .data(this.wordInSentenceMapper.toDto(type))
                            .build())
                    .orElse(ResponseDto.<WordInSentenceResponse>builder()
                            .code(-1)
                            .message("type is not found")
                            .build());

        } catch (Exception e) {
            return ResponseDto.<WordInSentenceResponse>builder()
                    .code(-1)
                    .message("Type while getting error")
                    .build();
        }
    }

    public ResponseDto<WordInSentenceResponse> update(WordInSentenceRequest request, Integer id) {
        List<ErrorDto> errors = this.wordInSentenceValidation.validation(request);
        if (!errors.isEmpty()) {
            return ResponseDto.<WordInSentenceResponse>builder()
                    .code(-3)
                    .message("Validation error")
                    .build();
        }
        try {
            return this.wordInSentenceRepository.findByIdAndDeletedAtIsNull(id)
                    .map(type -> {
                        type.setUpdatedAt(LocalDateTime.now());
                        this.wordInSentenceRepository.save(type);
                        this.wordInSentenceMapper.update(type, request);

                        return ResponseDto.<WordInSentenceResponse>builder()
                                .success(true)
                                .message("Ok")
                                .data(this.wordInSentenceMapper.toDto(type))
                                .build();
                    })
                    .orElse(ResponseDto.<WordInSentenceResponse>builder()
                            .code(-1)
                            .message("Type is not found")
                            .build());

        } catch (Exception e) {
            return ResponseDto.<WordInSentenceResponse>builder()
                    .code(-1)
                    .message("type while updating error")
                    .build();
        }
    }

    public ResponseDto<WordInSentenceResponse> delete(Integer id) {
        try {
            return this.wordInSentenceRepository.findByIdAndDeletedAtIsNull(id)
                    .map(type -> {
                        type.setDeletedAt(LocalDateTime.now());
                        this.wordInSentenceRepository.save(type);

                        return ResponseDto.<WordInSentenceResponse>builder()
                                .success(true)
                                .message("Ok")
                                .data(this.wordInSentenceMapper.toDto(type))
                                .build();
                    })
                    .orElse(ResponseDto.<WordInSentenceResponse>builder()
                            .code(-1)
                            .message("Type is not found")
                            .build());

        } catch (Exception e) {
            return ResponseDto.<WordInSentenceResponse>builder()
                    .code(-1)
                    .message("Type while deleting error")
                    .build();
        }
    }

    public ResponseDto<List<WordInSentenceResponse>> getAllType() {

        try {
            List<WordInSentence> types = this.wordInSentenceRepository.getAllByQuery();
            if (types.isEmpty()) {
                return ResponseDto.<List<WordInSentenceResponse>>builder()
                        .code(-1)
                        .message("Types are not found")
                        .build();
            }
            return ResponseDto.<List<WordInSentenceResponse>>builder()
                    .success(true)
                    .message("Ok")
                    .data(types.stream().map(this.wordInSentenceMapper::toDto).toList())
                    .build();
        } catch (Exception e) {
            return ResponseDto.<List<WordInSentenceResponse>>builder()
                    .code(-1)
                    .message("Types while getting all")
                    .build();
        }
    }

    public ResponseDto<Page<WordInSentenceResponse>> getPage(Integer page, Integer size) {
        Page<WordInSentence> typesPage = this.wordInSentenceRepository.findAllByDeletedAtIsNull(PageRequest.of(page, size));
        if (typesPage.isEmpty()) {
            return ResponseDto.<Page<WordInSentenceResponse>>builder()
                    .code(-1)
                    .message("types are not found")
                    .build();
        }
        return ResponseDto.<Page<WordInSentenceResponse>>builder()
                .success(true)
                .message("Ok")
                .data(typesPage.map(this.wordInSentenceMapper::toDto))
                .build();
    }

    public ResponseDto<WordInSentenceResponse> getAllByWordId(Integer id) {
        Optional<WordInSentence> optional = this.wordInSentenceRepository.findByWordIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<WordInSentenceResponse>builder()
                    .code(-1)
                    .message("WordInSentences are not found")
                    .build();
        }
        return ResponseDto.<WordInSentenceResponse>builder()
                .success(true)
                .message("Ok")
                .data(this.wordInSentenceMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<WordInSentenceResponse> getAllByWordInSentenceId(Integer id) {
        Optional<WordInSentence> optional = this.wordInSentenceRepository.findBySentenceIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<WordInSentenceResponse>builder()
                    .code(-1)
                    .message("WordInSentences are not found")
                    .build();
        }
        return ResponseDto.<WordInSentenceResponse>builder()
                .success(true)
                .message("Ok")
                .data(this.wordInSentenceMapper.toDto(optional.get()))
                .build();
    }
}
