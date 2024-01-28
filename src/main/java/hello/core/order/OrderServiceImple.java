package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemmoryMemberRepository;

public class OrderServiceImple implements OrderService{

    private final MemberRepository memberRepository = new MemmoryMemberRepository();
    private DiscountPolicy discountPolicy;

    // 새로운 할인 정책 적용과 문제점!!
    // 현재 문제점
    //      1) OCP위반
    //          FixDiscountPolicy()를 RateDiscoutPolicy()로 변경하는 순간 위배가된다.
    //          현재 코드는 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 준다!!
    //          ex)
    //          // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //             private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //      2) DIP위반
    //          추상(인터페이스) 뿐만 아니라 "구체(구현)클래스에도 의존"하고 있다.
    //          ex)
    //             private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =  memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
