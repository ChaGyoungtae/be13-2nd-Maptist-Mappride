package com.maptist.mappride.mappride.grade;

import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GradeService {

    private final MemberRepository memberRepository;
    private final GradeRepository gradeRepository;


    public void setGrade() {

        List<Member> memberList = memberRepository.findAll();
        List<Grade> gradeList = gradeRepository.findAll();
        for(Member m : memberList){
            int scrapCnt = m.getScrapCnt();
            Grade newGrade = null;
           for(Grade g : gradeList){
               if(scrapCnt >= g.getReviewCnt()){
                   newGrade = g;
               } else{
                   break;
               }
           }
           if(newGrade != null) m.updateGrade(newGrade);
        }
    }

    public Long save(Grade grade){
        return gradeRepository.create(grade);
    }
}
