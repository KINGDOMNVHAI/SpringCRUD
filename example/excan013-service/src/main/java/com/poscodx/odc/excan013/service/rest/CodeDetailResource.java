package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.entity.EStatus;
import com.poscdx.odc.excan013.domain.entity.ExcanCodeDetail;
import com.poscdx.odc.excan013.domain.entity.ExcanUser;
import com.poscdx.odc.excan013.domain.entity.payload.response.UserResponse;
import com.poscdx.odc.excan013.domain.spec.ExcanCodeDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/code-master")
public class CodeDetailResource {

    private final ExcanCodeDetailService codeDetailService;

    @GetMapping("/get-code/{code}")
    public List<ExcanCodeDetail> getCodeDetail(@PathVariable("code") String code){
        return codeDetailService.findByCodeMaster(code);
    }

}
