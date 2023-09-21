package hello.core.beanfind;

import hello.core.Appconfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberSeviceImpl;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

    @Test
    @DisplayName("빈 이름으로 조회.")


    void findBeanByName(){
       MemberService memberService = ac.getBean("memberService", MemberService.class);
       System.out.println("memberService = " + memberService);
       System.out.println("memberService = " + memberService.getClass());
       Assertions.assertThrows(NoSuchBeanDefinitionException.class,() -> ac.getBean("xxxxx", MemberService.class));

    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회.")


    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);

        Assertions.assertThrows(NoSuchBeanDefinitionException.class,() -> ac.getBean("xxxxx", MemberService.class));

    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberSeviceImpl memberService = ac.getBean("memberService",
                MemberSeviceImpl.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,() -> ac.getBean("xxxxx", MemberService.class));
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxxx", MemberService.class));
    }
//    @Configuration
//    static class SameBeanConfig{
//        @Bean
//        public MemberRepository memberRepository1() {
//            return new MemoryMemberRepository();
//        }
//
//        @Bean
//        public MemberRepository memberRepository2() {
//            return new MemoryMemberRepository();
//        }
//    }


}
