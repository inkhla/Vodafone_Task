package org.example.api_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"count", "entries"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicAPI {

    @JsonProperty("count")
    private int count;
    private List<Entries> entries;

    public PublicAPI(){
        Entries entry = new Entries();
        List<Entries> entries = new ArrayList<>();
        entries.add(entry);

        this.entries = entries;
    }
    public List<Entries> getEntries() {
        return entries;
    }
    public void setEntries(List<Entries> entries) {
        this.entries = entries;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}