package metube.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "tubes")
public class Tube extends BaseEntity {

    private String title;
    private String author;
    private String description;
    private String link;
    private long views;
    private User uploader;

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @ManyToOne(targetEntity = User.class)
    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }
}
