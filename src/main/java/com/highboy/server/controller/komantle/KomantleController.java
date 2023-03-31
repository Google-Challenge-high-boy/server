package com.highboy.server.controller.komantle;

import com.highboy.server.controller.komantle.dto.KomantleAnswerResponseDto;
import com.highboy.server.controller.komantle.dto.KomantleRequestDto;
import com.highboy.server.controller.komantle.dto.KomantleResponseDto;
import com.highboy.server.service.KomantleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RequestMapping("/v1/komantle")
@RestController
@RequiredArgsConstructor
public class KomantleController {

    private  final KomantleService komantleService;

    @GetMapping("")
    public KomantleResponseDto getAllAnswer(){
        Map<String, Object> answerList =  komantleService.getAllAnswer();
        return new KomantleResponseDto(answerList);
    }

    @PostMapping("")
    public KomantleAnswerResponseDto checkAnswer(HttpServletRequest request, @Valid @RequestBody KomantleRequestDto komantleRequestDto){
        int userId = Integer.parseInt(request.getHeader("userId"));
        KomantleAnswerResponseDto result = komantleService.checkAnswer(komantleRequestDto);
        if(result.getSimilarity()== 100 && userId != -1){
            //save
        }
        return result;
    }
}
