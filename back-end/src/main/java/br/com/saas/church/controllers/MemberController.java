package br.com.saas.church.controllers;

import br.com.saas.church.dtos.MemberDTO;
import br.com.saas.church.services.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> findAll() {
        log.info("Trying access memberService ");
        return memberService.getall();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable String id) {
        log.info("Trying access memberService");
        return memberService.getById(id);
    }


    @PostMapping
    public ResponseEntity create(@RequestBody MemberDTO memberDTO) {
        log.info("Trying access memberService");
        return memberService.create(memberDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody MemberDTO memberDTO) {
        log.info("Trying access memberService");
        memberService.updateById(id, memberDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        log.info("Trying access memberService");
        memberService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
