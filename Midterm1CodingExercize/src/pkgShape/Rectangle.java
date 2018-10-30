package pkgShape;

public class Rectangle extends Shape implements Comparable<Object> {
	
	private int iWidth;
	private int iLength;
	

	public Rectangle(int iLength, int iWidth) {
		super();
		this.iWidth = iWidth;
		this.iLength = iLength;
	}
	

	public int getiWidth() {
		return iWidth;
	}



	public void setiWidth(int iWidth) {
		this.iWidth = iWidth;
	}



	public int getiLength() {
		return iLength;
	}



	public void setiLength(int iLength) {
		this.iLength = iLength;
	}



	@Override
	public double area() {
		return this.iLength*this.iWidth;
	}

	@Override
	public double perimeter() throws Exception{
		return 2.0*(this.iLength+this.iWidth);
	}

	@Override
	public int compareTo(Object o) {
	
		if(!(o instanceof Rectangle)) 
		{
				try {
					throw new Exception("These two objects don't have the same type.");
				} catch (Exception e) {
					System.out.println("These two objects don't have the same type.");
				}
		}
		
		Rectangle r = (Rectangle) o;
		
		if(this.area()>r.area())
			return 1;
		else if(this.area()<r.area())
			return -1;
		else
			return 0;
	}

}
