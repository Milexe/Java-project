package by.savin.comprent.security;

import by.savin.comprent.entity.User;
import by.savin.comprent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public JwtInMemoryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user1 = userRepository.findUserByUsername(username);

        if(user1.isEmpty()) throw new UsernameNotFoundException("User not found");
        User user = user1.get();
        return new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(), user.getRole().getName());
    }
}
