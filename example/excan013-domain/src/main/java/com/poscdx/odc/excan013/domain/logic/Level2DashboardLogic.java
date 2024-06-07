package com.poscdx.odc.excan013.domain.logic;

import com.google.gson.JsonObject;
import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import com.poscdx.odc.excan013.domain.spec.ExcanCandidateService;
import com.poscdx.odc.excan013.domain.spec.ExcanExamService;
import com.poscdx.odc.excan013.domain.spec.Level2DashboardService;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class Level2DashboardLogic implements Level2DashboardService {

    private final ExcanCandidateService candidateService;
    private final ExcanExamService examService;


    @Override
    public String getCandidateStats() {
        JsonObject response = new JsonObject();
        List<ExcanCandidate> listAllCandidates = candidateService.findAll();

        //Add total candidates
        response.addProperty("totalCandidates", listAllCandidates.size());

        int totalNewCandidatesCurrentMonth = 0;
        int totalNewCandidatesToday = 0;
        //Add new candidates in this month
        for (ExcanCandidate exc : listAllCandidates) {

            Calendar interviewDate = Calendar.getInstance();
            Calendar today = Calendar.getInstance();

            //Set the given date in one of the instance and current date in the other

            if (exc.getInterviewDate() == null) continue;
            interviewDate.setTime(exc.getInterviewDate());
            today.setTime(new Date());

            //Now compare the dates using methods on Calendar
            if (interviewDate.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
                if (interviewDate.get(Calendar.MONTH) == today.get(Calendar.MONTH)) {
                    // the date falls in current month
                    totalNewCandidatesCurrentMonth += 1;
                    if (interviewDate.get(Calendar.DATE) == today.get(Calendar.DATE)) {
                        totalNewCandidatesToday += 1;
                    }
                }
            }

        }
        response.addProperty("totalNewCandidatesCurrentMonth", totalNewCandidatesCurrentMonth);
        response.addProperty("totalNewCandidatesToday", totalNewCandidatesToday);
        return response.toString();
    }


    @Override
    public String getExamStats() {
        List<ExcanExam> listAllExams = examService.findAll();

        double totalScore = 0.0;
        int totalExamFinished = 0;
        long totalMinutesDiff = 0;
        double highestScore = 0.0;
        for (ExcanExam exe : listAllExams) {

            //Calculate average score
            if (exe.getStatus() == 3) { //TODO switch to num 3 and define enum and use it
                totalScore += exe.getScore();
                totalExamFinished += 1;


                //Calculate average time spent
                //Create 2 instances of Calendar
                Calendar startTime = Calendar.getInstance();
                Calendar submitTime = Calendar.getInstance();

                //Set the given date in one of the instance and current date in the other
                if (exe.getStartTime() != null) startTime.setTime(exe.getStartTime());
                else continue;
                if (exe.getSubmitTime() != null) submitTime.setTime(exe.getSubmitTime());
                else continue;

                //Now calculate the time diff between 2 date
                totalMinutesDiff += Duration.between(startTime.toInstant(), submitTime.toInstant()).toMinutes();

                if (exe.getScore() > highestScore) highestScore = exe.getScore();
            }

        }
        double averageScore = (totalExamFinished > 0) ? totalScore / totalExamFinished : 0;
        double averageTimeSpent = (totalExamFinished > 0) ? (double) (totalMinutesDiff / totalExamFinished) : 0.0;
        JsonObject response = new JsonObject();
        response.addProperty("averageScore", averageScore);
        response.addProperty("averageTimeSpent", averageTimeSpent);
        response.addProperty("highestScore", highestScore);

        return response.toString();
    }


    @Override
    public String getResultsStats() {
        JsonObject response = new JsonObject();
        List<ExcanCandidate> listAllCandidates = candidateService.findAll();
        int totalPassedCandidates = 0, totalPendingCandidates = 0, totalRejectedCandidates = 0;
        for (ExcanCandidate exc : listAllCandidates) {
            switch (exc.getStatus()) {
                case 2: //TODO switch to num 2 and define enum and use it
                    totalPassedCandidates += 1;
                    break;
                case 3: //TODO switch to num 3 and define enum and use it
                    totalPendingCandidates += 1;
                    break;
                case 4: //TODO switch to num 4 and define enum and use it
                    totalRejectedCandidates += 1;
                    break;
            }
        }
        response.addProperty("totalPassedCandidates", totalPassedCandidates);
        response.addProperty("totalPendingCandidates", totalPendingCandidates);
        response.addProperty("totalRejectedCandidates", totalRejectedCandidates);
        return response.toString();
    }

    /**
     * @return
     */
    @Override
    public List<ExcanCandidate> getCanCheckingList() {
        return candidateService.getCanCheckingListForDashboard();
    }

    /**
     * @return
     */
    @Override
    public List<ExcanCandidate> getCanResultList() {
        return candidateService.getCanResultListForDashboard();
    }


}
