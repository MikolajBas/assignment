package interview.assignment.service;

import interview.assignment.domain.AnalyzerParameters;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataFetcher {

    public static InputStream fetch(AnalyzerParameters analyzerParameters) throws IOException {
        final URL url = new URL(analyzerParameters.getUrl());
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection.getInputStream();
    }
}
