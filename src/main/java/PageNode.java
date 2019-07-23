package main.java;

import java.util.Set;
import java.util.*;

public class PageNode {
    public int pageNumber; // page number
    public String text;// Text
    public boolean isEnding;// Determine if its "Ending".
    public Set<PageNode> children;// Set of children.
    
    
    public PageNode(int pageNumber, String text, boolean isEnding, Set<PageNode> children) {
    	this.pageNumber = pageNumber;
    	this.text = text;
    	this.isEnding = isEnding;
    	this.children = children;
    }
    
    public PageNode(int pageNumber, String text, Map<Integer, String> map) {
    	String[] arr = text.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
      if(arr[0].equals("ENDING")){
         this.isEnding = true;
         this.pageNumber = pageNumber;
         this.text = arr[1];
         this.children = null;
      }else{
         this.isEnding = false;
         this.pageNumber = pageNumber;
         this.text = arr[arr.length -1];
         this.children = new HashSet<PageNode>();
         for(int i = 0; i < arr.length-1; i++){
            int newPageNumber = Integer.valueOf(arr[i]);
            this.children.add(new PageNode(newPageNumber, map.get(newPageNumber), map));
         }
      }
    }
    
    int getPageNumber() {
    	return pageNumber;
    }
    
    void addChild(PageNode child) {
        this.children.add(child);
    }
    
    // Getting child node of the given node from pageNum
    PageNode getChild(int pageNum) {
    	for (PageNode child : this.children) {
    		if (child.pageNumber == pageNum) {
                return child;
    		}
    	}
		return null;
    }

    //Determine if its ending or not.
    boolean isEnding() {
        return isEnding;
    }
    
    void setEnding(boolean isEnding) {
    	this.isEnding = isEnding;
    }

	public Set<PageNode> getChildren() {
		return children;
	}
}
