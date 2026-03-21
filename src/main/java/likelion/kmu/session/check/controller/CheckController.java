package likelion.kmu.session.check.controller;

import likelion.kmu.session.check.entity.dto.response.CheckResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/check")
public class CheckController {

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<CheckResponseDTO> check(){
        return ResponseEntity.ok(new  CheckResponseDTO("ok"));
    }
}
