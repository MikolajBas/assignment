package interview.assignment.unit;

import interview.assignment.domain.Statistic;
import interview.assignment.domain.XmlElement;
import interview.assignment.service.DataAnalyzer;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataAnalyzerTest {

    @Test
    public void shouldUpdateStateAfterAnalyzingNextElement() {
        DataAnalyzer dataAnalyzer = new DataAnalyzer();

        dataAnalyzer.analyzeNextElement(mockElements().get(0));
        checkAnalyzerState(dataAnalyzer, mockElements().get(0).getCreationDate(),
                mockElements().get(0).getCreationDate(), 4.0, 1, 1);

        dataAnalyzer.analyzeNextElement(mockElements().get(1));
        checkAnalyzerState(dataAnalyzer, mockElements().get(0).getCreationDate(),
                mockElements().get(1).getCreationDate(), 7.0, 2, 1);
    }

    @Test
    public void shouldFinishAnalysisProperly() {
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        mockElements().forEach(el -> dataAnalyzer.analyzeNextElement(el));
        Statistic result = dataAnalyzer.finishAnalysis();

        assertEquals(mockElements().get(0).getCreationDate().toString(), result.getAnalyzeDetails().getFirstPost());
        assertEquals(mockElements().get(1).getCreationDate().toString(), result.getAnalyzeDetails().getLastPost());
        assertEquals(Double.valueOf(3.5), result.getAnalyzeDetails().getAverageScore());
        assertEquals(Integer.valueOf(2), result.getAnalyzeDetails().getTotalPosts());
        assertEquals(Integer.valueOf(1), result.getAnalyzeDetails().getTotalAcceptedPosts());    }

    private void checkAnalyzerState(DataAnalyzer dataAnalyzer, LocalDateTime firstPost,
                                    LocalDateTime lastPost, Double score, int total, int totalAccepted) {
        assertEquals(firstPost, dataAnalyzer.getFirstPost());
        assertEquals(lastPost, dataAnalyzer.getLastPost());
        assertEquals(score, dataAnalyzer.getScoreSum());
        assertEquals(total, dataAnalyzer.getTotal());
        assertEquals(totalAccepted, dataAnalyzer.getTotalAccepted());
    }


    private List<XmlElement> mockElements() {
        return new ArrayList<>(Arrays.asList(
                new XmlElement(LocalDateTime.of(2017, 1, 22, 12, 33), 11, 4.0),
                new XmlElement(LocalDateTime.of(2017, 5, 22, 11, 33), null, 3.0)
            ));
    }
}
