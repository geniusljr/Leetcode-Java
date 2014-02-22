public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null)
            return null;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode temp = head, newTemp = newHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while (temp != null) {
            map.put(temp, newTemp);
            temp = temp.next;
            newTemp.next = temp == null ? null : new RandomListNode(temp.label);
            newTemp = newTemp.next;
        }
        
        temp = head;
        newTemp = newHead;
        while (temp != null) {
            newTemp.random = map.get(temp.random);
            temp = temp.next;
            newTemp = newTemp.next;
        }
        
        return newHead;
    }