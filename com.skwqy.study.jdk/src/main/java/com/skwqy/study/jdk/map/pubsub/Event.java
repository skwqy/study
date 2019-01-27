package com.skwqy.study.jdk.map.pubsub;

/**
 * @author skwqy
 * @Created on 2019 01 2019-01-27 18:51
 */
public class Event {
    private String eventId;
    public Event(String eventId){
        this.eventId = eventId;
    }

    public String getEventId(){
        return this.eventId;
    }
}
