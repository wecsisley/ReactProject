package br.com.saas.church.services;

import br.com.saas.church.dtos.MemberDTO;
import br.com.saas.church.models.Member;
import br.com.saas.church.repositories.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberService {

    private MemberRepository memberRepository;
    private ModelMapper modelMapper;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<MemberDTO>> getall() {
        log.info("Trying search for a list with members ");
        try {
            log.info("Searching for a list with members");
            List<Member> memberList = memberRepository.findAll();
            log.info("List with members finded with sucess !");
            log.info("Trying to convert a list of members to get a list with memberDTO");
            Type listType = new TypeToken<List<MemberDTO>>() {
            }.getType();
            log.info("Converting list with members in list with membersDTO");
            List<MemberDTO> memberDtoList = modelMapper.map(memberList, listType);
            log.info("Successful conversion!");
            log.info("Returning list with membersDTO");
            return ResponseEntity.ok(memberDtoList);
        } catch (Exception e) {
            log.error("Error fetching list of membersDTO");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<MemberDTO> getById(String id) {
        log.info("Trying search member by id '" + id + "'");
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            try {
                log.info("Member finded with sucess !");
                Optional<Member> memberOptinal = memberRepository.findById(id);
                log.info("Trying to convert member in memberDTO");
                MemberDTO memberDto = modelMapper.map(memberOptinal.get(), MemberDTO.class);
                log.info("Sucessful conversion !");
                log.info("Returning memberDTO by id '" + memberDto.getId() + "'");
                return ResponseEntity.ok(memberDto);
            } catch (Exception e) {
                log.error("Error fetching members");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.warn("Member not found by id '" + id + "'");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    public ResponseEntity create(MemberDTO memberDTO) {
        log.info("Trying create memberDTO");
        log.info("Trying to convert memberDTO in member");
        Member member = modelMapper.map(memberDTO, Member.class);
        log.info("Sucessful conversion !");
        log.info("Trying save member in database");
        memberRepository.save(member);
        log.info("Member save in database");
        if (member.getId() != null) {
            try {
                log.info("MemberDTO created with sucess");
                log.info("Trying to convert member in memberDTO");
                memberDTO = modelMapper.map(member, MemberDTO.class);
                log.info("Sucessful conversion");
                log.info("Returnin memberDTO");
                return ResponseEntity.ok(memberDTO);
            } catch (Exception e) {
                log.error("Error to create memberDTO");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.warn("MemberDTO not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity updateById(String id, MemberDTO memberDTO) {
        log.info("Trying update memberDTO by id '" + id + "'");
        log.info("Trying to convert memberDTO in member");
        Member member = modelMapper.map(memberDTO, Member.class);
        log.info("Sucessful conversion");
        log.info("Searching member by id '" + id + "'");
        if (member.getId() != null) {
            try {
                log.info("Member finded by id '" + member.getId() + "'");
                log.info("Trying to convert member in TemporaryMember");
                Member TemporaryMember = member;
                log.info("Trying save TemporaryMember in database");
                memberRepository.save(TemporaryMember);
                log.info("TemporaryMember save in database");
                log.info("Returning TemporaryMember");
                return ResponseEntity.ok(TemporaryMember);
            } catch (Exception e) {
                log.error("Error to update memberDTO by id '" + id + "'");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.warn("MemberDTO not found by id '" + id + "'");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity deleteById(String id) {
        log.info("Searching member by id '" + id + "' in database");
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            try {
                log.info("id '" + id + "' finded with sucess !");
                log.info("Deleting member by id '" + id + "'");
                memberRepository.deleteById(id);
                log.info("Member deleted by id '" + id + "' with sucess !");
                return ResponseEntity.ok(id);
            } catch (Exception e) {
                log.error("Error fetching member by id '" + id + "' in database");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            log.warn("Not found member by id '" + id + "'");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    private void verifyIfMemberExists(String id) {
//        log.info("Verifying if member exist");
//        if (memberRepository.findById(id).get() == null)
//            throw new ResourceNotFoundException("Member not found by ID: " + id);
//    }
}
