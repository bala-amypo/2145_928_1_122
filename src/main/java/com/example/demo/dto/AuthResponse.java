// package com.example.demo.dto;

// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;

// public class RegisterRequest {

//     @NotBlank(message = "Full name is required")
//     private String fullName;

//     @Email(message = "Invalid email format")
//     @NotBlank(message = "Email is required")
//     private String email;

//     @NotBlank(message = "Password is required")
//     @Size(min = 6, message = "Password must be at least 6 characters")
//     private String password;

//     @NotBlank(message = "Role is required")
//     private String role;

//     public String getFullName() {
//         return fullName;
//     }

//     public void setFullName(String fullName) {
//         this.fullName = fullName;
//     }

//     public String getEmail() {
//         return email;
//     }
 
//     public void setEmail(String email) {
//         this.email = email;
//     }
 
//     public String getPassword() {
//         return password;
//     }
 
//     public void setPassword(String password) {
//         this.password = password;
//     }
 
//     public String getRole() {
//         return role;
//     }
 
//     public void setRole(String role) {
//         this.role = role;
//     }
// }
package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;

    public AuthResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    public String getToken() { return token; }
    public Long getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
