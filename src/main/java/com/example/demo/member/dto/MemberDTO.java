package com.example.demo.member.dto;

import com.example.demo.common.cd.MemberGradeCd;
import com.example.demo.common.cd.MemberStatusCd;
import com.example.demo.member.vo.MemberVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MemberDTO {


    @Data
    public static class SignUpDTO {

        @NotBlank(message = "name can not be null or empty")
        private String name;

        @NotBlank(message = "email can not be null or empty")
        private String email;

        @NotBlank(message = "userId can not be null or empty")
        private String userId;

        @NotBlank(message = "password can not be null or empty")
        private String password;

        private String role;
        private String grade;

        /**
         * dto로 전달 받은 데이터를 기준으로 DAO에서 사용할 수 있는 VO로 변환해주는 메소드
         *
         * @return
         */
        public MemberVO convertSignUpDTOToMemberVO() {
            return new MemberVO(this.getUserId(), this.getPassword(), this.getName(), this.getEmail());
        }
    }

    @Data
    public static class LoginReqDTO {
        @NotBlank(message = "id can not be null or empty")
        private String id;
        @NotBlank(message = "password can not be null or empty")
        private String password;
    }

    @Data
    public static class GetListReqDTO {
        private String userId;

        /**
         * dto로 전달 받은 데이터를 기준으로 DAO에서 사용할 수 있는 VO로 변환해주는 메소드
         *
         * @return
         */
        public MemberVO convertSignUpDTOToMemberVO() {
            return new MemberVO(this.getUserId());
        }

    }

    //신고회원 조회
    @Data
    public static class GetListReportReqDTO {
        private String userId;

        public MemberVO convertSignUpDTOToMemberVO() {

            return new MemberVO(this.getUserId());
        }
    }

    //비활성화 회원 조회
    @Data
    public static class GetListDormantReqDTO {
        private String userId;
        private String name;
        private String status;

        public MemberVO convertSignUpDTOToMemberVO() {

            return new MemberVO(this.getUserId(),this.getStatus());
        }
    }


    @Data
    public static class GetMemberInfoRes {
        private String userId;
        private String name;
        private String email;
        private String grade;
        private String status;
        private String reportId;
    }

    @Data
    public static class MailDto {
        private String address;
        private String title;
        private String message;
    }

}
