package user;


import org.springframework.stereotype.Service;

@Service
public class UserServic {


    private final UserRepository userRepository;

    public <UsersRepository> UserServic(UsersRepository usersRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {

        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User updateUser(Long userId, User updatedUser) {
        // Find the existing user by userId
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));


        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        // Check if the user exists
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}

