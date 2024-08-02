package al.sda.demo.user.service;

import al.sda.demo.user.maper.UserMapper;
import al.sda.demo.user.model.User;
import al.sda.demo.user.model.UserDto;
import al.sda.demo.user.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserById(Long userId) {
        return userRepository.findById(userId)
                       .map(UserMapper::toDto)
                       .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public Page<UserDto> getAllUsers(int page, int size) {
        List<UserDto> users = userRepository.findAll(PageRequest.of(page, size)).stream()
                                  .map(UserMapper::toDto)
                                  .toList();
        return new PageImpl<>(users);
    }

    public void createUser(UserDto user) {
        validateUniqueConstraints(user);
        userRepository.save(UserMapper.toEntity(user));
    }

    public void updateUser(UserDto user) {
        validateUniqueConstraints(user);
        User updateCandidate = UserMapper.toEntity(user);
        
        if (!userRepository.existsById(updateCandidate.getId())) {
            throw new EntityNotFoundException("User does not exist");
        }
        
        userRepository.save(updateCandidate);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
    private void validateUniqueConstraints(UserDto user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new EntityExistsException("This username is already in use");
        } else if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EntityExistsException("This email is already in use");
        }
    }

    public Long saveUser(UserDto user) {
        return null;
    }
}
