package chapter05.chapter05_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MemberTest {

    @Test
    void getter_setter_test() {
        Member member = new Member();
        member.setAge(27);
        member.setName("chocho");

        assertNotNull(member.getName());
    }
}