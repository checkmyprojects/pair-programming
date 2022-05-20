package com.example.pairprogramming.service;

import com.example.pairprogramming.Entity.Cars;
import com.example.pairprogramming.Entity.User;
import com.example.pairprogramming.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplementsTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImplements underTest;

    @BeforeEach
    void setup(){
        underTest = new UserServiceImplements(userRepository);
    }

    @Test
    void findAll() {
        underTest.findAll();
        verify(userRepository).findAll();
    }

    @Test
    void save() {
        User user = new User(
                "name",
                "surname",
                "1223",
                "email"
        );
        underTest.save(user);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void findById() {
        User user = new User(
                1L,
                "name",
                "surname",
                "1223",
                "email"
        );
        underTest.findById(user.getId());
        verify(userRepository).findById(1L);
    }

    @Test
    void delete() {
        User user = new User(
                1L,
                "name",
                "surname",
                "1223",
                "email"
        );
        underTest.delete(user.getId());
        verify(userRepository).deleteById(1L);
    }
}