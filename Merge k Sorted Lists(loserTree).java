/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int nArray = lists.size();
        int[] num = new int[2*nArray];
        for (int i = 0; i < num.size; i++)
            num[i] = 0;
            
        int inStart = 1, extNum = 0;
        for (inStart = 1; inStart*2 <= nArray-1; inStart *= 2);
        extNum = 2*(nArray-inStart);
        
        for (int i = 0; i < nArray; i++)
            num[i+nArray] = i;
            
        for (int i = 0; i < extNum/2; i++) {
            int idx = inStart + i;
            play(num, idx);
        }
        
        for (int i = extNum/2; i < 2*inStart; i += 2) {
            int idx = (inStart + i)/2;
            play(num, idx);
        }
        
        ListNode winner = lists.get(num[0]);
        ListNode head = new ListNode(winner.val);
        if (winner.next == null) {
            winner.next = new ListNode(Integer.MAX_VALUE);
        }
        winner = winner.next;
        ListNode temp = head;
        
        while (true) {
            int pos = num[0] + nArray;
            int newWinner = rePlay(num, pos);
            ListNode winnerNode = new ListNode(newWinner);
            temp.next = winnerNode;
            temp = temp.next;
            
        }
        
        return head;
    }
    
    public int play(int[] num, int idx) {
        num[idx] = getLoser(num, idx*2, idx*2+1);
        int tempW = getWinner(num, idx*2, idx*2+1);
        while (idx > 1 && idx%2 == 1) {
            int newW = getWinner(num, num[idx/2], tempW);
            num[idx/2] = getLoser(num, num[idx/2], tempW);
            tempW = newW;
            idx /= 2;
        }
        num[idx/2] = tempW;
    }
    
    public int getWinner(ArrayList<ListNode> lists, int[] num, int first, int second) {
        return lists.get(num[first]).val > lists.get(num[second]).val ? second : first;
    }
    
    public int getLoser(ArrayList<ListNode> lists, int[] num, int first, int second) {
        return ists.get(num[first]).val < lists.get(num[second]).val ? second : first;
    }
}