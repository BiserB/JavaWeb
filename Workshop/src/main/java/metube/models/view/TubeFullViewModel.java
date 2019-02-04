package metube.models.view;

import metube.models.interfaces.Model;

public class TubeFullViewModel implements Model {

    private String id;
    private String title;
    private String description;
    private String link;
    private String uploader;

    public TubeFullViewModel() {
    }

    public TubeFullViewModel(String id, String title, String description, String link ,String uploader) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.uploader = uploader;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
