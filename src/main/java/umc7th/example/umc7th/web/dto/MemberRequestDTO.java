package umc7th.example.umc7th.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc7th.example.umc7th.domain.enums.Role;
import umc7th.example.umc7th.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
        @NotNull
        Role role;
    }
}