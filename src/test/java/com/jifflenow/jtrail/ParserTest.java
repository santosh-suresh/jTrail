package com.jifflenow.jtrail;


import com.jifflenow.jtrail.domain.Calendar;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParserTest {

    @Test
    public void emptyCalendarIsReturnedForEmptyContent() {
        Parser parser = new Parser(new HashMap<>());
        Calendar cal = parser.parse();
        assertThat(cal, is(Parser.EMPTY_CALENDAR));
    }

    @Test
    public void emptyCalendarIsReturnedForNullContent() {
        Parser parser = new Parser(null);
        Calendar cal = parser.parse();
        assertThat(cal, is(Parser.EMPTY_CALENDAR));
    }

    @Test
    public void emptyCalendarIsReturnedIfInvalidBase64UID() {
        Map<String,String> params = new HashMap<>();
        params.put("attachment", readCalendar("calendars/outlook_mac_accept_v2_invalid.ics"));
        params.put("to","Oracle Events <events+oracle+oow2013+3232+partner+23123123213@events.jifflenow.com>");
        params.put("from","Larry Elison, Oracle <larry.elison@oracle.com>");
        params.put("mode","uid");
        params.put("html","");
        Parser parser = new Parser(params);
        Calendar cal = parser.parse();
        assertThat(cal, is(Parser.EMPTY_CALENDAR));
    }

    private String readCalendar(String calendarName) {
        try {
            URL fileName = getClass().getClassLoader().getResource(calendarName);
            return new String(Files.readAllBytes(Paths.get(fileName.toURI())));
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
