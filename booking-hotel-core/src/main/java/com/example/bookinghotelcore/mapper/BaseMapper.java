package com.example.bookinghotelcore.mapper;

public interface BaseMapper <Entity, Request, Response>{

    Entity toEntity(Request request);

    Response toResponse(Entity entity);

}
