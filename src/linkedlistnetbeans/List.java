package linkedlistnetbeans;
import javax.swing.*;

public class List {
    Node head;
    Node tail;
    int  length;

    public List(){
        head = null;
        tail = null;
        length = 0;
    }

    public void AddToBegining(int number){
        Node T = new Node();
        T.data = number;
        
        if (head == null) {
            T.next = null;
            head = T;
            tail = T;
         }else{
            T.next = head;
            head = T;
         }
       
        length++;
    }
    public void AddToEnd(int number){
        Node T = new Node();
        T.data = number;
        
        T.next = null;
        if (head == null) {
            head = T;
            tail = T;
        }else{
            tail.next = T;
            tail = T;
        }
      
        length++;
    }
    //doesnt work
    public void AddAfterNthNode(int number, int position){
        //if(position==1){
            //AddToBegining(number);
        //}else
        if(position==length){
            AddToEnd(number);
        }else if(position<1 || position>length){
        }else{
            Node curr=head, prev=curr;
            int i=1;
            while(i<=position){
                if(curr.next!=null){
                    prev = curr;
                    curr = curr.next;
                }
                i++;
            }
            Node T = new Node();
            T.data = number;
            prev.next = T;
            T.next = curr;

            length++;
        }
       
    }
    public void DeleteFromBegining(){
        if(head != null){
            head = head.next;
        }
        length--;
    }
    
    public void DeleteFromEnd(){
        Node prevNode, currNode;
        if(head != null){
            prevNode = currNode = head;
            while(currNode.next != null){
                prevNode = currNode;
                currNode = currNode.next;
            }
            prevNode.next = null;
            tail = prevNode;
        }
        length--;
    }

    public void DeleteGivenContent(int inData){
        Node curr = head, prev = null;
        while(curr!=null && curr.data!=inData){
            prev = curr;
            curr = curr.next;
        }
        if(curr==null){
            System.out.println("Node with content "+inData+" i not found");
        }else{
            if(prev==null){//if first node
                head = curr.next;
            }else{
                prev.next=curr.next;
            }
        }
       length--;
    }

    public void DeleteSpecificNode(int position){
        if(position==1){
            DeleteFromBegining();
        }else if(position==length){
            DeleteFromEnd();
        }else if(position<1 || position>length){
        }else{
            Node curr=head, prev=curr;
            int i=1;
            while(i<position){
                if(curr.next!=null){
                    prev = curr;
                    curr = curr.next;
                }
                i++;
            }
            prev.next=curr.next;
            length--;
        }
    }

    public int LocateNode(int inData){
        Node temp = head;
        int position=1;
        String currentList = "";
        while(temp!=null && temp.data!=inData){
            currentList = currentList + toString(temp.data);
            temp = temp.next;
            position++;
        }
        if(temp==null){
            System.out.println("cant find "+inData);
            position = 0;
        }else{
            currentList = currentList + "[ "+toString(temp.data)+"]";
           Node t = temp.next;
           while(t != null){
               currentList = currentList + toString(t.data);
               t = t.next;

           }
           System.out.println(currentList);
           //JOptionPane.showMessageDialog(null, currentList,
             //     "List Contents", JOptionPane.INFORMATION_MESSAGE);
        }
        return position;
    }
    public void Traverse(){
       Node temp = head, prev = head;
       String currentList = "";
       while(temp != null){
           prev = temp;
           currentList = currentList + toString(temp.data);
           temp = temp.next;
           
       }

       //JOptionPane.showMessageDialog(null, currentList,
              //"List Contents", JOptionPane.INFORMATION_MESSAGE);
       if(prev==null){
           System.out.println("empty list");
           //return "";
       }else{
           System.out.print(currentList);
           System.out.println();
           //return currentList;
       }
    }

    public String toString(int inInteger){
        return inInteger + " ";
    }

    public void bubbleSortList(){
        Node temp = head;
        int[] content = new int[length];
        
        for(int k=0; k<length; k++ ){
            content[k] = temp.data;
            temp = temp.next;
        }
        System.out.println("Before swap:");
        for(int ctr=0; ctr<content.length; ctr++){
            System.out.print(content[ctr]+" ");
        }
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < content.length - j; i++) {
                if (content[i] > content[i+1]){
                    tmp = content[i];
                    content[i] = content[i + 1];
                    content[i + 1] = tmp;
                    swapped = true;
                }
            }
      }
      System.out.println("after swap:");
      for(int ctr=0; ctr<content.length; ctr++){
        System.out.print(content[ctr]+" ");
      }
      temp = head;
      for(int k=0; k<length; k++ ){
            temp.data = content[k];
            temp = temp.next;
      }
    }
    public int getNthData(int position){
        Node temp = head;
        if(position==1){
            return temp.data;
        }else if(position==length){
            return tail.data;
        }else if(position<1 || position>length){
            return 0;
        }else{
            int i=1;
            while(i<position){
                if(temp.next!=null){
                    temp = temp.next;
                }
                i++;
            }
            return temp.data;
        }
               
    }

    public int getLinkedListLength(){
        return length;
    }
}


