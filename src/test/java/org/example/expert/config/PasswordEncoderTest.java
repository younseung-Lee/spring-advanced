package org.example.expert.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * @ExtendWith(SpringExtension.class) :JUnit5에서 Spring의 기능을 테스트에서 사용할 수 있게 해주는 어노테이션
 * @InjectMocks: Mockito에서 사용하는 어노테이션
 * encodedPassword → DB 등에 저장된 값
 * rawPassword → 사용자가 입력한 비밀번호
 * */
@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @Test
    void matches_메서드가_정상적으로_동작한다() {
        // given
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // when
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);

        // then
        assertTrue(matches);
    }
}
