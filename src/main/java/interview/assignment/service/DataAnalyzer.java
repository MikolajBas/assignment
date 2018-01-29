package interview.assignment.service;

import interview.assignment.domain.Statistic;
import interview.assignment.domain.StatisticDetails;
import interview.assignment.domain.XmlElement;

import java.time.LocalDateTime;

public class DataAnalyzer {

    private int total;

    private int totalAccepted;

    private LocalDateTime firstPost;

    private LocalDateTime lastPost;

    private Double scoreSum;

    public DataAnalyzer() {
        this.total = 0;
        this.totalAccepted = 0;
        this.firstPost = null;
        this.lastPost = null;
        this.scoreSum = 0.0;
    }

    public void analyzeNextElement(XmlElement element) {
        final LocalDateTime currentElementTime = element.getCreationDate();
        if(firstPost == null || currentElementTime.isBefore(firstPost)) {
            firstPost = currentElementTime;
        }
        if(lastPost == null || currentElementTime.isAfter(lastPost)){
            lastPost = currentElementTime;
        }
        scoreSum += element.getScore();
        if(element.getAcceptedAnswerId() != null) {
            totalAccepted++;
        }
        total++;
    }

    public Statistic finishAnalysis() {
        final double averageScore = scoreSum / (double)total;
        return new Statistic(LocalDateTime.now().toString(), new StatisticDetails(
                firstPost.toString(), lastPost.toString(), total, totalAccepted, averageScore));
    }


    public int getTotal() {
        return total;
    }

    public int getTotalAccepted() {
        return totalAccepted;
    }

    public LocalDateTime getFirstPost() {
        return firstPost;
    }

    public LocalDateTime getLastPost() {
        return lastPost;
    }

    public Double getScoreSum() {
        return scoreSum;
    }
}
