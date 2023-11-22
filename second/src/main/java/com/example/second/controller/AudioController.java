package com.example.second.controller;

import com.example.second.dto.ResponseDto;
import com.example.second.response.AudioResponse;
import com.example.second.service.AudioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("audio")
@Tag(name = "Audio api")
public class AudioController {

    private final AudioService audioService;


    @PostMapping("/upload")
    public ResponseDto<AudioResponse> upload(@RequestBody MultipartFile file) {
        return this.audioService.upload(file);
    }

    @GetMapping("/download")
    public ResponseDto<AudioResponse> download(@RequestParam Integer id) {
        return this.audioService.download(id);
    }

    @PutMapping("/update")
    public ResponseDto<AudioResponse> update(@RequestBody MultipartFile file, @RequestParam Integer id) {
        return this.audioService.update(file, id);
    }

    @DeleteMapping("/delete")
    ResponseDto<AudioResponse> delet(@RequestParam Integer id) {
        return this.audioService.delete(id);
    }
}
