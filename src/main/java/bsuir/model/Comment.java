package bsuir.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="comments")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Comment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Integer id_comment;

    @Column(name = "text", nullable = false, length = 65536)
    @JsonProperty
    private String text;

    @Column(name = "username", nullable = false)
    @JsonProperty
    private String username;

    @Column(name = "url_profile", nullable = false)
    @JsonProperty
    private String url;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_material", referencedColumnName = "id_material", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Material material;

    public Integer getId_comment() {
        return id_comment;
    }

    public void setId_comment(Integer id_comment) {
        this.id_comment = id_comment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
