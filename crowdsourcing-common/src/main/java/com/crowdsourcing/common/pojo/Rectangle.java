package com.crowdsourcing.common.pojo;

public class Rectangle {

	//对应imageId
	private Long id;
	
	private double x;
	
	private double y;
	
	private double width;
	
	private double height;

	
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(Long id, double x, double y, double width, double height) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [id=" + id + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}
	
}
