package interview.assignment.controller;


import interview.assignment.domain.AnalyzerParameters;
import interview.assignment.service.DataFetcher;
import interview.assignment.service.XmlParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

@RestController
public class AnalyzeXmlController {

    public static final String XML_NOT_VALID = "Parsed document is not valid xml document";
    public static final String CONNECTION_ERROR = "Connection error";
    public static final String INVALID_URL = "Url is invalid";

    @RequestMapping(method = RequestMethod.POST, value = "/analyze")
    @ResponseBody
    public ResponseEntity analyze(@RequestBody AnalyzerParameters analyzerParameters) {

        try {
            final InputStream stream = DataFetcher.fetch(analyzerParameters);
            XmlParser xmlParser = new XmlParser();
            return new ResponseEntity(xmlParser.parse(stream), HttpStatus.OK);
        } catch (MalformedURLException e) {
            return new ResponseEntity(INVALID_URL,  HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            return new ResponseEntity(CONNECTION_ERROR,  HttpStatus.BAD_REQUEST);
        } catch (XMLStreamException e) {
            return new ResponseEntity(XML_NOT_VALID,  HttpStatus.BAD_REQUEST);
        }
    }

}
