/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class Question {

    public String question;
    public Boolean answer;
    public Boolean used;
    
    public Question(String Vraag, Boolean Antwoord, Boolean used )
    {
        this.question = Vraag;
        this.answer = Antwoord;
        this.used = used;
    
    }
}
