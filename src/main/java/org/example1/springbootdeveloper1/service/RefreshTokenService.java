package org.example1.springbootdeveloper1.service;

import lombok.RequiredArgsConstructor;
import org.example1.springbootdeveloper1.domain.RefreshToken;
import org.example1.springbootdeveloper1.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }

}
