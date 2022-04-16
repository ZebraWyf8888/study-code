package main

type LRUCache struct {
	size       int
	cap        int
	cache      map[int]*DLinkedNode
	head, tail *DLinkedNode
}

type DLinkedNode struct {
	key, value int
	prev, next *DLinkedNode
}

func initDLinkedNode(key, value int) *DLinkedNode {
	return &DLinkedNode{
		key:   key,
		value: value,
		prev:  nil,
		next:  nil,
	}
}
func Constructor(cap int)LRUCache  {
	l := LRUCache{
		cache: map[int]*DLinkedNode{},
		head: initDLinkedNode(0,0),
		tail: initDLinkedNode(0,0),
		cap:cap,
	}
	l.head.next = l.tail
	l.tail.prev = l.head
	return l
}

func (this *LRUCache) Get(key int) int  {
	if _,ok := this.cache[key];!ok{
		return -1
	}
	node := this.cache[key]
	this.moveToHead(node)
	return node.value
}

func (this *LRUCache) moveToHead(node *DLinkedNode) {
	this.remove(node)
	this.addToHead(node)
}

func (this *LRUCache) remove(node *DLinkedNode) {
	node.prev.next = node.next
	node.next.prev = node.prev
}

func (this *LRUCache) addToHead(node *DLinkedNode) {
	node.prev = this.head
	node.next = this.head.next
	this.head.next.prev = node
	this.head.next = node
}

func (this *LRUCache) removeTail() *DLinkedNode {
	node := this.tail.prev
	this.remove(node)
	return node
}

func (this *LRUCache) Put(key int,value int)  {
	if _,ok := this.cache[key];!ok {
		node := initDLinkedNode(key,value)
		this.cache[key] = node
		this.addToHead(node)
		this.size++
		if this.size > this.cap {
			tail := this.removeTail()
			delete(this.cache,tail.key)
			this.size--
		}
	}else {
		node := this.cache[key]
		node.value = value
		this.moveToHead(node)
	}
}