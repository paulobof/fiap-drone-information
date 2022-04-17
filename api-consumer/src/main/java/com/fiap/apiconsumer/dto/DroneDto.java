package com.fiap.apiconsumer.dto;


public class DroneDto {
    public Long id;
    public Double latitude;
    public Double longitude;
    public Double temperatura;
    public Double umidade;
    public boolean rastreamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public boolean isRastreamento() {
        return rastreamento;
    }

    public void setRastreamento(boolean rastreamento) {
        this.rastreamento = rastreamento;
    }

}
