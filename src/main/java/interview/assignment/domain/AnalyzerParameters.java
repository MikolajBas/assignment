package interview.assignment.domain;

public class AnalyzerParameters {

    private String url;

    public AnalyzerParameters(String url) {
        this.url = url;
    }

    public AnalyzerParameters(){}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
