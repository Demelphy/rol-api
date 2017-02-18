package es.esky.rol.users.service.impl;

import es.esky.rol.arch.jpa.JpaService;
import es.esky.rol.users.api.exception.UserNotFoundException;
import es.esky.rol.users.domain.User;
import es.esky.rol.users.repository.UsersRepository;
import es.esky.rol.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Cristian Mateos López
 */
@JpaService
public class JpaUsersService implements UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public JpaUsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findByCriteria(Pageable page) {
        return usersRepository.findAll(page);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return Optional.ofNullable(usersRepository.findOne(username)).orElseThrow(UserNotFoundException::new);
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        try {
            usersRepository.delete(username);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException();
        }
    }

    @Override
    @Transactional
    public User save(User user) {
        String unhashedPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(unhashedPassword));
        return usersRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(String username) {
        return usersRepository.exists(username);
    }
}
