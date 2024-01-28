package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemmoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // AppConfig란
    //  "구현 객체를 생성"하고, "연결"하는 책임을 가지는 별도의 설정 클래스
    //  애플리케이션의 실제 동작에 필요한 "구현 객체를 생성"한다
    //  생선한 객체 인스턴스의 참조(래퍼런스)를 "생성자를 통해서 주입(연결)"해준다.


    public MemberService memberService() {
        return new MemberServiceImpl(new MemmoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemmoryMemberRepository(), new FixDiscountPolicy());
    }



}
