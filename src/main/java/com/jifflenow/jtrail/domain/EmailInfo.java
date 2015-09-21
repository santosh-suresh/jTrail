package com.jifflenow.jtrail.domain;

import java.util.Objects;

public class EmailInfo {

    private String rawFromEmail;
    private String rawToEmail;
    private String fromEmail;
    private String toEmail;

    public EmailInfo(String rawFromEmail, String rawToEmail, String fromEmail, String toEmail) {
        this.rawFromEmail = rawFromEmail;
        this.rawToEmail = rawToEmail;
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
    }

    public String getRawFromEmail() {
        return rawFromEmail;
    }

    public String getRawToEmail() {
        return rawToEmail;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailInfo emailInfo = (EmailInfo) o;
        return Objects.equals(rawFromEmail, emailInfo.rawFromEmail) &&
                Objects.equals(rawToEmail, emailInfo.rawToEmail) &&
                Objects.equals(fromEmail, emailInfo.fromEmail) &&
                Objects.equals(toEmail, emailInfo.toEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawFromEmail, rawToEmail, fromEmail, toEmail);
    }
}
