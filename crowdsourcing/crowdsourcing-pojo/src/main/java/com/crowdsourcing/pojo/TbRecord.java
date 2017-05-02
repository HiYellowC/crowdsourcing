package com.crowdsourcing.pojo;

import java.util.Date;

import com.crowdsourcing.common.pojo.Rectangle;

public class TbRecord {
    private Long id;

    private Integer step;

    private Long editorId;

    private Long imageId;

    private Double x;

    private Double y;

    private Double width;

    private Double height;

    private Boolean pass;

    private Date gmtCreate;

    private Date gmtModified;

    public void setRectangle(Rectangle rectangle) {
    	this.imageId = rectangle.getId();
    	this.x = rectangle.getX();
    	this.y = rectangle.getY();
    	this.width = rectangle.getWidth();
    	this.height = rectangle.getHeight();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Long getEditorId() {
        return editorId;
    }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

	@Override
	public String toString() {
		return "TbRecord [id=" + id + ", step=" + step + ", editorId=" + editorId + ", imageId=" + imageId + ", x=" + x
				+ ", y=" + y + ", width=" + width + ", height=" + height + ", pass=" + pass + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
    
    
    
}