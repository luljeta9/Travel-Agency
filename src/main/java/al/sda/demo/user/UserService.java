package al.sda.demo.user;

import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long userId);
    Page<UserDto> getAllUsers(int page, int size);
    void createUser(UserDto user);
    void updateUser(UserDto user);
    void deleteUser(Long userId);
}

