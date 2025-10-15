package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTester {
	SinglyLinkedList<Integer> emptyLinkedList;
	SinglyLinkedList<Integer> largerLinkedList;
	@BeforeEach
	void setup() {
		 emptyLinkedList = new SinglyLinkedList<Integer>();
		 largerLinkedList = new SinglyLinkedList<Integer>();

		 
		 for(int i = 0; i < 100; i++) {
			 largerLinkedList.insertFirst(i);
		 }
	}

	@Test
	void insertFirstTest() {
		emptyLinkedList.insertFirst(0);
		assertEquals(0, emptyLinkedList.getFirst());
	}
	
	@Test
	void testInsertFirstCheckWithIterator() {
		emptyLinkedList.insertFirst(0);
		emptyLinkedList.insertFirst(1);
		emptyLinkedList.insertFirst(2);
		int i = 2;
		for (Integer intNode : emptyLinkedList) {
			assertEquals(i, intNode);
			i--;
		}
	}
	
	/*
	 * getFirst was also checked in the insert first test
	 */
	@Test
	void testGetFirstWithLoop() {
		int i = 0;
		while (i < 50) {
			emptyLinkedList.insertFirst(i);
			assertEquals(i, emptyLinkedList.getFirst());
			i++;
		}
	}
	
	@Test
	void testInsertAtBeginning() {
		largerLinkedList.insert(0, 600);
		assertEquals(600, largerLinkedList.getFirst());
	}
	
	@Test
	void testInsertAtMiddle() {
		largerLinkedList.insert(50, 600);
		assertEquals(600, largerLinkedList.get(50));
	}
	
	@Test 
	void testInsertAtEnd() {
		largerLinkedList.insert(100, 600);
		assertEquals(600, largerLinkedList.get(100));
		
	}
	
	@Test 
	void testInsertAtEndWithiterator() {
		largerLinkedList.insert(100, 600);
		int last = 0;
		for (Integer each : largerLinkedList) {
			last = each;
		}
		assertEquals(600, last);
	}
	
	/*
	 * other cases of the get method were already effectively tested for 
	 * middle and end along with insert
	 */
	@Test
	void testGetAtBeginning() {
		largerLinkedList.insertFirst(600);
		assertEquals(600, largerLinkedList.get(0));
	}
	
	@Test
	void testSizeLargerList() {
		assertEquals(100, largerLinkedList.size());
	}
	
	@Test
	void testSizeEmptyList() {
		assertEquals(0, emptyLinkedList.size());
	}
	
	@Test
	void testDeleteFirst() {
		largerLinkedList.deleteFirst();
		assertEquals(98,largerLinkedList.getFirst() );
		assertEquals(99, largerLinkedList.size());
	}
	
	@Test
	void testDeleteFirstListOfOneItem() {
		emptyLinkedList.insertFirst(0);
		emptyLinkedList.deleteFirst();
		assertEquals(0, emptyLinkedList.size());
	}
	
	@Test
	void testDeleteMethodFirstItem() {
		largerLinkedList.delete(0);
		assertEquals(98,largerLinkedList.getFirst() );
		assertEquals(99, largerLinkedList.size());
	}
	
	@Test
	void testDeleteMethodMiddleItemSmallList() {
		emptyLinkedList.insertFirst(2);
		emptyLinkedList.insertFirst(1);
		emptyLinkedList.insertFirst(0);
		
		emptyLinkedList.delete(1);
		assertEquals(-1, emptyLinkedList.indexOf(1));
	}

	@Test
	void testDeleteMethodMiddleItem() {
		largerLinkedList.delete(49);
		assertEquals(-1, largerLinkedList.indexOf(50));
	}
}
