package org.example.lab03.model;

public class Zloczynca {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;

    }

    @Override
    public String toString() {
        return "Zloczynca{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
