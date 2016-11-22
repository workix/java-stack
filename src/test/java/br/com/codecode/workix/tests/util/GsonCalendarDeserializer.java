package br.com.codecode.workix.tests.util;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Simple Calendar Deserializer for Gson
 * Register in GsonBuilder
 * Example: <code>new GsonBuilder()			
				.registerTypeAdapter(Calendar.class, new GsonCalendarDeserializer())			
				.create();</code>
 * @author felipe
 *
 */
public class GsonCalendarDeserializer implements JsonDeserializer<Calendar> {

	@Override
	public Calendar deserialize(JsonElement json, Type type,
			JsonDeserializationContext context)	throws JsonParseException {	

		if(json.isJsonObject()){

			int year = 	getInt("year", json);

			int month = getInt("month", json);

			int dayOfMonth = getInt("dayOfMonth", json);

			int hourOfDay = getInt("hourOfDay", json);

			int minute = getInt("minute", json);

			int second = getInt("second", json);

			Calendar c = Calendar.getInstance();

			c.set(year, month, dayOfMonth, hourOfDay, minute, second);

			return c;

		}else if (json.isJsonPrimitive()){

			String dateRaw = json.getAsString();

			Calendar c = Calendar.getInstance();

			Date d = new Date();

			try {
				
				d = DateFormat.getInstance().parse(dateRaw);
				
			} catch (ParseException e) {

				e.printStackTrace();
			}

			c.setTime(d);

			return c;

		}else
			throw new JsonParseException("Cannot Parse Json Object");

	}

	private int getInt(String name, JsonElement element) {

		return element.getAsJsonObject().get(name).getAsInt();

	} 

}
