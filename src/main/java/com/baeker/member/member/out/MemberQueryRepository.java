package com.baeker.member.member.out;

import com.baeker.member.member.domain.entity.Member;
import com.baeker.member.member.domain.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory query;

    public MemberQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    //-- 백준 연동한 모든 회원 조회 --//
    public List<Member> findAllConBJ() {
        QMember member = QMember.member;

        return query
                .selectFrom(member)
                .where(member.baekJoonName.isNotNull())
                .fetch();
    }
}
