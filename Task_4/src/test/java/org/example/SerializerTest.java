package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SerializerTest {
    @Test
    void jsonSerialize() throws IOException {
        TransportCompany tc = new TransportCompany(1, "TCN", "ADDRESS");
        TransportRoute tr = new TransportRoute(85,"Start","Finish",15);
        TransportRoute tr1 = new TransportRoute(76,"Start1","Finish2",14);
        Transport t = new Transport(990088, "bus", tr);
        Transport t1 = new Transport(660088, "bus", tr1);
        tc.addTransport(t);
        tc.addTransport(t1);
        Driver d = new Driver(12, "Ivan", 30000);
        Driver d1 = new Driver(13, "Petr", 25000);
        Driver d2 = new Driver(14, "Genadii", 27000);
        t.addDriver(d);
        t.addDriver(d1);
        t.addDriver(d2);
        t1.addDriver(d2);
        String s = "{\"id\":1," +
                "\"name\":\"TCN\"," +
                "\"address\":\"ADDRESS\"," +
                "\"transportList\":[" +
                    "{\"number\":990088," +
                    "\"type\":\"bus\"," +
                    "\"driverList\":[" +
                        "{\"id\":12," +
                        "\"name\":\"Ivan\"," +
                        "\"salary\":30000}," +
                        "{\"id\":13," +
                        "\"name\":\"Petr\"," +
                        "\"salary\":25000}," +
                        "{\"id\":14," +
                        "\"name\":\"Genadii\"," +
                        "\"salary\":27000}]," +
                    "\"transportRoute\":" +
                        "{\"number\":85," +
                        "\"startStop\":\"Start\"," +
                        "\"endStop\":\"Finish\"," +
                        "\"stopCount\":15}}," +
                    "{\"number\":660088," +
                    "\"type\":\"bus\"," +
                    "\"driverList\":[" +
                        "{\"id\":14," +
                        "\"name\":\"Genadii\"," +
                        "\"salary\":27000}]," +
                    "\"transportRoute\":" +
                        "{\"number\":76," +
                        "\"startStop\":\"Start1\"," +
                        "\"endStop\":\"Finish2\"," +
                        "\"stopCount\":14}}]}";
        assertEquals(Serializer.jsonSerialize(tc), s);
    }


    @Test
    void jsonSerialize2() throws IOException {
        TransportCompany tc = new TransportCompany(1, "TCN", "ADDRESS");
        TransportRoute tr = new TransportRoute(85,"Start","Finish",15);
        Transport t = new Transport(990088, "bus", tr);
        tc.addTransport(t);
        Driver d = new Driver(12, "Ivan", 30000);
        t.addDriver(d);
        String s = "{\"id\":1," +
                    "\"name\":\"TCN\"," +
                    "\"address\":\"ADDRESS\"," +
                    "\"transportList\":[" +
                        "{\"number\":990088," +
                        "\"type\":\"bus\"," +
                        "\"driverList\":[" +
                            "{\"id\":12," +
                            "\"name\":\"Ivan\"," +
                            "\"salary\":30000}]," +
                        "\"transportRoute\":" +
                            "{\"number\":85," +
                            "\"startStop\":\"Start\"," +
                            "\"endStop\":\"Finish\"," +
                            "\"stopCount\":15}}]}";
        assertEquals(Serializer.jsonSerialize(tc), s);
    }

    @Test
    void jsonDeserialize() throws IOException {
        TransportCompany tc = new TransportCompany(1, "TCN", "ADDRESS");
        TransportRoute tr = new TransportRoute(85,"Start","Finish",15);
        Transport t = new Transport(990088, "bus", tr);
        tc.addTransport(t);
        Driver d = new Driver(12, "Ivan", 30000);
        t.addDriver(d);
        String s = "{\"id\":1," +
                    "\"name\":\"TCN\"," +
                    "\"address\":\"ADDRESS\"," +
                    "\"transportList\":[" +
                        "{\"number\":990088," +
                        "\"type\":\"bus\"," +
                        "\"driverList\":[" +
                            "{\"id\":12," +
                            "\"name\":\"Ivan\"," +
                            "\"salary\":30000}]," +
                        "\"transportRoute\":" +
                            "{\"number\":85," +
                            "\"startStop\":\"Start\"," +
                            "\"endStop\":\"Finish\"," +
                            "\"stopCount\":15}}]}";
        assertEquals(Serializer.jsonDeserialize(s, TransportCompany.class), tc);
    }

    @Test
    void xmlSerialize() throws IOException {
        TransportCompany tc = new TransportCompany(1, "TCN", "ADDRESS");
        TransportRoute tr = new TransportRoute(85,"Start","Finish",15);
        Transport t = new Transport(990088, "bus", tr);
        tc.addTransport(t);
        Driver d = new Driver(12, "Ivan", 30000);
        t.addDriver(d);
        String s = "<TransportCompany>" +
                        "<id>1</id>" +
                        "<name>TCN</name>" +
                        "<address>ADDRESS</address>" +
                        "<transportList><transportList>" +
                            "<number>990088</number>" +
                            "<type>bus</type>" +
                            "<driverList><driverList>" +
                                "<id>12</id>" +
                                "<name>Ivan</name>" +
                                "<salary>30000</salary>" +
                            "</driverList></driverList>" +
                            "<transportRoute>" +
                                "<number>85</number>" +
                                "<startStop>Start</startStop>" +
                                "<endStop>Finish</endStop>" +
                                "<stopCount>15</stopCount>" +
                            "</transportRoute>" +
                        "</transportList></transportList>" +
                    "</TransportCompany>";
        assertEquals(Serializer.xmlSerialize(tc), s);
    }

    @Test
    void xmlDeserialize() throws IOException {
        TransportCompany tc = new TransportCompany(1, "TCN", "ADDRESS");
        TransportRoute tr = new TransportRoute(85,"Start","Finish",15);
        Transport t = new Transport(990088, "bus", tr);
        tc.addTransport(t);
        Driver d = new Driver(12, "Ivan", 30000);
        t.addDriver(d);
        String s = "<TransportCompany>" +
                        "<id>1</id>" +
                        "<name>TCN</name>" +
                        "<address>ADDRESS</address>" +
                        "<transportList><transportList>" +
                            "<number>990088</number>" +
                            "<type>bus</type>" +
                            "<driverList><driverList>" +
                                "<id>12</id>" +
                                "<name>Ivan</name>" +
                                "<salary>30000</salary>" +
                            "</driverList></driverList>" +
                            "<transportRoute>" +
                                "<number>85</number>" +
                                "<startStop>Start</startStop>" +
                                "<endStop>Finish</endStop>" +
                                "<stopCount>15</stopCount>" +
                            "</transportRoute>" +
                        "</transportList></transportList>" +
                    "</TransportCompany>";
        assertEquals(Serializer.xmlDeserialize(s, TransportCompany.class), tc);
    }

    @Test
    void yamlSerialize() throws IOException {
        TransportCompany tc = new TransportCompany(1, "TCN", "ADDRESS");
        TransportRoute tr = new TransportRoute(85,"Start","Finish",15);
        Transport t = new Transport(990088, "bus", tr);
        tc.addTransport(t);
        Driver d = new Driver(12, "Ivan", 30000);
        t.addDriver(d);
        System.out.println(Serializer.yamlSerialize(tc));
        String s = "---\n" +
                "id: 1\n" +
                "name: \"TCN\"\n" +
                "address: \"ADDRESS\"\n" +
                "transportList:\n" +
                "- number: 990088\n" +
                "  type: \"bus\"\n" +
                "  driverList:\n" +
                "  - id: 12\n" +
                "    name: \"Ivan\"\n" +
                "    salary: 30000\n" +
                "  transportRoute:\n" +
                "    number: 85\n" +
                "    startStop: \"Start\"\n" +
                "    endStop: \"Finish\"\n" +
                "    stopCount: 15\n";
        assertEquals(Serializer.yamlSerialize(tc), s);
    }

    @Test
    void yamlDeserialize() throws IOException {
        TransportCompany tc = new TransportCompany(1, "TCN", "ADDRESS");
        TransportRoute tr = new TransportRoute(85,"Start","Finish",15);
        Transport t = new Transport(990088, "bus", tr);
        tc.addTransport(t);
        Driver d = new Driver(12, "Ivan", 30000);
        t.addDriver(d);
        String s = "---\n" +
                "id: 1\n" +
                "name: \"TCN\"\n" +
                "address: \"ADDRESS\"\n" +
                "transportList:\n" +
                "- number: 990088\n" +
                "  type: \"bus\"\n" +
                "  driverList:\n" +
                "  - id: 12\n" +
                "    name: \"Ivan\"\n" +
                "    salary: 30000\n" +
                "  transportRoute:\n" +
                "    number: 85\n" +
                "    startStop: \"Start\"\n" +
                "    endStop: \"Finish\"\n" +
                "    stopCount: 15\n";
        assertEquals(Serializer.yamlDeserialize(s, TransportCompany.class), tc);
    }
}
