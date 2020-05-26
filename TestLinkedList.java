
/** Test class for the linked list data type defined in SingleLinkedList.java */
public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList firstList = new SingleLinkedList();
        LinkedList secondList = new SingleLinkedList(4);
        int[] list = new int[]{4, 5, 6, 9, 1, 33, 54, 6, 5};
        LinkedList thirdList = new SingleLinkedList(list);

        System.out.print(secondList.get(0) + "\n");

        try {
            System.out.print(secondList.get(4));
        }
        catch (NullPointerException e) {
            System.out.print("That index was out of bounds.\n");
        }

        firstList.append(6);
        firstList.appendFront(25);
        firstList.append(10);
        firstList.append(3);
        firstList.insert(4, 2);
        firstList.insert(6, 1);
        System.out.print("\n========================\n");
        System.out.print("First list:\t");
        firstList.listContents();
        System.out.print("First list reversed:\t");
        firstList.reverse();
        firstList.listContents();

        System.out.print("\n=========================\n");
        System.out.print("Second list:\t");
        secondList.listContents();
        secondList.reverse();
        System.out.print("Second list reversed:\t");
        secondList.listContents();

        System.out.print("\n==========================\n");
        System.out.print("Third List:\t");
        thirdList.listContents();
        System.out.print("Third List reversed:\t");
        thirdList.reverse();
        thirdList.listContents();
    }

}
