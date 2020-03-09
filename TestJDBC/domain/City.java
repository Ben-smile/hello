package domain;

public class City {
    private Integer cityId;
    private String  cityName;
    private Integer citySize;
    private Area area;

    public City(Integer cityId, String cityName, Integer citySize, Area area) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.citySize = citySize;
        this.area = area;
    }
    public City (){}

    public Integer getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getCitySize() {
        return citySize;
    }

    public Area getArea() {
        return area;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCitySize(Integer citySize) {
        this.citySize = citySize;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
