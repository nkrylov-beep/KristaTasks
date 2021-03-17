package org.example;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Transport {
    public Integer number;
    public String type;
    public List<Driver> driverList = new ArrayList<>();
    public TransportRoute transportRoute;

    public Transport() {}

    public Transport(Integer number, String type, TransportRoute transportRoute) {
        this.number = number;
        this.type = type;
        this.transportRoute = transportRoute;
    }

    @Override
    public boolean equals(Object obj) {
        return Checker.isEquals(obj, this);
    }

    public void addDriver(Driver driver) {
        this.driverList.add(driver);
    }
}
