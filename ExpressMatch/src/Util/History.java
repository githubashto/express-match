/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class History<T> extends ArrayList<T>{

    private int index;

    public History() {
        super();
        index=-1;
    }

    public boolean hasPreviousElement(){
        if(index>0)
            return true;
        return false;
    }

    public boolean hasNextElement(){
        if(index<this.size()-1)
            return true;
        return false;
    }

    public T previousElement(){
        index--;
        return currentElement();
    }

    public T currentElement(){
        return get(index);
    }
    public T nextElement(){
        index++;
        return currentElement();
    }


    public boolean addRemovingNexts(T e) {
        if(hasNextElement())
            removeNextElements();
        if(super.add(e)){
            index++;
            return true;
        }
        return false;
    }

    private void removeNextElements(){
        for (int i = this.size()-1; i >index; i--) {
            this.remove(i);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
