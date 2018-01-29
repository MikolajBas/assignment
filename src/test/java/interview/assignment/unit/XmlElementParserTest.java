package interview.assignment.unit;

import interview.assignment.domain.XmlElement;
import interview.assignment.service.XmlElementParser;
import org.junit.Test;
import org.mockito.Mockito;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class XmlElementParserTest {

    @Test
    public void shouldParseElement() {
        XMLEvent xmlEvent = Mockito.mock(XMLEvent.class);
        StartElement startElement = Mockito.mock(StartElement.class);
        Attribute dateAttribute = Mockito.mock(Attribute.class);
        Attribute scoreAttribute = Mockito.mock(Attribute.class);
        Attribute acceptedAttribute = Mockito.mock(Attribute.class);
        when(dateAttribute.getName()).thenReturn(QName.valueOf("CreationDate"));
        when(dateAttribute.getValue()).thenReturn("2017-11-11T12:31:11.765");
        when(scoreAttribute.getName()).thenReturn(QName.valueOf("Score"));
        when(scoreAttribute.getValue()).thenReturn("4.5");
        when(acceptedAttribute.getName()).thenReturn(QName.valueOf("AcceptedAnswerId"));
        when(acceptedAttribute.getValue()).thenReturn("22");
        when(startElement.getAttributes()).thenReturn(Arrays.asList(dateAttribute, acceptedAttribute, scoreAttribute).iterator());
        when(xmlEvent.getEventType()).thenReturn(XMLStreamConstants.START_ELEMENT);
        when(xmlEvent.asStartElement()).thenReturn(startElement);

        Optional<XmlElement> parse = XmlElementParser.parse(xmlEvent);

        assertTrue(parse.isPresent());
        assertEquals(parse.get().getCreationDate(), LocalDateTime.parse("2017-11-11T12:31:11.765"));
        assertEquals(parse.get().getScore(), Double.valueOf(4.5));
        assertEquals(parse.get().getAcceptedAnswerId(), Integer.valueOf(22));
    }
}
