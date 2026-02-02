package com.example.boardv1.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserRepository.class) // 단위테스트 : 내가 필요한거만 띄워서 테스트 해보는것
@DataJpaTest // EntityManager가 ioc에 등록됨
public class UserRepositoryTest {
    @Test
    public void save_fail_test() {
        // given
        User user = new User(); // 비영속개체
        user.setUsername("ssar");
        user.setPassword("1234");
        user.setEmail("ra@nate.com");
        // when
        User findUser = userRepository.save(user); // 영속화됨

        // eye
        System.out.println(findUser);
    }
    @Autowired
    private UserRepository userRepository;

    @Test
    public void save_test() {
        // given
        User user = new User(); // 비영속개체
        user.setUsername("love");
        user.setPassword("1234");
        user.setEmail("love@nate.com");
        // when
        User findUser = userRepository.save(user); // 영속화됨

        // eye
        System.out.println(findUser);
    }

    @Test
    public void findByUsername() {
        // given
        String username = "ssar";

        // when
        User findUser = userRepository.findByUsername(username);
    
        // eye
        System.out.println(findUser);
    }
}
