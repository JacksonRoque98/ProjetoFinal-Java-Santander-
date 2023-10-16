package Final.Project.service.impl;

import Final.Project.domain.model.User;
import Final.Project.domain.repository.UserRepository;
import Final.Project.service.UserService;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserImpl implements UserService {

    private final UserRepository userRepository;
    public UserImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public User create(User userToCreate) {
//        if(userRepository.existByCpf(userToCreate.getCpf())){
//            throw new RuntimeException("This USER by CPF alredy exists");
//        }
        return userRepository.save(userToCreate);
    }

    @Transactional
    public User updateCar(Long id, User userUpdate) {
        User dbUser = this.findById(id);
        if(!dbUser.getId().equals(userUpdate.getId())){
            throw new RuntimeException("Update IDs must be the same.");
        }
        dbUser.setCar(userUpdate.getCar());

        return this.userRepository.save(dbUser);
    }

    @Transactional
    public void delete(Long id) {
        User dbUser = this.findById(id);
        this.userRepository.delete(dbUser);
    }
}
