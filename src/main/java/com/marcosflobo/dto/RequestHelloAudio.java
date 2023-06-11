package com.marcosflobo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Generated
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonInclude(Include.NON_NULL)
public class RequestHelloAudio {
    
    private String url;
    public RequestHelloAudio(){}

    @JsonCreator
    public RequestHelloAudio(@JsonProperty(required = true, value = "url") String url) {

        this.url = url;
    }
}
