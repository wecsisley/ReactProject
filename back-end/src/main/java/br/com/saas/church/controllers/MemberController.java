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
        if (memberService.getall() != null) {
            try {
                log.info("Success when access memberService");
                return memberService.getall();
            } catch (Exception e) {
                log.error("Error to access memberService");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.warn("Not found list of members");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable String id) {
        log.info("Trying access memberService");
        if (memberService.getById(id) != null) {
            try {
                log.info("Success when access memberService");
                return memberService.getById(id);
            } catch (Exception e) {
                log.error("Error to access memberService");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.warn("Not found member by id '" + id + "'");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity create(@RequestBody MemberDTO memberDTO) {
        log.info("Trying access memberService");
        if (memberService.create(memberDTO) != null) {
            try {
                log.info("Success when access memberService");
                return memberService.create(memberDTO);
            } catch (Exception e) {
                log.error("Error to access memberService");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.error("Invalid data");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody MemberDTO memberDTO) {
        log.info("Trying access memberService");
        if (memberService.getById(id) != null) {
            try {
                log.info("Success when access memberService");
                memberService.updateById(id, memberDTO);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                log.error("Error to access memberService");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.warn("Not found member by id '" + id + "'");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        log.info("Trying access memberService");
        if (memberService.getById(id) != null) {
            try {
                log.info("Success when access memberService");
                memberService.deleteById(id);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                log.error("Error to access memberService");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.warn("Not found member by id '" + id + "'");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
