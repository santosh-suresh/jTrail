package com.jifflenow.jtrail.domain;

import java.util.Objects;

public class Calendar {

    private EmailInfo emailInfo;
    private EventInfo eventInfo;
    private String provider;
    private String uid;
    private String comment;
    private String attendee;
    private String status;

    public EmailInfo getEmailInfo() {
        return emailInfo;
    }

    public void setEmailInfo(EmailInfo emailInfo) {
        this.emailInfo = emailInfo;
    }

    public EventInfo getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(EventInfo eventInfo) {
        this.eventInfo = eventInfo;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttendee() {
        return attendee;
    }

    public void setAttendee(String attendee) {
        this.attendee = attendee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return Objects.equals(emailInfo, calendar.emailInfo) &&
                Objects.equals(eventInfo, calendar.eventInfo) &&
                Objects.equals(provider, calendar.provider) &&
                Objects.equals(uid, calendar.uid) &&
                Objects.equals(comment, calendar.comment) &&
                Objects.equals(attendee, calendar.attendee) &&
                Objects.equals(status, calendar.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailInfo, eventInfo, provider, uid, comment, attendee, status);
    }
}
