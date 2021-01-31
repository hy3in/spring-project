package com.example.demo.member.service.impl;


import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.dao.MemberDAO;
import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public ResponseEntity<Object> loginReq(String id, String password) {
        // id가 존재하지 않는 경우
        if (false) {
            return ResponseEntity.badRequest().body("아이디가 존재하지 않습니다.");
        }

        // password fail
        if (false) {
            return ResponseEntity.badRequest().body("비밀번호가 틀렸습니다.");
        }

        return ResponseEntity.ok().body("로그인 성공");
    }

    //회원가입
    @Override
    @Transactional
    public boolean signUp(MemberDTO.SignUpDTO signUpDTO) {

        signUpDTO.setPassword(passwordEncoder.encode(signUpDTO.getPassword())); // 비밀번호 단방향 암호화

        int dbResult = memberDAO.addMember(signUpDTO.convertSignUpDTOToMemberVO());
        if (dbResult != 1) { // transaction rollback을 위해서 의도적으로 예외처리를 함.
            throw new RuntimeException();
        }

        return true;
    }

    @Override
    public ResponseEntity<Object> logOutReq(String userId, String password) {
        return null;
    }

    //회원탈퇴
    @Override
    @Transactional
    public boolean withdrawal(MemberDTO.WithdrawalDTO withdrawalDTO) {

        withdrawalDTO.setPassword(passwordEncoder.encode(withdrawalDTO.getPassword()));

        int dbResult = memberDAO.deleteMember(withdrawalDTO.convertSignUpDTOToMemberVO());
        if (dbResult != 1) {
            throw new RuntimeException();
        }
        return true;
    }

    //이메일 중복체크
    public boolean userEmailCheck(String Email, String Name) {

        MemberVO user = memberDAO.findUserByUserId(Email);
        if (user != null && user.getName().equals(Name)) {
            return true;
        } else {
            return false;
        }
    }

    //아이디 중복체크
    @Override
    public int userIdCheck(String userId) {
        return memberDAO.checkOverId(userId);
    }

    // 비밀번호 중복체크
    @Override
    public int userEmailCheck(String email) {
        return memberDAO.checkOverEmail(email);
    }

    @Override
    public int loginFailCountIncrease(String userId) {
        return 0;
    }

    @Override
    public int getLoginFailCount(String userId) {
        return 0;
    }

    @Override
    public int loginFailCountInitialize(String userId) {
        return 0;
    }
}


