package hello.spring.demo.service;

import hello.spring.demo.domain.Member;
import hello.spring.demo.repository.MemberRepository;
import hello.spring.demo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     *회원가입 (sing up)
     */
    public Long join(Member member){
//        같은 이름이 있는 중복회원X 同じ名前のSING UPできない
        validateDuplicateMember(member); //중복 회원 검증　重複会員検証
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findbyName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원조회 (Member inquiry)
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
