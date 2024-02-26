package com.resturant.api;

import io.muserver.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resturant.model.Booking;

import java.text.SimpleDateFormat;

public class RestaurantApi {

    private static final List<Booking> bookings = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
    	 ObjectMapper objectMapper = new ObjectMapper();
        MuServer server = MuServerBuilder.httpServer()
                .addHandler(Method.POST, "/bookings", (request, response, pathParams) -> {
                //	System.out.println(request.readBodyAsString());
                    String json = request.readBodyAsString();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    // Ensure your dateTime format is compatible or configure ObjectMapper accordingly
                    Booking booking = objectMapper.readValue(json, Booking.class);
                    long duration = booking.getEndTime().getTime() - booking.getStartTime().getTime();
                    long hours = TimeUnit.MILLISECONDS.toHours(duration);
                    if (hours > 2 || (hours == 2 && TimeUnit.MILLISECONDS.toMinutes(duration) % 60 > 0)) {
                    	response.status(201);
                        response.write("Booking not created due to Booking duration cannot exceed two hours. ");
                        throw new IllegalArgumentException("Booking duration cannot exceed two hours.");
                    }
                    bookings.add(booking);
                    response.status(201);
                    response.write("Booking created");
                })
                .addHandler(Method.GET, "/bookings", (request, response, pathParams) -> {
                    String date = request.query().get("date");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    List<Booking> result = new ArrayList<>();
                    for (Booking booking : bookings) {
                        if (sdf.format(booking.getStartTime()).equals(date)) {
                            result.add(booking);
                        }
                    }
                    String jsonString = objectMapper.writeValueAsString(bookings);
                    response.status(200);
                    response.write(jsonString);
                   // response.writeJson(result);
                })
                .start();
        
        System.out.println("Server started at " + server.uri());
    }
}

