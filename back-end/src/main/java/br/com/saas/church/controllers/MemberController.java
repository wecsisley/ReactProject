package br.com.saas.church.controllers;

import br.com.saas.church.dtos.MemberDTO;
import br.com.saas.church.services.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        try {
            if (memberService.getall() != null) {
                log.info("Success when access memberService");
                return memberService.getall();
            } else {
                log.warn("Not found list of members");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        } catch (Exception e) {
            log.error("Error to access memberService");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable String id) {
        log.info("Trying access memberService");
        try {
            if (memberService.getById(id) != null) {
                log.info("Success when access memberService");
                return memberService.getById(id);
            } else {
                log.warn("Not found member by id '" + id + "'");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            log.error("Error to access memberService");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MemberDTO memberDTO) {
        log.info("Trying access memberService");
        try {
            if (memberService.create(memberDTO) != null) {
                log.info("Success when access memberService");
                return memberService.create(memberDTO);
            } else {
                log.error("Invalid data");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

        } catch (Exception e) {
            log.error("Error to access memberService");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody MemberDTO memberDTO) {
        log.info("Trying access memberService");
        try {
            if (memberService.getById(id) != null) {
                log.info("Success when access memberService");
                memberService.updateById(id, memberDTO);
                return ResponseEntity.ok().build();
            } else {
                log.warn("Not found member by id '" + id + "'");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            log.error("Error to access memberService");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        log.info("Trying access memberService");
        try {
            if (memberService.getById(id) != null) {
                log.info("Success when access memberService");
                memberService.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                log.warn("Not found member by id '" + id + "'");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            log.error("Error to access memberService");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
