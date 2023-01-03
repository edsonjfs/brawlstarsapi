package brawlstarsapi.infrastructure.maps.domain;

import java.util.List;
public class MapResponse {
    private List<Map> list;

    public List<Map> getList() {
        return list;
    }

    public void setList(List<Map> list) {
        this.list = list;
    }
}
