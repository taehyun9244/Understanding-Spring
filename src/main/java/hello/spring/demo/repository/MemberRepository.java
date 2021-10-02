package hello.spring.demo.repository;

import hello.spring.demo.domain.Member;

import java.util.Optional;

public interface MemberRepository{

    Member save(Member member);
    Optional<Member> findById(Long id);


}
