package com.panamax.elasticUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class LogMatrics {

	private static Logger logger = Logger.getLogger(LogMatrics.class.getName());

	private String indexName;
	private String indexType;
	private int waitSeconds = 0;

	public LogMatrics() {

	}

	public LogMatrics(int waitSeconds) {
		this.waitSeconds = waitSeconds;
	}

	private String elastiUrl = "http://10.10.180.82:9200/apiexecution/matrics";

	public LogMatrics(String indexName, String indexType) {
		this.indexName = indexName;
		this.indexType = indexType;
	}

	public void logToElasticsearch(Map<String, Object> elasticData) {
		try {
			if (elasticData != null && elasticData.size() > 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
				sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

				elasticData.put("timeStamp", sdf.format(new Date()));

				Gson gson = new Gson();
				ObjectMapper objectMapper = new ObjectMapper();
				String json = objectMapper.writeValueAsString(elasticData);
				Client client = ClientBuilder.newClient();
				WebTarget webTarget = null;
				if (this.indexName != null && this.indexType != null) {
					webTarget = client.target("http://192.168.33.214:9200/" + this.indexName + "/" + this.indexType);
				} else {
					webTarget = client.target(elastiUrl);
				}

				DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
				LocalDateTime currentDate = LocalDateTime.now();
				String date = dateformatter.format(currentDate);
				elasticData.put("Task Name", elasticData.get("Task Name") + date);

//				String temp = gson.toJson(elasticData);
				Response response = webTarget.request().post(Entity.entity(json, MediaType.APPLICATION_JSON),
						Response.class);
				logger.info("Response: " + response.toString());
			}
		} catch (

		Exception ex) {
			logger.log(Level.WARNING, "Exception in logToElasticsearch method", ex);
			ex.printStackTrace();
		}
	}

	public static void main(String[] args)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		LogMatrics logMatrics = new LogMatrics("apiautomation", "docs");
		long uniqueID = System.nanoTime();
		String requestUniqueID = String.valueOf(uniqueID);
		String json_string1 = "{\"MethodName1\":\"GetBalance\",\"RequestUniqueID1\":\"" + requestUniqueID
				+ "\",\"RequestIP1\":\"192.168.33.70\",\"ActivationCode1\":\"16854947957\"}";
		String json_string2 = "{\"MethodName\":\"GetBalance\",\"RequestUniqueID\":\"" + requestUniqueID
				+ "\",\"RequestIP\":\"192.168.33.214\",\"ActivationCode\":\"1679947957\"}";

		// for (int i = 0; i < 30; i++) {
		// String res =
		// "{\"ResponseCode\":\"000\",\"RequestDateTime\":\"2020-01-21
		// 10:05:13\",\"AccessID\":\"1243811\",\"Commission\":\"0.00\",\"CommissionTax\":\"0\",\"ResponseDescription\":\"Txn
		// Successful\",\"TransactionInfo\":\"{\"transactionId\":\"2020-01-21\",\"operatorCode\":\"100521\"}\",\"TransactionFee\":\"0.00\",\"Balance\":\"967.000000\",\"RequestUniqueID\":\"85237292223300\",\"TransactionID\":\"101122\"}";

		// HashMap<String, Object> reqMap = new Gson().fromJson(json_string, new
		// TypeToken<HashMap<String, Object>>() {
		// }.getType());
		//
		// HashMap<String, Object> resMap = new Gson().fromJson(res, new
		// TypeToken<HashMap<String, Object>>() {
		// }.getType());
		//
		// reqMap.putAll(resMap);

		ObjectMapper mapper = new ObjectMapper();

		// HashMap<String, Object> map = new Gson().fromJson(json_string, new
		// TypeToken<HashMap<String, Object>>() {
		// }.getType());

		HashMap<String, String> map = mapper.readValue(json_string1, HashMap.class);
		HashMap<String, String> map1 = (HashMap<String, String>) map.clone();
		// map1.put(key, value)
		// logMatrics.logToElasticsearch(map);
		Thread.sleep(4000);
		// }
	}

}