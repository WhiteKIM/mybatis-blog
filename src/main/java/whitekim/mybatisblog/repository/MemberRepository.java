package whitekim.mybatisblog.repository;

import org.springframework.stereotype.Repository;
import whitekim.mybatisblog.dto.request.LoginMemberDto;
import whitekim.mybatisblog.model.Member;

import java.util.List;

@Repository
public interface MemberRepository {

    void save(Member member);
    Member findById(Long id);
    List<Member> findAll();
    void update(Member member);
    void deleteById(Long id);
    Member login(LoginMemberDto loginMemberDto);
}
