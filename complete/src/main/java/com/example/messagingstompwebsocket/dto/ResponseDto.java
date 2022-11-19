package com.example.messagingstompwebsocket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto {

    private String result;
    private Object data;

}
