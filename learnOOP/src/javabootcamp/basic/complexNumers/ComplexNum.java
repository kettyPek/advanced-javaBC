package javabootcamp.basic.complexNumers;

import java.util.Objects;

public class ComplexNum implements Complexable{
	
	protected double realNum;
	protected double imaginaryNum;
	
	//Constructor
	public ComplexNum() {
		this(0,0);
	}
	
	public ComplexNum(double realNum, double imaginaryNum) {
		setRealNum(realNum);
		setImaginaryNum(imaginaryNum);
	}
	
	//
	private double getRealNum() {
		return realNum;
	}

	private void setRealNum(double realNum) {
		this.realNum = realNum;
	}

	private double getImaginaryNum() {
		return imaginaryNum;
	}

	private void setImaginaryNum(double imaginaryNum) {
		this.imaginaryNum = imaginaryNum;
	}
	
	//
	@Override
	public void add(ComplexNum z){
		this.realNum += z.realNum;
		this.imaginaryNum += z.imaginaryNum;
	}
	
	@Override
	public void subtract(ComplexNum z) {
		this.realNum -= z.realNum;
		this.imaginaryNum -= z.imaginaryNum;	
	}
	
	@Override
	public void multiply(ComplexNum z) {
		this.realNum = this.realNum*z.realNum - this.imaginaryNum*z.imaginaryNum;
		this.imaginaryNum = this.realNum*z.imaginaryNum + this.imaginaryNum*z.realNum;
	}
	
	@Override
	public void divide(ComplexNum z) {
		double denominator = z.imaginaryNum*z.imaginaryNum + z.realNum*z.realNum;
		double numeratorReal = this.realNum*z.realNum + this.imaginaryNum*z.imaginaryNum;
		double numeratorIm = this.imaginaryNum*z.realNum - this.realNum*z.imaginaryNum;
		this.realNum = numeratorReal/denominator;
		this.imaginaryNum = numeratorIm/denominator;
	}
	
	@Override
	public ComplexNum conjugate() {
		ComplexNum newComplex = this;
		newComplex.imaginaryNum *=-1;
		return newComplex;
	}

	@Override
	public double mag() {
		double squarsSum = Math.pow(realNum, 2) + Math.pow(imaginaryNum, 2);
		double modulus = Math.sqrt(squarsSum);
		return modulus;
	}

	@Override
	public ComplexNum square() {
		ComplexNum newComplex = multiply(this, this);
		return newComplex;
	}
	
	@Override
	public String toString() {
		return "ComplexNum [realNum= " + realNum + ", imaginaryNum= " + imaginaryNum + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplexNum other = (ComplexNum) obj;
		return imaginaryNum == other.imaginaryNum && realNum == other.realNum;
	}

	@Override
	public ComplexNum pow(ComplexNum z, int power) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplexNum inverse() {
		ComplexNum mewComplex = this;
		double squarsSum = Math.pow(realNum, 2) + Math.pow(imaginaryNum, 2);
		mewComplex.realNum /= squarsSum;
		mewComplex.imaginaryNum /= squarsSum;
		return mewComplex;
	}

	public static ComplexNum add(ComplexNum z1, ComplexNum z2) {
		ComplexNum newComplex = new ComplexNum(z1.realNum,z1.imaginaryNum);
		newComplex.add(z2);
		return newComplex;
	}
	


	public static ComplexNum subtract(ComplexNum z1, ComplexNum z2) {
		ComplexNum newComplex = new ComplexNum(z1.realNum,z1.imaginaryNum);
		newComplex.subtract(z2);
		return newComplex;
	}


	public static ComplexNum multiply(ComplexNum z1, ComplexNum z2) {
		ComplexNum newComplex = new ComplexNum(z1.realNum,z1.imaginaryNum);
		newComplex.multiply(z2);
		return newComplex;
	}


	public static ComplexNum divide(ComplexNum z1, ComplexNum z2) {
		ComplexNum newComplex = new ComplexNum(z1.realNum,z1.imaginaryNum);
		newComplex.divide(z2);
		return newComplex;
	}
	
//	public static ComplexNum parseComplex(String s) {
//		ComplexNum newComplex = new ComplexNum();
//		newComplex.realNum = Integer.parseInt(String.valueOf(ch))
//	}

	
	

	

}
