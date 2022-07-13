package com.minu.blog.util;

public class TraceStatus{

    private TraceId traceId;
    private Long StartTimeMs;
    private String message;

    private String msg;

    public TraceStatus( TraceId traceId , Long startTimeMs , String message ){
        this.traceId = traceId;
        StartTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId(){
        return traceId;
    }

    public Long getStartTimeMs(){
        return null;
    }

    public String getMessage(){
        return message;
    }

}
