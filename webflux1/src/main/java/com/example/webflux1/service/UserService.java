package com.example.webflux1.service;

import com.example.webflux1.repository.User;
import com.example.webflux1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

    public Mono<User> create(String name, String email){
        return userRepository.save(User.builder()
                .name(name).email(email).build());
    }

    public Flux<User> findAll(){
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id ){
        return userRepository.findById(id);
    }

    public Mono<Integer> deleteById(Long id){
        return userRepository.deleteById(id);
    }

    public Mono<?> update(Long id, String name, String email){
        //해당 사용자를 찾는다
        // 데이터를 변경하고 저장한다.
        return userRepository.findById(id)
                .flatMap(u -> {
                    u.setName(name);
                    u.setEmail(email);
                    return userRepository.save(u);
                });
    }


}
