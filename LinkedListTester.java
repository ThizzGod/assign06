package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
		assertEquals(99, largerLinkedList.deleteFirst());
		assertEquals(98,largerLinkedList.getFirst() );
		assertEquals(99, largerLinkedList.size());
	}
	
	@Test
	void testDeleteFirstListOfOneItem() {
		emptyLinkedList.insertFirst(0);
		assertEquals(0, emptyLinkedList.deleteFirst());
		assertEquals(0, emptyLinkedList.size());
	}
	
	@Test
	void testDeleteMethodFirstItem() {
		assertEquals(99, largerLinkedList.delete(0));
		assertEquals(98,largerLinkedList.getFirst() );
		assertEquals(99, largerLinkedList.size());
	}
	
	@Test
	void testDeleteMethodMiddleItemSmallList() {
		emptyLinkedList.insertFirst(2);
		emptyLinkedList.insertFirst(1);
		emptyLinkedList.insertFirst(0);
		
		assertEquals(1, emptyLinkedList.delete(1));
		assertEquals(-1, emptyLinkedList.indexOf(1));
	}

	@Test
	void testDeleteMethodMiddleItem() {
		assertEquals(50, largerLinkedList.delete(49));
		assertEquals(-1, largerLinkedList.indexOf(50));
		assertEquals(99, largerLinkedList.size());
	}
	
	@Test
	void testIndexOfElementNotInList() {
		assertEquals(-1, largerLinkedList.indexOf(600));
	}
	
	@Test
	void testIndexOfElementEmptyList() {
		assertEquals(-1, emptyLinkedList.indexOf(600));
	}
	
	@Test
	void testIndexOfEndOfList() {
		emptyLinkedList.insertFirst(2);
		emptyLinkedList.insertFirst(1);
		emptyLinkedList.insertFirst(0);
		assertEquals(2, emptyLinkedList.indexOf(2));
	}
	
	@Test
	void testIndexOfMiddleOfList() {
		assertEquals(49, largerLinkedList.indexOf(50));
	}
	
	@Test
	void testIndexOfBeginningOfList() {
		assertEquals(0, largerLinkedList.indexOf(99));
		
	}

	@Test
	void testIsempty() {
		assertTrue(emptyLinkedList.isEmpty());
	}
	
	@Test
	void testIsEmptyNotEmpty() {
		assertFalse(largerLinkedList.isEmpty());
	}
	
	@Test
	void testClearList() {
		largerLinkedList.clear();
		assertTrue(largerLinkedList.isEmpty());
	}
	
	@Test
	void testToArrayEmptyList() {
		Object[] emptyArray = emptyLinkedList.toArray();
		assertEquals(0, emptyArray.length);
	}
	
	@Test
	void testToArrayLargerList() {
		Object[] largerArray = largerLinkedList.toArray();
		Iterator<Integer> iterator = largerLinkedList.iterator();
		assertEquals(100, largerArray.length);
		for (int i = 0; i < largerArray.length; i++) {
			assertEquals(largerArray[i], iterator.next());
		}
	}

	@Test
	void testClearListCannotAccessElements() {
		largerLinkedList.clear();
		assertThrows(NoSuchElementException.class, ()-> largerLinkedList.getFirst());
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.get(1));
	}
	
	@Test
	void testInsertThrowsIndexOutOfBoundsTooHigh() {
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.insert(500, 25));
	}

	@Test
	void testInsertsAtBeginningOfEmptyList() {
		emptyLinkedList.insert(0, 25);
		assertEquals(1, emptyLinkedList.size());
	}
	
	@Test
	void testInsertThrowsIndexOutOfBoundsNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.insert(-5, 25));
	}
	
	@Test
	void testGetFirstThrowsNoSuchElementException() {
		assertThrows(NoSuchElementException.class, ()-> emptyLinkedList.getFirst());
	}
	
	@Test
	void testGetThrowsIndexOutOfBoundsExceptionTooHigh() {
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.get(500));
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.get(100));
	}

	@Test
	void testGetThrowsIndexOutOfBoundsExceptionNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.get(-5));
	}
	
	@Test
	void deleteFirstThrowsNoSuchElement() {
		assertThrows(NoSuchElementException.class, ()-> emptyLinkedList.deleteFirst());
	}
	
	@Test
	void deleteThrowsIndexOutOfBoundsExceptionTooHigh() {
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.delete(500));
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.delete(100));
	}

	@Test
	void deleteThrowsIndexOutOfBoundsExceptionNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()-> largerLinkedList.delete(-100));
	}
	
	@Test
	void testIteratorHasNextEmptyList() {
		Iterator<Integer> iterator = emptyLinkedList.iterator();
		assertFalse(iterator.hasNext());
	}
	
	@Test
	void testIteratorNextThrowsNoSuchElementException() {
		Iterator<Integer> iterator = emptyLinkedList.iterator();
		assertThrows(NoSuchElementException.class, ()-> iterator.next());
	}
	
	@Test
	void testIteratorRemoveMethodAfterOneCallToNext() {
		emptyLinkedList.insertFirst(2);
		emptyLinkedList.insertFirst(1);
		emptyLinkedList.insertFirst(0);
		Iterator<Integer> iterator = emptyLinkedList.iterator();
		iterator.next();
		iterator.remove();
		assertEquals(-1, emptyLinkedList.indexOf(0));
	}
	
	@Test
	void testIteratorRemoveMethodNoCallsToNext() {
		emptyLinkedList.insertFirst(2);
		emptyLinkedList.insertFirst(1);
		emptyLinkedList.insertFirst(0);
		Iterator<Integer> iterator = emptyLinkedList.iterator();
		assertThrows(IllegalStateException.class, ()-> iterator.remove());
	}
	
	@Test
	void testIteratorRemoveMethodTwoCallsInARow() {
		emptyLinkedList.insertFirst(2);
		emptyLinkedList.insertFirst(1);
		emptyLinkedList.insertFirst(0);
		Iterator<Integer> iterator = emptyLinkedList.iterator();
		iterator.next();
		iterator.remove();
		assertThrows(IllegalStateException.class, ()-> iterator.remove());
	}
	
}
