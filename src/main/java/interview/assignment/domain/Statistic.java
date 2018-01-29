package interview.assignment.domain;


public class Statistic {

    private String analyzeDate;

    private StatisticDetails analyzeDetails;

    public Statistic(String analyzeDate, StatisticDetails analyzeDetails) {
        this.analyzeDate = analyzeDate;
        this.analyzeDetails = analyzeDetails;
    }

    public String getAnalyzeDate() {
        return analyzeDate;
    }

    public void setAnalyzeDate(String analyzeDate) {
        this.analyzeDate = analyzeDate;
    }

    public StatisticDetails getAnalyzeDetails() {
        return analyzeDetails;
    }

    public void setAnalyzeDetails(StatisticDetails analyzeDetails) {
        this.analyzeDetails = analyzeDetails;
    }

    public Statistic() {
    }
}
