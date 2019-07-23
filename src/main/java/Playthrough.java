package main.java;

import java.util.*;


public class Playthrough {
    private LinkedList<PageNode> choices = new LinkedList<>();
    private PageTree book;

    public Playthrough(PageTree book) {
        this.book = book;
    }

    // From the 1st page.
    public void playGame() {
    	// Use recursion from root.
    	playGameHelper(book.root);
    }
    
    // From specific page number.
    public void playGame(String pageN) {
    	//Use recursion from the node that has the same pageNumber as pageN.
    	playGameHelper(book.getNode(Integer.valueOf(pageN)));
    }
    
    public  void playGameHelper(PageNode current) {
    	// Add current node.
    	choices.add(current);
        System.out.println(current.text);
    	if(!current.isEnding) {
    		//Get choice number from user input.
    		Scanner sc = new Scanner(System.in);
    		int nextPageNumber = sc.nextInt();
    		// Find the child based on the nextPageNumber
    		playGameHelper(current.getChild(nextPageNumber));
      }
    }

    // Remove values from list.
    public void truncateChoices(int pageNumber) {
    	//Find the index of the node which has the same pageNumber.
    	PageNode node = book.getNode(pageNumber);
    	int index = choices.indexOf(node);
    	//Remove nodes which are in the range.
    	choices.subList(index+1, choices.size()).clear();
    }

	public Collection<PageNode> getChoices() {
		return this.choices;
	}
}
