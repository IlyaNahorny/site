package bsuir.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="materials")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Integer id_material;

    @Column(name = "materialName", nullable = false)
    @JsonProperty
    private String materialName;

    @Column(name = "description", nullable = false, length = 65536)
    @JsonProperty
    private String description;

    @Column(name = "template", nullable = false, length = 30)
    @JsonProperty
    private String template;

    @Column(name = "url", nullable = false)
    @JsonProperty
    private String url;

    @Column(name = "rating", nullable = false)
    @JsonProperty
    private int rating = 0;

    @Column(name = "comment", nullable = false)
    @JsonProperty
    private int comment = 0;

    @ManyToOne(optional = false)
    @JoinColumn(name = "username", referencedColumnName = "username", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;

    @JsonProperty
    @OneToMany(orphanRemoval = true, mappedBy = "material", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Comment> comments;

    @JsonProperty
    @OneToMany(orphanRemoval = true, mappedBy = "material", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Set<Rating> ratings;


    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getId_material() {
        return id_material;
    }

    public void setId_material(Integer id_material) {
        this.id_material = id_material;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}