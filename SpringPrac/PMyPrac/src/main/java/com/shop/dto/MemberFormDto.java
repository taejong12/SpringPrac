package com.shop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {

	// 제약조건 @NotBlank는 문자열에 안 쪽에 빈값이 있는지 골라낸다
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    // @NotEmpty는 null 체크
    @NotEmpty(message = "이메일은 필수 입력 값입니다.") 
    // 이메일 형식이 아닌 때 막아준다
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    // 길이 제약조건
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
    private String password;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;
}
