package org.example.api_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonPropertyOrder({"API", "Description", "Auth", "HTTPS", "Cors", "Link", "Category"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entries {

    private String API;
    private String Description;
    private String Auth;
    private Boolean HTTPS;
    private String Cors;
    private String Link;
    private String Category;

    @JsonProperty("API")
    public String getAPI() {
        return API;
    }

    @JsonProperty("API")
    public void setAPI(String API) {
        this.API = API;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.Description = description;
    }

    @JsonProperty("Auth")
    public String getAuth() {
        return Auth;
    }

    @JsonProperty("Auth")
    public void setAuth(String auth) {
        this.Auth = auth;
    }

    @JsonProperty("HTTPS")
    public Boolean getHTTPS() {
        return HTTPS;
    }

    @JsonProperty("HTTPS")
    public void setHTTPS(Boolean https) {
        this.HTTPS = https;
    }

    @JsonProperty("Cors")
    public String getCors() {
        return Cors;
    }

    @JsonProperty("Cors")
    public void setCors(String cors) {
        this.Cors = cors;
    }

    @JsonProperty("Link")
    public String getLink() {
        return Link;
    }

    @JsonProperty("Link")
    public void setLink(String link) {
        this.Link = link;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return Category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.Category = category;
    }

    public String getValueOf(String qp) {
        switch (qp) {
            case "title":
                return API;
            case "description":
                return Description;
            case "auth":
                return Auth;
            case "https":
                return HTTPS.toString();
            case "cors":
                return Cors;
            case "category":
                return Category;
            default:
                break;
        }
        return null;
    }
}
