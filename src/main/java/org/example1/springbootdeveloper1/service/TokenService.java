package org.example1.springbootdeveloper1.service;

import lombok.RequiredArgsConstructor;
import org.example1.springbootdeveloper1.config.jwt.TokenProvider;
import org.example1.springbootdeveloper1.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken){
        //토큰 유효성검사에 실패함변 예외발생
        if (!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("unexpected token");
        }
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
