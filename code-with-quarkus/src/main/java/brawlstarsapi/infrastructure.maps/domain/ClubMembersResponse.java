package brawlstarsapi.infrastructure.maps.domain;

import java.util.List;

public class ClubMembersResponse {

    private List<Member> items;
    private Paging paging;

    public ClubMembersResponse() {
    }

    public List<Member> getItems() {
        return items;
    }

    public void setItems(List<Member> items) {
        this.items = items;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
