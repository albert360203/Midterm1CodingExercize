package pkgTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import pkgShape.Cuboid;
import pkgShape.Cuboid.SortByArea;
import pkgShape.Cuboid.SortByVolume;
import pkgShape.Rectangle;

class CuboidTest {

	@Test
	public void Cuboid_Test1() {
		Cuboid r = new Cuboid(10,10,10);
		assertTrue(r.getiWidth()==10);
	}
	
	@Test
	public void getiDepth_Test1() {
		Cuboid c = new Cuboid(1,1,1);
		assertTrue(c.getiDepth()==1);
	}
	
	@Test
	public void setiDepth_Test1() {
		Cuboid c = new Cuboid(1,1,1);
		c.setiDepth(3);
		assertTrue(c.getiDepth()==3);
	}
	
	@Test
	public void volume_Test1() {
		Cuboid c = new Cuboid(1,1,1);
		assertTrue(c.volume()==1);
	}
	
	@Test
	public void volume_Test2() {
		Cuboid c = new Cuboid(1,2,3);
		assertTrue(c.volume()==6);
	}
	
	@Test
	public void area_Test1() {
		Cuboid c = new Cuboid(1,1,1);
		assertTrue(c.area()==6.0);
	}
	
	@Test
	public void area_Test2() {
		Cuboid c = new Cuboid(1,2,3);
		assertTrue(c.area()==22.0);
	}
	
	@Test
	public void perimeter_Test1() {
		Cuboid c = new Cuboid(1,1,1);
		try {
		c.perimeter();
		fail("expected exception was not occured.");
		}
		catch(UnsupportedOperationException e)
		{
		}
	}
	
	@Test
	public void compareSortByArea_Test1() {
		Cuboid c1 = new Cuboid(1,1,1);
		Cuboid c2 = new Cuboid(1,2,3);
		SortByArea a = c1.new SortByArea();
		assertTrue(a.compare(c1, c2)<0);
	}
	
	@Test
	public void compareSortByArea_Test2() {
		Cuboid c1 = new Cuboid(3,3,3);
		Cuboid c2 = new Cuboid(1,2,3);
		SortByArea a = c1.new SortByArea();
		assertTrue(a.compare(c1, c2)>0);
	}
	
	@Test
	public void compareSortByArea_Test3() {
		Cuboid c1 = new Cuboid(6,6,6);
		Cuboid c2 = new Cuboid(2,2,26);
		SortByArea a = c1.new SortByArea();
		assertTrue(a.compare(c1, c2)==0);
	}
	
	@Test
	public void compareSortByVolume_Test1() {
		Cuboid c1 = new Cuboid(1,1,1);
		Cuboid c2 = new Cuboid(1,2,3);
		SortByVolume a = c1.new SortByVolume();
		assertTrue(a.compare(c1, c2)<0);
	}
	
	@Test
	public void compareSortByVolume_Test2() {
		Cuboid c1 = new Cuboid(3,3,3);
		Cuboid c2 = new Cuboid(1,2,3);
		SortByVolume a = c1.new SortByVolume();
		assertTrue(a.compare(c1, c2)>0);
	}
	
	@Test
	public void compareSortByVolume_Test3() {
		Cuboid c1 = new Cuboid(4,4,4);
		Cuboid c2 = new Cuboid(2,4,8);
		SortByVolume a = c1.new SortByVolume();
		assertTrue(a.compare(c1, c2)==0);
	}
	
	@Test
	public void SortByAreaOrVolumeDemo_Test1() {
		Cuboid c1 = new Cuboid(1,1,1);
		Cuboid c2 = new Cuboid(5,5,5);
		Cuboid c3 = new Cuboid(2,2,26);
		Cuboid c4 = new Cuboid(10,10,10);
		
		SortByArea sba = c1.new SortByArea();
		SortByVolume sbv = c1.new SortByVolume();
		
		ArrayList<Cuboid> ls = new ArrayList<Cuboid>();
		ls.add(c1);
		ls.add(c2);
		ls.add(c3);
		ls.add(c4);
		
		Collections.shuffle(ls);
		System.out.println("Unsorted:");
		for(Cuboid c : ls)
			System.out.println(c);
		System.out.println();
	
		
		Collections.sort(ls, sba);
		System.out.println("SortByArea:");
		for(Cuboid c : ls)
			System.out.println(c);
		System.out.println();
		assertEquals(ls.get(0),c1);
		assertEquals(ls.get(1),c2);
		assertEquals(ls.get(2),c3);
		assertEquals(ls.get(3),c4);
		
		
		Collections.sort(ls, sbv);
		System.out.println("SortByVolume:");
		for(Cuboid c : ls)
			System.out.println(c);
		System.out.println();
		assertEquals(ls.get(0),c1);
		assertEquals(ls.get(1),c3);
		assertEquals(ls.get(2),c2);
		assertEquals(ls.get(3),c4);
		
	}
}
 