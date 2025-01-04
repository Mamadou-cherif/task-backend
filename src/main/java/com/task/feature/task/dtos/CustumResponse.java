package com.task.feature.task.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class CustumResponse<T> {
    public int code;
    public String message;
    public T data;
}
