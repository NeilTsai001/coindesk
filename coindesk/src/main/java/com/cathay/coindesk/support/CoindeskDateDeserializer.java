package com.cathay.coindesk.support;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.cathay.coindesk.enums.TimeZoneEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CoindeskDateDeserializer extends JsonDeserializer<Date> {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss zzz", Locale.ENGLISH);

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        FORMATTER.setTimeZone(TimeZone.getTimeZone(TimeZoneEnum.UTC.getName()));
        String date = parser.getText();
        try {
            return FORMATTER.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
