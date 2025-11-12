package com.example.demo.service;

import com.example.demo.client.UserClient;
import com.example.demo.client.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    private UserClient userClient;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userClient = Mockito.mock(UserClient.class);
        userService = new UserService(userClient);
    }

    @Test
    void getUser_returnsDto() {
        UserDto dto = new UserDto(1L, "John", "johnny", "john@example.com");
        Mockito.when(userClient.getUserById(1L)).thenReturn(dto);

        UserDto res = userService.getUser(1L);
        assertThat(res).isNotNull();
        assertThat(res.name()).isEqualTo("John");
    }
}
