package grafo;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnionFindTest {

	@Test
	public void testUnion() {
		UnionFind u=new UnionFind(18);;
		
		u.union(12,13);
		
		assertTrue(u.find(12, 13));
	}
	@Test
	public void consultarNoUnion() {
		UnionFind u=unionFeliz();
		
		u.union(12,13);
		
		assertFalse(u.find(11, 13));
	}
	@Test (expected = IllegalArgumentException.class)
	public void igualesUnion() {
		UnionFind u=unionFeliz();
		
		u.union(12,12);
	}
	@Test(expected = IllegalArgumentException.class)
	public void negativoUnion() {
		UnionFind u=unionFeliz();
		
		u.union(-12,13);
	}
	@Test
	public void testFind() {
		UnionFind u=unionFeliz();
		
		assertTrue(u.find(5,6));
	}
	@Test
	public void consultarNoFind() {
		UnionFind u=unionFeliz();
		
		assertFalse(u.find(17,6));
	}
	@Test 
	public void igualesFind() {
		UnionFind u=unionFeliz();
		
		assertTrue(u.find(6, 6));
	}
	@Test(expected = IllegalArgumentException.class)
	public void negativoFind() {
		UnionFind u=unionFeliz();
		
		u.find(-12,13);
	}
	private UnionFind unionFeliz() {
		UnionFind u=new UnionFind(18);
		for(int i=0;i<10;i++) {
			if(!u.find(i, i+1)) {
				u.union(i, i+1);
			}
		}
		return u;
	}
}
