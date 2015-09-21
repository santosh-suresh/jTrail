package com.jifflenow.jtrail.domain;

import java.util.Objects;

public class EventInfo {

    private String company;
    private String event;
    private String meetingId;
    private String userType;
    private String uuid;

    public EventInfo(String company, String event, String meetingId, String userType, String uuid) {
        this.company = company;
        this.event = event;
        this.meetingId = meetingId;
        this.userType = userType;
        this.uuid = uuid;
    }

    public EventInfo(String encodedEntities) {
        String[] entities = encodedEntities.split("\\+");
        if(entities.length != 5)
            throw new IllegalArgumentException("Invalid number of entities in email uid " + encodedEntities);
        if(entities[3].equals(""))
            userType = "user";
        company = entities[0];
        event = entities[1];
        meetingId = entities[2];
        uuid = entities[4];
    }

    public String getCompany() {
        return company;
    }

    public String getEvent() {
        return event;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public String getUserType() {
        return userType;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventInfo eventInfo = (EventInfo) o;
        return Objects.equals(company, eventInfo.company) &&
                Objects.equals(event, eventInfo.event) &&
                Objects.equals(meetingId, eventInfo.meetingId) &&
                Objects.equals(userType, eventInfo.userType) &&
                Objects.equals(uuid, eventInfo.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, event, meetingId, userType, uuid);
    }
}
