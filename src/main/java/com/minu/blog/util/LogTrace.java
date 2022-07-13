package com.minu.blog.util;

public interface LogTrace{
    TraceStatus begin( String message );

    void end( TraceStatus status );

    void exception( TraceStatus status , Exception e );
}
