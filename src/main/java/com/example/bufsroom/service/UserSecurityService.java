
package com.example.bufsroom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.bufsroom.repository.UserRepository;
import com.example.bufsroom.user.SiteUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SiteUser> _siteUser = this.userRepository.findByUsername(username);
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        SiteUser siteUser = _siteUser.get();

        // 사용자가 입력한 비밀번호를 데이터베이스에 저장된 비밀번호와 비교하여 인증을 수행
        return User.withUsername(siteUser.getUsername())
                .password(siteUser.getPassword()) // 데이터베이스에 저장된 암호
                .authorities(getAuthorities(siteUser))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    // 사용자의 권한을 설정하는 메서드
    private List<GrantedAuthority> getAuthorities(SiteUser siteUser) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(siteUser.getRole())); // 데이터베이스에서 가져온 사용자 권한 사용
        return authorities;
    }}
