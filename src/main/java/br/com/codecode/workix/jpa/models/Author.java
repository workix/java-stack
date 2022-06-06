package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Author JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 * @author felipe
 * @see MyEntity
 * @since 1.0
 * @version 1.1
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Author extends MyEntity {

    private static final long serialVersionUID = 4441917823240375511L;

    private String aboutText;

    private long id;

    private List<SocialMedia> medias;

    private String name;

    private String picture;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Author(){}

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Author
     */
    private Author(Builder builder) {
        this.id = builder.getId();
        this.aboutText = builder.getAboutText();
        this.medias = builder.getMedias();
        this.name = builder.getName();
        this.picture = builder.getPicture();
    }

    /**
     * Creates builder to build {@link Author}.
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Add Social Media
     * @param socialMedia Url for Social Media
     */
    public void addSocialMedia(SocialMedia socialMedia){
        if(medias == null){
            medias = new ArrayList<>();
        }

        medias.add(socialMedia);
    }

    /**
     * @return the aboutText
     */
    @NotEmpty
    @Column
    public String getAboutText() {
        return aboutText;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
        return id;
    }

    /**
     * @return the medias
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Author_Medias", joinColumns = @JoinColumn(name = "id"))
    public List<SocialMedia> getMedias() {
        return medias;
    }

    /**
     * @return the name
     */
    @NotEmpty
    @Column
    public String getName() {
        return name;
    }

    /**
     * @return the picture
     */
    @Column
    public String getPicture() {
        return picture;
    }

    /**
     * Remove Social Media
     * @param socialMedia Url for Social Media
     */
    public void removeSocialMedia(SocialMedia socialMedia){
        if(medias == null){
            medias = new ArrayList<>();
        }
        medias.remove(socialMedia);
    }

    /**
     * @param aboutText
     *            the aboutText to set
     */
    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param medias
     *            the medias to set
     */
    public void setMedias(List<SocialMedia> medias) {
        this.medias = medias;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param picture
     *            the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Builder to build {@link Author}.
     */
    public static final class Builder  extends Author implements Buildable<Author>{

        private static final long serialVersionUID = -8399508111893300657L;

        private Builder() {}

        public Author build() {
            return new Author(this);
        }

        public Builder withAboutText(String aboutText) {
            super.aboutText = aboutText;
            return this;
        }

        public Builder withMedias(List<SocialMedia> medias) {
            super.medias = medias;
            return this;
        }

        public Builder withName(String name) {
            super.name = name;
            return this;
        }

        public Builder withPicture(String picture) {
            super.picture = picture;
            return this;
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
