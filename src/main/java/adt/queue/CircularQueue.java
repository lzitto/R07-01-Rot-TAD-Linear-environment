package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
            throw new QueueOverflowException();
        }
        if (isEmpty()) {
            head = 0;
			tail = 0;
        }
        tail = (tail + 1) % array.length;
        array[tail] = element;
        elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
           throw new QueueOverflowException();
        }

        T element = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        elements--;
        if (elements == 0) {
            head = -1;
            tail = -1;
        }
        return element;
	}

	@Override
	public T head() {
		T result;
		if (isEmpty()) {
            result = null;
        } else {  else { result = array[head];
		}}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}

