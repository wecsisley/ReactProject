package br.com.saas.church.controllers;

import br.com.saas.church.dtos.MemberDTO;
import br.com.saas.church.services.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> findAll() {
        return memberService.getall();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable String id) {
        return memberService.getById(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MemberDTO memberDTO) {
        return memberService.create(memberDTO);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable String id, @RequestBody MemberDTO memberDTO) {
        memberService.updateById(id, memberDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable String id) {
        memberService.deleteById(id);
    }
}
