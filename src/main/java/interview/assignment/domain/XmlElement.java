package interview.assignment.domain;

import java.time.LocalDateTime;

public class XmlElement {
    private LocalDateTime creationDate;
    private Integer acceptedAnswerId;
    private Double score;

    public XmlElement(LocalDateTime creationDate, Integer acceptedAnswerId, Double score) {
        this.creationDate = creationDate;
        this.acceptedAnswerId = acceptedAnswerId;
        this.score = score;
    }

    public XmlElement() {}

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public Double getScore() {
        return score;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
