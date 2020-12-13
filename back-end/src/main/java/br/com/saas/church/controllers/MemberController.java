package br.com.saas.church.controllers;

import br.com.saas.church.dtos.MemberDTO;
import br.com.saas.church.models.Member;
import br.com.saas.church.services.MemberService;
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
    public List<MemberDTO> findAll() {
        return memberService.getall();
    }

    @PostMapping
    public void create(@RequestBody Member member) {
        memberService.create(member);
    }

    @PutMapping
    public void update(@RequestBody Member member) {
        memberService.update(member);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable String id) {
        memberService.deleteById(id);
    }
}
