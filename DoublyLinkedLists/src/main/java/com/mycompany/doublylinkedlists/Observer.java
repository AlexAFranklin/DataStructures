
package com.mycompany.doublylinkedlists;


public interface Observer<T> {
    public void modified(T oldNode, T newNode);
    public void added(T node);
    public void deleted(T node);
}
