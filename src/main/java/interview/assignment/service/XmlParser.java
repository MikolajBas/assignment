package interview.assignment.service;

import interview.assignment.domain.Statistic;
import interview.assignment.domain.XmlElement;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.Optional;

public class XmlParser {

    private XMLInputFactory xmlInputFactory;
    private DataAnalyzer dataAnalyzer;

    public XmlParser() {
        xmlInputFactory = XMLInputFactory.newFactory();
        dataAnalyzer = new DataAnalyzer();
    }

    public Statistic parse(InputStream inputStream) throws XMLStreamException {
        final XMLEventReader reader = xmlInputFactory.createXMLEventReader(inputStream);
        reader.nextTag(); //skip first element
        while(reader.hasNext()) {
            final XMLEvent event = reader.nextEvent();
            final Optional<XmlElement> element = XmlElementParser.parse(event);
            if(element.isPresent()) {
                dataAnalyzer.analyzeNextElement(element.get());
            }
        }
        return dataAnalyzer.finishAnalysis();
    }

}
