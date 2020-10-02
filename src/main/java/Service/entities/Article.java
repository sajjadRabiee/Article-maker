package Service.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article_table" , catalog = "schema1" , schema = "schema1")
public class Article implements EntityInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long id;
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @Column(name = "brief")
    private String brief;
    @Column(name = "content")
    private String content;
    @Column(name = "creation_date")
    private Date createDate;
    @Column(name = "is_published")
    private boolean isPublished;
    @Column(name = "last_update_date")
    private Date lastUpdateDate;
    @Column(name = "publish_date")
    private Date publishDate;
    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User userOfArticle;
    @ManyToOne
    @JoinColumn(name = "fk_category")
    private Category category;
    @ManyToMany
    @JoinTable(
            name = "article_tag",
            joinColumns = {@JoinColumn(name = "fk_article",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_tag",referencedColumnName = "id")}
    )
    private List<Tag> tags = new ArrayList<Tag>();
    //by set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public User getUserOfArticle() {
        return userOfArticle;
    }

    public void setUserOfArticle(User userOfArticle) {
        this.userOfArticle = userOfArticle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

}
