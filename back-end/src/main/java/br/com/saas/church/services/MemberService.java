package br.com.saas.church.services;

import br.com.saas.church.dtos.MemberDTO;
import br.com.saas.church.models.Member;
import br.com.saas.church.repositories.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    }

    public List<MemberDTO> getall() {
        try {
            List<Member> memberList = memberRepository.findAll();
            Type listType = new TypeToken<List<MemberDTO>>() {
            }.getType();
            List<MemberDTO> memberDtoList = modelMapper.map(memberList, listType);
            return memberDtoList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public MemberDTO getById(String id) {
        Optional<Member> membro = memberRepository.findById(id);
        MemberDTO memberDto = modelMapper.map(membro, MemberDTO.class);
        return memberDto;
    }

    public void create(Member member) {
        memberRepository.save(member);
    }

    public void update(Member member) {
        memberRepository.save(member);
    }

    public void deleteById(String id) {
        memberRepository.deleteById(id);
    }
}
