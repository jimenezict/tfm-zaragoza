package com.uoc.tfm.domain.location;

public class StationLocation {

    private int id;
    private String title;
    private StationGeometry geometry;

    public StationLocation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StationGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(StationGeometry geometry) {
        this.geometry = geometry;
    }

    public class StationGeometry {
        private float coordinates[];

        public float[] getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(float[] coordinates) {
            this.coordinates = coordinates;
        }
    }
}