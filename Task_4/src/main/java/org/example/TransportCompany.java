package org.example;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class TransportCompany {
    public Integer id;
    public String name;
    public String address;
    public List <Transport> transportList = new ArrayList<>();

    public TransportCompany() {}

    public TransportCompany(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return Checker.isEquals(obj, this);
    }

    public void addTransport(Transport transport) {
        this.transportList.add(transport);
    }
}
