package com.jifflenow.jtrail;

import com.jifflenow.jtrail.domain.Calendar;
import com.jifflenow.jtrail.domain.EmailInfo;
import com.jifflenow.jtrail.domain.EventInfo;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static final Calendar EMPTY_CALENDAR = new Calendar();
    private static final Pattern VEVENT_MATCHER = Pattern.compile("(BEGIN:VEVENT(.*\\n)*?END:VEVENT\\r?\\n)");
    private static final Pattern UID_MATCHER = Pattern.compile("UID:(.*?\\n(\\s.*?\\n)*)");
//    private static final Pattern VEVENT_MATCHER = Pattern.compile("(BEGIN:VEVENT)");


    private final String rawContent;
    private Map<String, String> params;
    private String explodedIcal;
    private Calendar parsedCalendar = new Calendar();

    public Parser(Map<String,String> params) {
        this.params = params;
        if(this.params == null)
            this.params = new HashMap<>();
        this.rawContent = this.params.getOrDefault("attachment","");
    }

    public Calendar parse() {
        if(rawContent == null || rawContent.isEmpty())
            return EMPTY_CALENDAR;
        this.explodedIcal = explodeIcal();
        EventInfo info = parseUID();
        if(info == null)
            return EMPTY_CALENDAR;

        parsedCalendar.setEventInfo(info);
        return null;
    }

    private EventInfo parseUID() {
        String uid = findElementByPattern(UID_MATCHER, this.explodedIcal);
        if(uid != null) {
            try {
                String entities = new String(Base64.getDecoder().decode(uid));
                return new EventInfo(entities);
            }catch(IllegalArgumentException iae) {
                return null;
            }
        }
        return null;
    }

    private String findElementByPattern(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);
        if(matcher.find() && matcher.groupCount() > 1) {
            return matcher.group(1).replaceAll("\\n","").replaceAll("\\r","");
        }
        return null;
    }


    private String explodeIcal() {
        Matcher matcher = VEVENT_MATCHER.matcher(rawContent);
        if(matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
