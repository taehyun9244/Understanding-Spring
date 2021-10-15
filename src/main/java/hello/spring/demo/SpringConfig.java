package hello.spring.demo;

import hello.spring.demo.repository.MemberRepository;
import hello.spring.demo.repository.MemoryMemberRepository;
import hello.spring.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
