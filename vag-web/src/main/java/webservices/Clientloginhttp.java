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

import Beans.UserBean;
import entities.User;



public class Clientloginhttp {

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
		
		return jsonObject.toString();
		
	}

	public String login(User u) throws JSONException, IllegalAccessException {
		try {
UserBean au= new UserBean();
			String output;
			URL url = new URL("http://localhost:7427/api/accounts/login");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
		
			String input = toJSON(u);
			// JSONObject json = (JSONObject) new JsonParser().parse(input);
			// System.out.println(input+conn);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
            
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				
			 return "false";
			
	}else
	{

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println("okok"+output);
				System.out.println("eeeeee");
				
			
				return output;
			}
	}
		
		
	
		
			conn.disconnect();
		
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return "error";
		

	}

}
