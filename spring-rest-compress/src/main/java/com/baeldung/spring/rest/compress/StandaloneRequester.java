package com.baeldung.spring.rest.compress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class StandaloneRequester {

	private static final Logger LOG = LoggerFactory.getLogger(StandaloneRequester.class);

	//@Autowired
	private static RestTemplate restTemplate=new RestTemplate();

	// @LocalServerPort
	private static int randomServerPort=8080;

	/**
	 * As a further test you can intercept the request body, using a tool like
	 * Wireshark, to see the request body is actually gzipped.
	 *
	 * @throws Exception
	 */
	//@Test
	public static void main(String[] arg) throws Exception {

		final String text = "Hello Baeldung! Compress Compress Compress Compress Compress Compress Compress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"Compress Compress Compress Compress CompressCompress Compress " +
				"\"Compress Compress Compress Compress CompressCompress Compress ";
		Message message = new Message(text);

		HttpEntity<Message> request = new HttpEntity<>(message);
		LOG.info("request.getBody()-->"+request.getBody().getText());
		String uri = String.format("http://localhost:8085/process");
		restTemplate.getInterceptors().add(new CompressingClientHttpRequestInterceptor());
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, request, String.class);
		String response = responseEntity.getBody();
		LOG.info("Got response [{}]", response);


	}

}
