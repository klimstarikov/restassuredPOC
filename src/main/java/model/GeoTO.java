package model;

import java.util.Objects;

public class GeoTO {
    private String lat;
    private String lng;

    public GeoTO(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public GeoTO() {
        // Default constructor for deserialization
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GeoTO geoTO)) return false;
        return getLat().equals(geoTO.getLat()) && getLng().equals(geoTO.getLng());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLat(), getLng());
    }
}
