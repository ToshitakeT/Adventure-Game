package main.java;

import java.util.*;

public class PageTree {
    public PageNode root;;

    public PageTree(){
    	this.root = root;
    }
    
    public PageTree(Map<Integer, String> map){
    	 root = new PageNode(1, map.get(1), map);
    }

    public PageNode getRoot() {
    	return this.root;
    }
    
    public void setRoot(PageNode root) {
		this.root = root;
	}
    
    PageNode getNode(int pageNumber){
    	Queue<PageNode> queue = new LinkedList<>();
    	queue.add(getRoot());
    	while (!queue.isEmpty()) {
    		PageNode element = queue.remove();
    		if (element.getPageNumber() == pageNumber) {
    			return element;
    		}else {
    			queue.addAll(element.getChildren());
    		}
    	}
		return null;
    }
    
    public List<PageNode> cheat(int aimPageNum){
      return cheatHelper(aimPageNum, root, null);
   }
   
   public List<PageNode> cheatHelper (int aimPageNum, PageNode node, List<PageNode> lastList){
      if(node != null){
         List<PageNode> list = new LinkedList();
         if(lastList != null){
            list.addAll(lastList);
         }
         list.add(node);
         if(node.pageNumber == aimPageNum){
            return list;
         }else if(node.children != null){
            Iterator<PageNode> itr = node.children.iterator();
            while(itr.hasNext()){
               List<PageNode> foundList = cheatHelper(aimPageNum, itr.next(), list);
               if(foundList != null){
                  return foundList;
               }
            }
         }
      }
      return null;
   }
}