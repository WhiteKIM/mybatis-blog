package whitekim.mybatisblog.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whitekim.mybatisblog.model.Member;
import whitekim.mybatisblog.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public void update(Member member) {
        memberRepository.update(member);
    }
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public void login(Member loginMember, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("loginAdmin", loginMember);
    }
}
