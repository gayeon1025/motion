package com.cnu.motion.respone;

import lombok.Builder;

import java.util.List;

@Builder
public class Response<T> {
    int numberOfTotalPages;
    List<T> results;
    boolean hasPreviousPage;
    boolean hasNextPage;
}
