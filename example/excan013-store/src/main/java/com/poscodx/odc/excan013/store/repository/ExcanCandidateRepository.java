package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanCandidateJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface ExcanCandidateRepository
    extends JpaRepository<ExcanCandidateJpo, Integer>
{
    @Query(value = "SELECT c.ID \n" +
                    ",c.NAME \n" +
                    ",c.BIRTHDAY \n" +
                    ",c.EMAIL \n" +
                    ",c.PHONE \n" +
                    ",c.ADDRESS \n" +
                    ",c.AVATAR \n" +
                    ",c.DESCRIPTION \n" +
                    ",c.CREATE_AT \n" +
                    ",c.CREATE_BY \n" +
                    ",c.UPDATE_AT \n" +
                    ",c.UPDATE_BY \n" +
                    ",c.DELETE_AT \n" +
                    ",c.LINK_REFER \n" +
                    ",c.STATUS \n" +
                    ",c.INTERVIEW_DATE \n"+
                    ",IF(c.STATUS = 1 OR c.STATUS = 5 OR c.STATUS = 6,NULL,NVL(e.SCORE,0)) AS SCORE \n" +
                    ",e.TOTAL_SCORE as TOTAL_SCORE\n" +
                    ",u.NAME AS  UPDATE_USER_NAME \n" +
                    ",u.AVATAR AS  UPDATE_USER_AVATAR \n" +
                    ",c.POSITION \n" +
                    ",c.DEPARTMENT \n" +
                    ",c.UNIVERSITY \n" +
                    ",c.EXPERIENCE \n" +
                    ",c.YEAR_OF_EXPERIENCE \n" +
                    ",c.EXPECT_SALARY \n" +
                    ",c.EXPECT_START_DATE \n" +
                    ",c.INTERVIEWER \n" +
                    ",c.INTERVIEW_RESULT \n" +
                    ",c.LINK_CV \n" +
                    ",e.ID AS EXAM_ID \n" +
                    ",e.STATUS AS EXAM_STATUS \n" +
                    "FROM TB_EXCAN_CANDIDATE c \n" +
                    "LEFT JOIN TB_EXCAN_EXAM e ON c.ID = e.CANDIDATE_ID \n" +
                    "LEFT JOIN TB_EXCAN_USER u ON c.UPDATE_BY = u.ID \n" +
                    "WHERE 1 = 1 \n" +
                    "AND c.NAME LIKE CONCAT('%',:name,'%')\n" +
                    "AND (c.STATUS IN (:status) OR COALESCE(:status) IS NULL)  \n"+
                    "AND IF(:score=-1,-1,NVL(e.SCORE,0)) = IF(:score=-1,-1,:score) \n"+
                    "AND (DATE(c.INTERVIEW_DATE) >= DATE(:interviewDateFrom) OR IF(STRCMP(:interviewDateFrom,'') = 0,SYSDATE(),:interviewDateFrom) = SYSDATE()) \n"+
                    "AND (DATE(c.INTERVIEW_DATE) <= DATE(:interviewDateTo) OR IF(STRCMP(:interviewDateTo,'') = 0,SYSDATE(),:interviewDateTo) = SYSDATE()) \n"+
                    "AND c.EMAIL LIKE CONCAT('%',:email,'%')",nativeQuery = true)
    List<Tuple> findByCond(@Param("name") String name,
                           @Param("status") int[] status,
                           @Param("email") String email,
                           @Param("score") int score,
                           @Param("interviewDateFrom") String interviewDateFrom,
                           @Param("interviewDateTo") String interviewDateTo);

    @Query(value = "SELECT c.ID \n" +
            ",c.NAME \n" +
            ",c.BIRTHDAY \n" +
            ",c.EMAIL \n" +
            ",c.PHONE \n" +
            ",c.ADDRESS \n" +
            ",c.AVATAR \n" +
            ",c.DESCRIPTION \n" +
            ",c.CREATE_AT \n" +
            ",c.CREATE_BY \n" +
            ",c.UPDATE_AT \n" +
            ",c.UPDATE_BY \n" +
            ",c.DELETE_AT \n" +
            ",c.LINK_REFER \n" +
            ",c.STATUS \n" +
            ",c.INTERVIEW_DATE \n"+
            ",IF(c.STATUS = 1 OR c.STATUS = 5 OR c.STATUS = 6,NULL,NVL(e.SCORE,0)) AS SCORE \n" +
            ",e.TOTAL_SCORE as TOTAL_SCORE\n" +
            ",u.NAME AS  UPDATE_USER_NAME \n" +
            ",u.AVATAR AS  UPDATE_USER_AVATAR \n" +
            ",c.POSITION \n" +
            ",c.DEPARTMENT \n" +
            ",c.UNIVERSITY \n" +
            ",c.EXPERIENCE \n" +
            ",c.YEAR_OF_EXPERIENCE \n" +
            ",c.EXPECT_SALARY \n" +
            ",c.EXPECT_START_DATE \n" +
            ",c.INTERVIEWER \n" +
            ",c.INTERVIEW_RESULT \n" +
            ",c.LINK_CV \n" +
            ",e.ID AS EXAM_ID \n" +
            ",e.STATUS AS EXAM_STATUS \n" +
            "FROM TB_EXCAN_CANDIDATE c \n" +
            "LEFT JOIN TB_EXCAN_EXAM e ON c.ID = e.CANDIDATE_ID \n" +
            "LEFT JOIN TB_EXCAN_USER u ON c.UPDATE_BY = u.ID \n" +
            "WHERE 1 = 1 \n" +
            "AND c.DELETE_AT IS NULL \n" +
            "AND c.INTERVIEW_DATE IS NOT NULL \n" +
            "AND (c.STATUS = 6 OR c.STATUS = 5) \n" +
            "ORDER BY -e.STATUS DESC, c.STATUS DESC, c.INTERVIEW_DATE ASC, c.UPDATE_AT DESC\n" +
            "LIMIT 10 \n", nativeQuery = true)
    List<Tuple> getCanCheckingListForDashboard();

    @Query(value = "SELECT c.ID \n" +
            ",c.NAME \n" +
            ",c.BIRTHDAY \n" +
            ",c.EMAIL \n" +
            ",c.PHONE \n" +
            ",c.ADDRESS \n" +
            ",c.AVATAR \n" +
            ",c.DESCRIPTION \n" +
            ",c.CREATE_AT \n" +
            ",c.CREATE_BY \n" +
            ",c.UPDATE_AT \n" +
            ",c.UPDATE_BY \n" +
            ",c.DELETE_AT \n" +
            ",c.LINK_REFER \n" +
            ",c.STATUS \n" +
            ",c.INTERVIEW_DATE \n"+
            ",IF(c.STATUS = 1 OR c.STATUS = 5 OR c.STATUS = 6,NULL,NVL(e.SCORE,0)) AS SCORE \n" +
            ",e.TOTAL_SCORE as TOTAL_SCORE\n" +
            ",u.NAME AS  UPDATE_USER_NAME \n" +
            ",u.AVATAR AS  UPDATE_USER_AVATAR \n" +
            ",c.POSITION \n" +
            ",c.DEPARTMENT \n" +
            ",c.UNIVERSITY \n" +
            ",c.EXPERIENCE \n" +
            ",c.YEAR_OF_EXPERIENCE \n" +
            ",c.EXPECT_SALARY \n" +
            ",c.EXPECT_START_DATE \n" +
            ",c.INTERVIEWER \n" +
            ",c.INTERVIEW_RESULT \n" +
            ",c.LINK_CV \n" +
            ",e.ID AS EXAM_ID \n" +
            ",e.STATUS AS EXAM_STATUS \n" +
            "FROM TB_EXCAN_CANDIDATE c \n" +
            "LEFT JOIN TB_EXCAN_EXAM e ON c.ID = e.CANDIDATE_ID \n" +
            "LEFT JOIN TB_EXCAN_USER u ON c.UPDATE_BY = u.ID \n" +
            "WHERE 1 = 1 \n" +
            "AND c.DELETE_AT IS NULL \n" +
            "AND c.INTERVIEW_DATE IS NOT NULL \n" +
            "AND (c.STATUS = 2 OR c.STATUS = 3 OR c.STATUS = 4) \n" +
            "ORDER BY c.UPDATE_AT DESC\n" +
            "LIMIT 10 \n", nativeQuery = true)
    List<Tuple> getCanResultListForDashboard();
}
