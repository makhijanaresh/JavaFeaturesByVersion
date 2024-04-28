package com.java11.features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Java11HttpClient {

	public static void main(String[] args)
			throws IOException, InterruptedException, ExecutionException, TimeoutException {
		syncExamples();
		//asyncExamples();
	}

	private static void asyncExamples() throws InterruptedException, ExecutionException, TimeoutException {

		HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(10)).build();
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://httpbin.org/get"))
				.setHeader("User-Agent", "Java11 features").build();

		CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request,
				HttpResponse.BodyHandlers.ofString());

		String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

		System.out.println(result);

	}

	private static void syncExamples() throws IOException, InterruptedException {
		// syncClientGETExample();
		syncClientPostExample();
	}

	private static void syncClientPostExample() throws IOException, InterruptedException {
		final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(10)).build();

		StringBuilder stringBuilder = new StringBuilder();

		// Append key-value pairs to the StringBuilder
		stringBuilder.append("key1:value1\n");
		stringBuilder.append("key2:value2\n");
		stringBuilder.append("key3:value3");

		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString(stringBuilder.toString()))
				.uri(URI.create("https://httpbin.org/post")).setHeader("User-Agent", "Java 11 HttpClient Bot") // add
																												// request
																												// header
				.header("Content-Type", "application/x-www-form-urlencoded").build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// print status code
		System.out.println(response.statusCode());

	}

	private static void syncClientGETExample() {
		HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(10)).build();
		try {
			HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://www.google.com")).build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println("Status code: " + response.statusCode());
			System.err.println("Headers: " + response.headers().allValues("content-type"));
			// System.out.println("Body: " + response.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
