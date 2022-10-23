package com.cathay.coindesk.model.coindeskApi;

import java.util.Date;

import com.cathay.coindesk.support.CoindeskDateDeserializer;
import com.cathay.coindesk.support.CoindeskDateDeserializerISO;
import com.cathay.coindesk.support.CoindeskDateDeserializerUK;
import com.cathay.coindesk.support.CoindeskDateSerializer;
import com.cathay.coindesk.support.CoindeskDateSerializerISO;
import com.cathay.coindesk.support.CoindeskDateSerializerUK;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Time {

	@JsonSerialize(using = CoindeskDateSerializer.class)
    @JsonDeserialize(using = CoindeskDateDeserializer.class)
    @JsonProperty(value = "updated")
    private Date updated;

    @JsonSerialize(using = CoindeskDateSerializerISO.class)
    @JsonDeserialize(using = CoindeskDateDeserializerISO.class)
    @JsonProperty(value = "updatedISO")
    private Date updatedISO;

    @JsonSerialize(using = CoindeskDateSerializerUK.class)
    @JsonDeserialize(using = CoindeskDateDeserializerUK.class)
    @JsonProperty(value = "updateduk")
    private Date updatedUK;

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getUpdatedISO() {
        return updatedISO;
    }

    public void setUpdatedISO(Date updatedISO) {
        this.updatedISO = updatedISO;
    }

    public Date getUpdatedUK() {
        return updatedUK;
    }

    public void setUpdatedUK(Date updatedUK) {
        this.updatedUK = updatedUK;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Time [updated=");
        builder.append(updated);
        builder.append(", updatedISO=");
        builder.append(updatedISO);
        builder.append(", updatedUK=");
        builder.append(updatedUK);
        builder.append("]");
        return builder.toString();
    }

}
