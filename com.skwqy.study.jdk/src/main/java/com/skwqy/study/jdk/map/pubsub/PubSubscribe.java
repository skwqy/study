package com.skwqy.study.jdk.map.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 缓存，全程无锁
 *
 * @author skwqy
 * @Created on 2019 01 2019-01-27 18:46
 */
public class PubSubscribe {
    private static final Logger LOG = LoggerFactory.getLogger(PubSubscribe.class);
    private static final PubSubscribe INSTANCE = new PubSubscribe();
    private final ConcurrentMap<String, List<IEventListener>> eventCache = new ConcurrentHashMap<>();

    private PubSubscribe(){}

    public PubSubscribe getInstance(){
        return INSTANCE;
    }

    public void addListener(String eventId, IEventListener listener){
        List<IEventListener> listeners = eventCache.computeIfAbsent(eventId,k-> new CopyOnWriteArrayList<>());
        listeners.add(listener);
    }

    public void publisher(Event event){
        List<IEventListener> listeners = eventCache.get(event.getEventId());
        for(IEventListener listener : listeners){
            listener.publish(event);
        }
    }

}
