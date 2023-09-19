package hello.core.member;

import hello.core.Appconfig;

public class MemberApp {
    public static void main(String[] args) {

        Appconfig appconfig = new Appconfig();
        MemberService memberService = appconfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());


    }
}
