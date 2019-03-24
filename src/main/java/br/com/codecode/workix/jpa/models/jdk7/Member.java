package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

import java.util.ArrayList;
import java.util.List;

/**
 * Member JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.0
 */
public class Member extends MyEntity {

    private static final long serialVersionUID = -9177132485712227287L;

    private long id;

    private List<SocialMedia> medias;

    private String name;

    private String occupation;

    private String picture;

    private String shortText;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Member() {
    }


    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Member
     * @see Buildable
     */
    private Member(Builder builder) {
        this.medias = builder.getMedias();
        this.name = builder.getName();
        this.occupation = builder.getOccupation();
        this.picture = builder.getPicture();
        this.shortText = builder.getShortText();
    }

    /**
     * Creates builder to build {@link Member}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Add Social Media
     *
     * @param socialMedia Social Media to Add in the List
     */
    public void addSocialMedia(SocialMedia socialMedia) {
        if (medias == null) {
            medias = new ArrayList<>();
        }
        medias.add(socialMedia);
    }


    /**
     * @return the id
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the medias
     */
    public List<SocialMedia> getMedias() {
        return medias;
    }

    /**
     * @param medias the medias to set
     */
    public void setMedias(List<SocialMedia> medias) {
        this.medias = medias;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the shortText
     */
    public String getShortText() {
        return shortText;
    }

    /**
     * @param shortText the shortText to set
     */
    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    /**
     * Remove Social Media
     *
     * @param socialMedia Remove the Social Media from the List
     */
    public void removeSocialMedia(SocialMedia socialMedia) {
        if (medias == null) {
            medias = new ArrayList<>();
        }
        medias.remove(socialMedia);
    }

    /**
     * Builder to build {@link Member}.
     */
    public static final class Builder extends Member implements Buildable<Member> {

        private static final long serialVersionUID = -7634080325625899123L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return a new Member
         */
        public Member build() {
            return new Member(this);
        }

        public Builder withMedias(List<SocialMedia> medias) {
            super.medias = medias;
            return this;
        }

        public Builder withName(String name) {
            super.name = name;
            return this;
        }

        public Builder withOccupation(String occupation) {
            super.occupation = occupation;
            return this;
        }

        public Builder withPicture(String picture) {
            super.picture = picture;
            return this;
        }

        public Builder withShortText(String shortText) {
            super.shortText = shortText;
            return this;
        }
    }


}
