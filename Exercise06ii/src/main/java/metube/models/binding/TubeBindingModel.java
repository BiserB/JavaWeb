package metube.models.binding;


import metube.models.interfaces.Model;

import javax.validation.constraints.Size;

public class TubeBindingModel implements Model {

    private String title;
    private String description;
    private String link;
    private String uploader;

    public TubeBindingModel(String title, String description, String link, String uploader) {

        this.title = title;
        this.description = description;
        this.link = link;
        this.uploader = uploader;
    }

    @Size(min = 3)
    @Size(max = 30)
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
