package linkedlistnetbeans;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Maeda Hanafi
 * 3/31/10
 * linked list
 */
public class linkedList extends Frame implements ActionListener{
    // Retrieved command code
    String command = "";
    List list ;
    RandomNumberGenerator mr = new RandomNumberGenerator(10,100,1000);
    //JPanel panel = new JPanel();
    int location;
       
    public static void main(String[] args) {
       Frame frame  = new linkedList();
        frame.setResizable(true);
        frame.setSize(1000,700);
        frame.setVisible(true);
    }

    public linkedList(){
        setVisible(true);
        setTitle("Link List Operations");
        // Create Menu Bar
        MenuBar mb = new MenuBar();
        setMenuBar(mb);

        // Create Menu Group Labeled "Utilities"
        Menu utility = new Menu("Utilities");
        mb.add(utility);

        // Create Menu Items
        // Add action Listener
        // Add to "Utilities" Menu Group
        MenuItem miOpen = new MenuItem("New List");
        miOpen.addActionListener(this);
        utility.add(miOpen);

        MenuItem miProcess = new MenuItem("Locate a Value");
        miProcess.addActionListener(this);
        utility.add(miProcess);

        MenuItem miSortedList = new MenuItem("Sort List");
        miSortedList.addActionListener(this);
        utility.add(miSortedList);

        MenuItem miTraverse = new MenuItem("Traverse List");
        miTraverse.addActionListener(this);
        utility.add(miTraverse);

        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        utility.add(miExit);

        //Create Menu Group Labeled "add"
        Menu add = new Menu("Add");
        mb.add(add);

        //Create Menu Items
        // Add action Listener
        // Add to "add" Menu Group
        MenuItem beginning = new MenuItem("Add to Beginning");
        beginning.addActionListener(this);
        add.add(beginning);

        MenuItem anywhere = new MenuItem("Add After Nth Node");
        anywhere.addActionListener(this);
        add.add(anywhere);

        MenuItem end = new MenuItem("Add to End of List");
        end.addActionListener(this);
        add.add(end);

        //Create Menu Group Labeled "delete"
        Menu delete = new Menu("Delete");
        mb.add(delete);

        //Create Menu Items
        // Add action Listener
        // Add to "add" Menu Group
        MenuItem dBeginning = new MenuItem("Delete Beginning");
        dBeginning.addActionListener(this);
        delete.add(dBeginning);

        MenuItem dAnywhere = new MenuItem("Delete Nth Node");
        dAnywhere.addActionListener(this);
        delete.add(dAnywhere);

        MenuItem dContent = new MenuItem("Delete by Content");
        dContent.addActionListener(this);
        delete.add(dContent);

        MenuItem dEnd = new MenuItem("Delete End of List");
        dEnd.addActionListener(this);
        delete.add(dEnd);


        // End program when window is closed
        WindowListener l = new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit(0);
            }
            public void windowActivated(WindowEvent ev){
                repaint();
            }
            public void windowStateChanged(WindowEvent ev){
                repaint();
            }
        };

        ComponentListener k = new ComponentAdapter(){
            public void componentResized(ComponentEvent e){
            repaint();
        }
        };

        // register listeners
        this.addWindowListener(l);
        this.addComponentListener(k);
        //setLayout(new BorderLayout());
        //add(panel, BorderLayout.CENTER);
        //panel.setVisible(true);

    }

    public void actionPerformed (ActionEvent ev){
        // figure out which command was issued
        command = ev.getActionCommand();
        // take action accordingly
        
        if("New List".equals(command)){
            list = new List();
            repaint();
        }else if("Locate a Value".equals(command)){
            location = list.LocateNode(getContent());
            repaint();
        }else if("Sort List".equals(command)){
            list.bubbleSortList();
            list.Traverse();
            repaint();
        }else if("Traverse List".equals(command)){
            list.Traverse();
            repaint();
        }else if("Add to Beginning".equals(command)){
            list.AddToBegining(mr.getRandomNumber());
            list.Traverse();
            repaint();
        }else if("Add After Nth Node".equals(command)){
            list.AddAfterNthNode(mr.getRandomNumber(), getNthValue());
            list.Traverse();
            repaint();
        }else if("Add to End of List".equals(command)){
            list.AddToEnd(mr.getRandomNumber());
            list.Traverse();
            repaint();
        }else if("Delete Beginning".equals(command)){
            list.DeleteFromBegining();
            list.Traverse();
            repaint();
        }else if("Delete Nth Node".equals(command)){
            list.DeleteSpecificNode(getNthValue());
            list.Traverse();
            repaint();
        }else if("Delete by Content".equals(command)){
            list.DeleteGivenContent(getContent());
            list.Traverse();
            repaint();
        }else if("Delete End of List".equals(command)){
            list.DeleteFromEnd();
            list.Traverse();
            repaint();
        }else if("Exit".equals(command)){
            System.exit(0);
        }
 
    }
//********************************************************
// called by repaint() to redraw the screen
//********************************************************

    public void paint(Graphics g){
        if("New List".equals(command)){
            newList(g);
            return;
        }else if("Locate a Value".equals(command)){
            displayLocatedValue(g);
            return;
        }else if("Sort List".equals(command)){
            displayList(g);
            return;
        }else if("Traverse List".equals(command)){
            displayList(g);
            System.out.println("test");
            return;
        }else if("Add to Beginning".equals(command)){
            displayList(g);
            System.out.println("test");
            return;
        }else if("Add After Nth Node".equals(command)){
            displayList(g);
            return;
        }else if("Add to End of List".equals(command)){
            displayList(g);
            return;
        }else if("Delete Beginning".equals(command)){
            displayList(g);
            return;
        }else if("Delete Nth Node".equals(command)){
            displayList(g);
            return;
        }else if("Delete by Content".equals(command)){
            displayList(g);
            return;
        }else if("Delete End of List".equals(command)){
            displayList(g);
            return;
        }

    }
    public void displayList(Graphics g){
       Image node = Toolkit.getDefaultToolkit().getImage("F:\\linkedListNetbeans\\node.gif");
       int y = 100, x = 100;
       for(int i=1; i<=list.getLinkedListLength();i++){
            g.drawImage(node, x, y, this);
            int content = list.getNthData(i);
            g.drawString(""+content, x+5, y+20);
            x = x+80;
            if(i%10==0){
                y = y+40;
                x = 100;
            }
       }
    }

    public void newList(Graphics g){
        g.drawString("new empty List", 100, 100);
    }
    //only display not correst
    public void displayLocatedValue(Graphics g){
        Image node = Toolkit.getDefaultToolkit().getImage("F:\\linkedListNetbeans\\node.gif");
       int y = 100, x = 100;
       System.out.println(location);
       for(int i=1; i<=list.getLinkedListLength();i++){
            g.drawImage(node, x, y, this);
            int content = list.getNthData(i);
            g.drawString(""+content, x+5, y+20);
            if(i==location){
                g.setColor(Color.red);
                g.drawRect(x-3, y-3, 60, 40);
                g.setColor(Color.black);
            }
            x = x+80;
            if(i%10==0){
                y = y+40;
                x = 100;
            }
       }
    }
    public int getNthValue(){
        String string = JOptionPane.showInputDialog(null, "Enter the Nth Node:",
                    "Getting Nth Node", JOptionPane.QUESTION_MESSAGE);
        return Integer.parseInt(string);
    }

    public int getContent(){
        String string = JOptionPane.showInputDialog(null, "Enter the Content:",
                    "Input Content", JOptionPane.QUESTION_MESSAGE);
        return Integer.parseInt(string);
    }
}
