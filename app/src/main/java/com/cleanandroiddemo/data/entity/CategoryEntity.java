package com.cleanandroiddemo.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Avdhesh AKhani on 8/8/2016.
 */

public class CategoryEntity {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("has_child")
    @Expose
    private Boolean hasChild;
    @SerializedName("alt_name")
    @Expose
    private String altName;

   /* public CategoryEntity(Integer id, String name, String imageUrl, Object parentId, Boolean hasChild, String altName) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.parentId = parentId;
        this.hasChild = hasChild;
        this.altName = altName;
    }*/

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @param imageUrl
     * The image_url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     *
     * @return
     * The parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     *
     * @param parentId
     * The parent_id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     *
     * @return
     * The hasChild
     */
    public Boolean getHasChild() {
        return hasChild;
    }

    /**
     *
     * @param hasChild
     * The has_child
     */
    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    /**
     *
     * @return
     * The altName
     */
    public String getAltName() {
        return altName;
    }

    /**
     *
     * @param altName
     * The alt_name
     */
    public void setAltName(String altName) {
        this.altName = altName;
    }

}
