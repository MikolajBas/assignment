package interview.assignment.service;

import interview.assignment.domain.XmlElement;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;
import java.time.LocalDateTime;
import java.util.Optional;

public class XmlElementParser {


    public static Optional<XmlElement> parse(XMLEvent event) {
        if(event.getEventType() == XMLStreamConstants.START_ELEMENT) {
            XmlElement element = new XmlElement();
            event.asStartElement().getAttributes().forEachRemaining(
                    atr -> parseAttribute(element, (Attribute) atr));
            return Optional.of(element);
        }
        return Optional.empty();
    }


    private static void parseAttribute (XmlElement element, Attribute attribute) {
        final String attributeValue = attribute.getValue();
        final String attributeName = attribute.getName().toString();
        if(AttributeName.ACCEPTED_ANSWER_ID.getValue().equals(attributeName)) {
            element.setAcceptedAnswerId(Integer.valueOf(attributeValue));
        } else if (AttributeName.CREATION_DATE.getValue().equals(attributeName)) {
            element.setCreationDate(LocalDateTime.parse(attributeValue));
        } else if(AttributeName.SCORE.getValue().equals(attributeName)) {
            element.setScore(Double.valueOf(attributeValue));
        }
    }

}

