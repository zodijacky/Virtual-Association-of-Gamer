package webservices;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import entities.User;	


public class httpClientInscription {

	User user = new User();

	public static String toJSON(User object) throws JSONException, IllegalAccessException {
		String str = "";
		Class c = object.getClass();
		JSONObject jsonObject = new JSONObject();
		for (Field field : c.getDeclaredFields()) {
			field.setAccessible(true);
			String name = field.getName();
			String value = String.valueOf(field.get(object));
			jsonObject.put(name, value);
		}
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
		// System.out.println(jsonObject.toString());
	}

	public void register(User u) throws JSONException, IllegalAccessException {
		try {
			URL url = new URL("http://localhost:7427/api/accounts/create");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			

			String input = toJSON(u);
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
