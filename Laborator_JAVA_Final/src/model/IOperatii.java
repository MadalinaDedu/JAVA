/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gaby
 */
public interface IOperatii<T> {
    public void Add(T t);
    public void Delete(T t);
    public void Update(T t);
    public void Search(T t);
}
