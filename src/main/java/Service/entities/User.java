package Service.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_table")
public class User implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false , nullable = false)
    private long id;
    @Column(name = "username" , unique = true)
    private String username;
    @Column(name = "national_code" , unique = true)
    private String nationalCode;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name ="fk_role")
    private Role role;
    @OneToMany(mappedBy = "userOfArticle")
    private List<Article> articles = new ArrayList<Article>();

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(Article article) {
        this.articles.add(article);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
