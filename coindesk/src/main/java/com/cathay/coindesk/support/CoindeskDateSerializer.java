package com.cathay.coindesk.support;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.cathay.coindesk.enums.TimeZoneEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CoindeskDateSerializer extends JsonSerializer<Date> {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss zzz", Locale.ENGLISH);

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (date == null) {
            gen.writeNull();
        } else {
            FORMATTER.setTimeZone(TimeZone.getTimeZone(TimeZoneEnum.UTC.getName()));
            gen.writeString(FORMATTER.format(date.getTime()));
        }
    }
}
