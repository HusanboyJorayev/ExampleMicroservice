package com.example.second.client;

import com.example.second.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientSpecification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(name = "",path ="/first/wordType" /*"http://localhost:8090"*/)
@FeignClient("first")
public interface WordTypeClient {

    //@GetMapping("/getAllByWordId")
    @RequestMapping(method = RequestMethod.GET, value = "/wordType/getAllByWordId")
    ResponseDto<List<WordTypeResponse>> getAllByWordId(@RequestParam Integer id);

    //@GetMapping("/getAllByTypeId")
    @RequestMapping(method = RequestMethod.GET, value = "/wordType/getAllByTypeId")
    ResponseDto<List<WordTypeResponse>> getAllByTypeId(@RequestParam Integer id);


    @RequestMapping(method = RequestMethod.GET, value = ("/dayWord/getAllDayWordByWordId"))
    ResponseDto<List<DayWordResponse>> getAllDayWordByWordId(@RequestParam Integer id);

    @RequestMapping(method = RequestMethod.GET, value = ("/note/getAllNoteByWordId"))
    ResponseDto<List<NoteResponse>> getAllNoteByWordId(@RequestParam Integer id);


    @RequestMapping(method = RequestMethod.GET, value = "/wordInSentence/getAllWordInSentenceByWordId")
    ResponseDto<List<WordInSentenceResponse>> getAllWordInSentenceByWordId(@RequestParam Integer id);

    @RequestMapping(method = RequestMethod.GET, value = "/wordInSentence/getAllByWordInSentenceBySentenceId")
    ResponseDto<List<WordInSentenceResponse>> getAllWordInSentenceBySentenceId(@RequestParam Integer id);

}
