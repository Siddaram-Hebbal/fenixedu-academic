package net.sourceforge.fenixedu.presentationTier.Action.teacher.siteArchive.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.fenixedu.presentationTier.Action.teacher.siteArchive.Fetcher;
import net.sourceforge.fenixedu.presentationTier.Action.teacher.siteArchive.Resource;
import net.sourceforge.fenixedu.presentationTier.Action.teacher.siteArchive.rules.Rule;

/**
 * This output stream makes some parsing of the content written to it. The
 * objective is to capture all urls in the content and apply the rules of the
 * target resource. If a rule generates an extra resource then it will be queue
 * in the fetcher given in this stream's construction.
 * 
 * @author cfgi
 */
public class TransformUrlsStream extends OutputStream {

    private static Pattern PATTERN = Pattern.compile("(href|action|src)\\p{Space}*=\\p{Space}*(\"|')([^\"']*)(\"|')");

    private ByteArrayOutputStream buffer;

    private Fetcher fetcher;
    private Resource resource;

    private OutputStream stream;
    private String encoding;

    /**
     * @param fetcher
     *            the fetcher were all extra resources, generated by applyed
     *            rules, will be queued
     * @param resource
     *            the target resource and source of rules to apply to the
     *            content
     * @param stream
     *            the concrete stream were the final content will be written
     * @param encoding
     *            the encoding to use for the content
     */
    public TransformUrlsStream(Fetcher fetcher, Resource resource, OutputStream stream, String encoding) {
	this.buffer = new ByteArrayOutputStream();

	this.fetcher = fetcher;
	this.resource = resource;

	this.stream = stream;
	this.encoding = encoding;
    }

    @Override
    public void flush() throws IOException {
	processBuffer();
	this.stream.flush();
    }

    @Override
    public void close() throws IOException {
	flush();
	super.close();
    }

    @Override
    public void write(int b) throws IOException {
	this.buffer.write(b);

	char c = (char) b;
	if (c == '\n') {
	    processBuffer();
	}
    }

    private void processBuffer() throws IOException {
	String line = new String(buffer.toByteArray(), this.encoding);
	Matcher matcher = PATTERN.matcher(line);

	int pos = 0;
	while (matcher.find()) {
	    String attribute = matcher.group(1);

	    String foundUrl = matcher.group(3);
	    String transformedUrl = processRules(foundUrl);

	    write(String.format("%s%s=\"%s\"", line.substring(pos, matcher.start()), attribute, transformedUrl));

	    pos = matcher.end();
	}

	// write what is left and reset buffer
	write(line.substring(pos));
	buffer.reset();
    }

    private String processRules(String url) {
	String transformedUrl = url;

	for (Rule rule : this.resource.getRules()) {
	    if (rule.matches(url)) {
		transformedUrl = rule.transform(url);

		Resource resource = rule.getResource(url, transformedUrl);
		if (resource != null) {
		    this.fetcher.queue(resource);
		}

		break;
	    }
	}

	return transformedUrl;
    }

    private void write(String string) throws IOException {
	this.stream.write(string.getBytes());
    }

}