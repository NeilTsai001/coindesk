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

public class CoindeskDateSerializerUK extends JsonSerializer<Date> {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("MMM dd, yyyy 'at' HH:mm zzz", Locale.ENGLISH);

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
        } else {
            FORMATTER.setTimeZone(TimeZone.getTimeZone(TimeZoneEnum.BST.getName()));
            gen.writeString(FORMATTER.format(value.getTime()));
        }
    }
}
