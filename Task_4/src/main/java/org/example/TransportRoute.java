package org.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class TransportRoute {
    public Integer number;
    public String startStop;
    public String endStop;
    public Integer stopCount;

    public TransportRoute() {}

    public TransportRoute(Integer number, String startStop, String endStop, Integer stopCount) {
        this.number = number;
        this.startStop = startStop;
        this.endStop = endStop;
        this.stopCount = stopCount;
    }

    @Override
    public boolean equals(Object obj) {
        return Checker.isEquals(obj, this);
    }
}
