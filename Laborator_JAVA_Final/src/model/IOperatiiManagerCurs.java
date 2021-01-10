/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public interface IOperatiiManagerCurs extends model.IOperatii<model.Curs>
{
    public boolean Register(Student s, model.Curs c);
    public boolean UnRegister(Student s, model.Curs c);
}
