package likelion.kmu.session.check.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import likelion.kmu.session.check.entity.dto.response.CheckResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/check")
@Tag(name = "check", description = "서버 상태 API")
public class CheckController {

    @GetMapping("")
    @ResponseBody
    @Operation(summary = "서버 상태", description = "서버 활성화를 확인합니다.")
    public ResponseEntity<CheckResponseDTO> check(){
        return ResponseEntity.ok(new  CheckResponseDTO("ok"));
    }
}
