package com.fiap.apiconsumer.dto;

import java.io.Serializable;

public class DroneDto implements Serializable {
    public Long id;
    public Double latitude;
    public Double longitude;
    public Double temperatura;
    public Double umidade;
    public boolean rastreamento;
}
