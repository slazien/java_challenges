package com.slazien;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if (comparison < 0) {
                // move right if possible
                if (currentItem.next() != null) {
                    // continue processing until reaching end of list
                    currentItem = currentItem.next();
                } else {
                    // no next item, insert at the end of the list
                    currentItem.setNext(item).setPrevious(currentItem); // since setNext returns the argument
//                    item.setPrevious(currentItem);
                    return true;
                }
                // move left is possible
            } else if (comparison > 0) {
                // insert before currentItem
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(item).setPrevious(currentItem.previous());
//                    item.setPrevious(currentItem.previous());
                    item.setNext(currentItem).setPrevious(item);
//                    currentItem.setPrevious(item);
                } else {
                    item.setNext(this.root).setPrevious(item);
                    this.root = item;
                }

                return true;
            } else {
                // equal
                System.out.println(item.getValue() + " is already present, not added.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // found the item to delete
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    // bypass the item being deleted by pointing to the item directly after it
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }

                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else { // comparison > 0
                // at an item greater than the one to be deleted, so the item is not in the list
                return false;
            }
        }

        // reached the end of the list
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("List is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
