package it;

import interview.assignment.domain.Statistic;
import interview.assignment.service.XmlParser;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.*;

import static org.junit.Assert.assertEquals;

public class XmlParserIT
{

    @Test
    public void shouldParseFile() throws FileNotFoundException, XMLStreamException {
        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource("some.xml").getFile());
        InputStream inputStream = new FileInputStream(file);

        XmlParser xmlParser = new XmlParser();
        Statistic statistic = xmlParser.parse(inputStream);
        assertEquals(Integer.valueOf(80), statistic.getAnalyzeDetails().getTotalPosts());
        assertEquals(Integer.valueOf(7), statistic.getAnalyzeDetails().getTotalAcceptedPosts());
        assertEquals(Double.valueOf(2.975), statistic.getAnalyzeDetails().getAverageScore());
        assertEquals("2015-09-14T12:46:52.053", statistic.getAnalyzeDetails().getLastPost());
        assertEquals("2015-07-14T18:39:27.757" , statistic.getAnalyzeDetails().getFirstPost());
    }
}
