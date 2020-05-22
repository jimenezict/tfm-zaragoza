package com.uoc.tfm.service;

import com.uoc.tfm.domain.location.StationLocationMain;
import com.uoc.tfm.domain.status.StationStatusMain;
import com.uoc.tfm.commons.domain.StationsLocation;
import com.uoc.tfm.commons.domain.StationsStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.time.LocalDate;

import static java.time.LocalDateTime.now;

@Service
public class ClientServiceImpl implements ClientService {

    @Value("${service.name:default}")
    private String serviceName;

    private final String urlStatus = "https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/estacion-bicicleta.json?rows=150";
    private final String urlLocation = "https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/estacion-bicicleta.json?rows=150";

    @Override
    public StationsLocation getStationsLocation() {
        RestTemplate restTemplate = new RestTemplate();
        StationLocationMain stationLocation = restTemplate.getForObject(urlLocation, StationLocationMain.class);
        return mapStationsLocation(stationLocation);
    }

    @Override
    public StationsStatus getStationStatus() {
        RestTemplate restTemplate = new RestTemplate();
        StationStatusMain stationStatusMain = restTemplate.getForObject(urlStatus, StationStatusMain.class);
        return  mapStationsStatus(stationStatusMain);
    }

    private StationsStatus mapStationsStatus(StationStatusMain stationStatusMain) {
        StationsStatus stationsStatus = new StationsStatus(now());
        stationStatusMain.getResult().forEach(x -> {
            int size = x.getBicisDisponibles() + x.getAnclajesDisponibles();
            stationsStatus.addStation(x.getId(),size, x.getBicisDisponibles());
        });
        return stationsStatus;
    }

    private StationsLocation mapStationsLocation(StationLocationMain stationLocationMain) {
        StationsLocation stationsLocation = new StationsLocation(LocalDate.now());
        stationLocationMain.getResult().forEach(x -> {
            stationsLocation.addStation(x.getId(), x.getGeometry().getCoordinates()[1], x.getGeometry().getCoordinates()[0], x.getTitle());
        });
        return stationsLocation;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
}
