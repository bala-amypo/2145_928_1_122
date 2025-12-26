@Override
public LoginResponse login(String email, String password) {

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }

    String token = jwtUtil.generateToken(
            user.getId(),
            user.getEmail(),
            user.getRole()
    );

    return new LoginResponse(
            token,
            user.getId(),
            user.getEmail(),
            user.getRole()
    );
}
