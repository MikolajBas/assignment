package interview.assignment.unit;

import interview.assignment.domain.XmlElement;
import interview.assignment.service.DataAnalyzer;
import interview.assignment.service.XmlElementParser;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
public class XmlParserTest {

    @Ignore //PowerMockito problems
    @Test
    public void shouldParseDocument() throws Exception {
        XMLInputFactory xmlInputFactory = Mockito.mock(XMLInputFactory.class);
        DataAnalyzer dataAnalyzer = Mockito.mock(DataAnalyzer.class);
        XMLEventReader xmlEventReader = Mockito.mock(XMLEventReader.class);
        XMLEvent xmlEvent = Mockito.mock(XMLEvent.class);
        mockStatic(XmlElementParser.class);
        PowerMockito.whenNew(XMLInputFactory.class)
                .withAnyArguments().thenReturn(xmlInputFactory);
        PowerMockito.whenNew(DataAnalyzer.class)
                .withAnyArguments().thenReturn(dataAnalyzer);
        when(xmlEventReader.hasNext()).thenReturn(true).thenReturn(false);
        when(xmlEventReader.nextEvent()).thenReturn(xmlEvent);
        Optional<XmlElement> xmlElement = Optional.of(
                new XmlElement(LocalDateTime.of(2016, 1, 1, 12, 33, 11, 122), 1, 2.0));
        when(XmlElementParser.parse(any())).thenReturn(xmlElement);

        verify(dataAnalyzer, times(1)).analyzeNextElement(xmlElement.get());
        verify(dataAnalyzer).finishAnalysis();
    }
}
